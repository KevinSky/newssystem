package kevin.news.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kevin.lib.pool.thrift.ThriftClientFactory;
import kevin.lib.pool.thrift.ThriftClientWrap;
import kevin.news.thrift.News;
import kevin.news.thrift.NewsService;
import kevin.news.web.domain.WebNews;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {
	private static Logger log = LoggerFactory.getLogger(NewsController.class);

	@Resource(name = "thriftClientFactory")
	private ThriftClientFactory<NewsService.Client> thriftClientFactory;

	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> getUserBasicInfo(
			@Param("startIndex") int startIndex, @Param("count") int count) {
		Object data = null;
		int status = 0;
		String msg = "";

		long startTime = System.currentTimeMillis();
		try {
			ThriftClientWrap<NewsService.Client> wrap = thriftClientFactory.getClientWrap();
			List<News> news = wrap.getClient().getNews(startIndex, count);
			List<WebNews> newsList = new ArrayList<WebNews>();
			for (News _n : news) {
				WebNews n = new WebNews();
				n.setId(_n.getId());
				n.setTitle(_n.getTitle());
				n.setUrl(_n.getUrl());
				newsList.add(n);
			}
			data = newsList;
			wrap.close();
		} catch (Exception e) {
			status = 999;
			msg = "出错啦";
			log.error("search error, startIndex:" + startIndex + ", count:"
					+ count, e);
		}
		long endTime = System.currentTimeMillis();

		log.info("search. startIndex:{}, count:{}, time:{}", new Object[] {
				startIndex, count, endTime - startTime });
		return resultMap(status, msg, data);
	}
	
	@RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> test() {
	    int startIndex = 0;
	    int count = 0;
        Object data = null;
        int status = 0;
        String msg = "";

        long startTime = System.currentTimeMillis();
        try {
            TSocket socket = new TSocket("localhost",9999);
            TBinaryProtocol protocol = new TBinaryProtocol(socket);
            NewsService.Client client = new NewsService.Client(protocol);
            socket.open();
            List<News> news = client.getNews(startIndex, count);
            List<WebNews> newsList = new ArrayList<WebNews>();
            for (News _n : news) {
                WebNews n = new WebNews();
                n.setId(_n.getId());
                n.setTitle(_n.getTitle());
                n.setUrl(_n.getUrl());
                newsList.add(n);
            }
            data = newsList;
        } catch (Exception e) {
            status = 999;
            msg = "出错啦";
            log.error("search error, startIndex:" + startIndex + ", count:"
                    + count, e);
        }
        long endTime = System.currentTimeMillis();

        log.info("search. startIndex:{}, count:{}, time:{}", new Object[] {
                startIndex, count, endTime - startTime });
        return resultMap(status, msg, data);
    }
	
}
