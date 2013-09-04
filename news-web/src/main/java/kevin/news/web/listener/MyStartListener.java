package kevin.news.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyStartListener implements ServletContextListener{
    private static Logger log = LoggerFactory.getLogger(MyStartListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("I am starting....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("I am going.....bye....");
    }

}
