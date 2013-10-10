@title 生成thrift接口代码
@echo start

echo 0 > result.txt
FOR %%t IN (4 8 16 24 32 40 48 56 64) DO (
	echo %%t >> result.txt
	ab -n 10000 -c %%t "http://localhost:8888/news/search?startIndex=0&count=10" | findstr "Failed Requests" >> result.txt
)


@echo  完毕
@pause