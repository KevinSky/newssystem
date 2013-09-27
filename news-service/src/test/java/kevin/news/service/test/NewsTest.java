package kevin.news.service.test;

import java.util.List;

import junit.framework.Assert;
import kevin.news.service.NewsService;
import kevin.news.service.database.dao.CustomNewsMapper;
import kevin.news.service.database.gen.model.News;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsTest extends BaseTester {
    private static Logger log = LoggerFactory.getLogger(NewsTest.class);

    @Autowired
    private NewsService newsService;

    @Autowired
    private CustomNewsMapper customNewsMapper;

    @Test
    public void test() {
        Assert.assertNotNull(newsService);
    }

    public void testSelect() {
        List d = newsService.getNewsList(0, 2);
        System.out.println(d.size());
    }

    @Test
    public void testCreateData() {
        long start = System.currentTimeMillis();
        int total = 50000 - 15840;
        final int size = total / 10;

        for (int j = 0; j < 10; j++) {
            (new Thread() {
                @Override
                public void run() {
                    String url = "http://www.yy.com";
                    String host = "www.yy.com";
                    String title = "-次体检-人生";
                    for (int i = 1; i <= size; i++) {
                        News news = new News();
                        news.setUrl(url + "/test/" + i);
                        news.setHost(host);
                        news.setTitle(i + title);
                        customNewsMapper.insertSelective(news);
                    }
                }
            }).start();
        }
        long end = System.currentTimeMillis();
        try {
            Thread.sleep(3600000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("总耗时：" + (end - start));
    }

}
