@title 生成thrift接口代码
@echo off

thrift-0.9.0.exe -o . -gen java news.thrift

@echo on
@echo 请稍后...
@echo off
ping 127.0.0.1 -n 3 > nul

xcopy .\gen-java ..\src\main\java /E /Y

@echo on
@echo 生成thrift接口代码 完毕
@pause