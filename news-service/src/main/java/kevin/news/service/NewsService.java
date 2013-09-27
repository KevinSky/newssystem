package kevin.news.service;

import java.util.List;

import kevin.news.thrift.News;

public interface NewsService {

    List<News> getNewsList(int start, int count);
}
