# -*- coding:utf-8 -*-

import os
import configparser
import ast

cf = configparser.ConfigParser()



proDir = os.path.split(os.path.realpath(__file__))[0]
# proDir = os.path.dirname(os.path.realpath(__file__))  与上面一行代码作用一样
configPath = os.path.join(proDir, "table_config.text")
path = os.path.abspath(configPath)

cf.read(path)  # 读取配置文件，如果写文件的绝对路径，就可以不用os模块

class FileConfig:

    #filename = cf.get("file", "filename")
    fileDir = cf.get("file", "fileDir")
    package = cf.get("file", "package")
    wordName = cf.get("file", "wordName")
    table_columns = cf.get("file", "table_columns")
    table_dict = cf.get("file", "table_dict")
    table_dict = ast.literal_eval(table_dict)






