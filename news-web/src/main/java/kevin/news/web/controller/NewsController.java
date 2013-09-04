package kevin.news.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kevin.news.thrift.News;
import kevin.news.thrift.NewsService.Iface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duowan.pooling.thrift.ThriftClientFactory;
import com.duowan.pooling.thrift.ThriftClientWrapper;

@Controller
@RequestMapping("/info")
public class NewsController {
    private static Logger log = LoggerFactory.getLogger(NewsController.class);

    @Resource(name = "noticeClientFactory")
    private ThriftClientFactory<Iface> factory;

    private ThriftClientWrapper<Iface> createThriftWrap() {
        try {
            return factory.createClient();
        } catch (Exception e) {
            log.error("get connection error", e);
            throw new RuntimeException("get connection error", e);
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public Map<String, Object> getUserBasicInfo(@Param("startIndex") int startIndex, @Param("count") int count) {
        Object data = null;
        int status = 0;
        String msg = "";

        Map<String, Object> result = new HashMap<String, Object>();
        long startTime = System.currentTimeMillis();

        ThriftClientWrapper<Iface> thrift = createThriftWrap();
        try {
            List<News> news = thrift.getClient().getNews(startIndex, count);
            data = news;
        } catch (Exception e) {
            status = 999;
            msg = "出错啦";
            log.error("search error, startIndex:" + startIndex + ", count:" + count, e);
        } finally {
            thrift.close();
        }
        result.put("status", status);
        result.put("data", data);
        result.put("message", msg);
        long endTime = System.currentTimeMillis();

        log.info("search. startIndex:{}, count:{}, time:{}", new Object[] { startIndex, count, endTime - startTime });
        return result;
    }
}
