@title ����thrift�ӿڴ���
@echo off

thrift-0.9.0.exe -o . -gen java news.thrift

@echo on
@echo ���Ժ�...
@echo off
ping 127.0.0.1 -n 3 > nul

xcopy .\gen-java ..\src\main\java /E /Y

@echo on
@echo ����thrift�ӿڴ��� ���
@pause