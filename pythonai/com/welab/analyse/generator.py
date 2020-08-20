# coding=utf-8
#@author sky.li
import sys

'''
生成java 文件工具类
@author sky
'''

reload(sys)
sys.setdefaultencoding('utf-8')


class Generator:

    def __init__(self, filename, fileDir, package):
        self.fileDir = fileDir
        self.filename = filename
        self.package = package

    def write_file(self, tableDatas):
        if (self.filename == ''):
            print 'filename is  null or fileDir  is' \
                  'null '
            return
        else:
            """ 文件写入"""
            file_name = self.filename
            # 以写入的方式打开
            if(self.fileDir != ''):
                f = open(self.fileDir+file_name, 'w')
            else:
                f = open(file_name, 'w')
            # 写入内容
            f.write('package %s;' % self.package)
            # 换行符
            f.write('\n')
            f.write('\n')
            f.write('\n')
            # 写入import内容
            importList = self.dynamic_import(tableDatas)
            for  im in importList:
                f.write('\n %s' % im)

        f.write('\nimport lombok.Data;')

        f.write('\n')
        f.write('\n')
        f.write('\n')
        f.write('@Data')
        className = self.filename[:-5]
        f.write('\npublic  class %s {' % className)
        f.write('\n')

        for word in tableDatas:
            f.write(" \n  /** \n * 字段含义： %s \n * 备注：  %s \n */" % (word.fieldName,word.comment))
            f.write("\n  private %s %s ;" % (word.fieldType, word.field))

        f.write('\n }')
        f.close()


    def dynamic_import(self, tableDatas):
        import_dis = {'BigDecimal': 'import java.math.BigDecimal;'}
        list = []
        for word in tableDatas:
            if (import_dis.has_key(word.fieldType) and list.__contains__(import_dis.get(word.fieldType)) == 0):
                list.append(import_dis.get(word.fieldType))

        return list
