package kevin.news.service.test;

import java.util.List;

import junit.framework.Assert;
import kevin.news.service.NewsService;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsTest extends BaseTester {
    private static Logger log = LoggerFactory.getLogger(NewsTest.class);

    @Autowired
    private NewsService newsService;
    
    @Test
    public void test() {
        Assert.assertNotNull(newsService);
    }
    
    @Test
    public void testSelect() {
    }
    
}
