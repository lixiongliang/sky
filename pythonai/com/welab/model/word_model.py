#!/usr/bin/python
# -*- coding: UTF-8 -*-
import  json

class WordModel:
    #参数字段	参数名称	参数类型	空值（否为必填）	默认值	备注

    def __init__(self,field = '',fieldName = '',fieldType = '',must = '',comment = ''):
        self.field = field
        self.fieldName = fieldName
        self.fieldType = fieldType
        self.must = must
        self.comment = comment

    def display(self):
         print '>>>>{self.field},{self.fieldName},{self.fieldType},{self.must},{self.comment}'.format(self=self)

    def prn_obj(obj):
        print '\n'.join(['%s:%s' % item for item in obj.__dict__.items()])

    #channelid	渠道来源	String(40)	Y	渠道来源
# w1 = WordModel("channelid", "渠道来源","String(40)","y","渠道来源")
# w1.display()
#str = '1.1.1提前还款试算<table_name>JavaBean1</table_name>'
#print str.find('<table_name>'), str.find('</table_name>')
#print str[str.find('<table_name>')+12:str.find('</table_name>')]
#print str[0:str.find('<table_name>')]