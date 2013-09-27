package kevin.news.service.impl;

import java.util.List;

import kevin.news.service.NewsService;
import kevin.news.service.database.dao.CustomNewsMapper;
import kevin.news.thrift.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    private CustomNewsMapper customNewsMapper;

    @Override
    public List<News> getNewsList(int start, int count) {

        return customNewsMapper.getNewsList(start, count);
    }

}
