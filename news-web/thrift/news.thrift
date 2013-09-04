namespace java kevin.news.thrift

struct News
{
	1: i64 id;				//id
	2: string title;
	3: string url;
}

service NewsService
{
	list<News> getNews(1:i32 startIndex, 2:i32 count)
}
