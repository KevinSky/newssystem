package kevin.news.service.thrift;

import java.util.List;

import kevin.news.service.NewsService;
import kevin.news.thrift.News;
import kevin.news.thrift.NewsService.Iface;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("newsServiceHandler")
public class NewsServiceHandler implements Iface{
    private static Logger log = LoggerFactory.getLogger(NewsServiceHandler.class);
    
    @Autowired
    private NewsService newsService;
    
    public NewsServiceHandler(){
        log.info("UserServiceHandler is newing");
    }

    @Override
    public List<News> getNews(int startIndex, int count) throws TException {
        return newsService.getNewsList(startIndex, count);
    }
}
