# coding=utf-8
import sys
'''
解析word  的table，程序执行入口
@author sky
'''
reload(sys)
sys.setdefaultencoding('utf-8')
import docx
from docx.oxml.text.paragraph import CT_P
from docx.oxml.table import CT_Tbl
from docx.table import Table
from docx.text.paragraph import Paragraph
from word_model import WordModel
from generator import Generator
from readConfig import FileConfig
from table_info import TableInfo

fileConfig = FileConfig()
doc = docx.Document(fileConfig.wordName)
table_data = fileConfig.table_columns
dict = fileConfig.table_dict

# 解析word里面的所有段落
def table_nested_parsing(cell, current_row, current_col):
    for block in cell._element:
        if isinstance(block, CT_P):
             #(Paragraph(block, cell).text)
             return (Paragraph(block, cell).text)
        if isinstance(block, CT_Tbl):
            block = Table(block, cell)
            for row in range(len(block.rows)):
                for col in range(len(block.columns)):
                    cell_table = block.cell(row, col)
                    table_nested_parsing(cell_table, row, col)

# 解析word里面的所有表格
def doc_parsing(doc):
    listField = []
    listTable = []
    fieldName = ''
    fileDesc = ''
    for doc_part in doc.element.body:
        if isinstance(doc_part, CT_P):
         pg = Paragraph(doc_part, doc).text
         if(pg.find('<table_name>') >= 0 and pg.find('</table_name>') > 0):
              fieldName = pg[pg.find('<table_name>') + 12:pg.find('</table_name>')]+'.java'
              fileDesc = pg[0:pg.find('<table_name>')]

        if (isinstance(doc_part, CT_Tbl) and fieldName != ''):
            tableinfo = TableInfo()
            tableinfo.fileName = fieldName
            tableinfo.fileDesc = fileDesc
            tb1 = Table(doc_part, doc)
            isMytable = doc_mytable(tb1)
            if (isMytable == False):
                continue
            for row in range(len(tb1.rows)):
                if (row == 0):
                    continue
                w2 = WordModel()
                w2.field = getCellText(tb1, row, dict.get("field") if dict.has_key("field") else '')
                w2.fieldName = getCellText(tb1, row, dict.get("fieldName") if dict.has_key("fieldName") else '')
                w2.fieldType = getCellText(tb1, row,  dict.get("fieldType") if dict.has_key("fieldType") else '')
                w2.comment = getCellText(tb1, row, dict.get("comment") if dict.has_key("comment") else '')
                w2.must = getCellText(tb1, row, dict.get("must") if dict.has_key("must") else '')
                # print w2.display()
                w2.fieldType = dataConvert(w2.fieldType)
                listField.append(w2)
                # for col in range(len(tb1.columns)):
                #     cell_table = tb1.cell(row, col)
                #     table_nested_parsing(cell_table, row, col)
            tableinfo.listField = listField
            listTable.append(tableinfo)
            fieldName = ''
            listField = []
    return listTable


# 解析表格的行，
def getCellText(tb1, row, col):
    if (col > len(tb1.columns) or col == ''):
        return ''
    return table_nested_parsing(tb1.cell(row, col), row, col)


# 判断表格是否需要解析，过滤没有用的表格
def doc_mytable(tb1):
    for row in range(len(tb1.rows)):
        t = 0
        for col in range(len(tb1.columns)):
            cell_table = tb1.cell(row, col)
            if (cell_table.text in table_data):
                t = t + 1
        return t > 1

#解析字段类型，数据类型转换
def dataConvert(type):
    list = ['int','integer','double','string','tinyint','date','decimal','bigdecimal','list']
    _type = type.lower()
    if(_type in list):
        if(_type == 'tinyint' or _type == 'int'):
            return "Integer"
        elif (_type == 'decimal' or _type == 'bigdecimal'):
            return "BigDecimal"
        else:
         return _type.capitalize()
    else:
        v_type = ''
        for e in list:
          if(_type.find(e) >= 0 and (e == 'int' or e == 'tinyint')):
              return  'Integer'
          elif(_type.find(e) >= 0 and (e == 'decimal' or e == 'bigdecimal')):
             return  "BigDecimal"
          elif(_type.find(e) >= 0):
              return e.capitalize()
    return type

#程序主入口，执行此方法生成表格的javaBean
if __name__ == "__main__":
    listTable = doc_parsing(doc)
    if(len(listTable) == 0):
        print '解析的word 表格数据为0'
        exit(0)
    else:
        print 'Word scan file completed, number of parsing tables : %d' % len(listTable)
    for table in listTable:
        print 'file download succeed : %s' % (table.fileName)
        g1 = Generator(table.fileName, fileConfig.fileDir, fileConfig.package)
        file_name = g1.write_file(table.listField)

