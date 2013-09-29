package kevin.news.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kevin.lib.pool.thrift.ThriftClientPool;
import kevin.news.thrift.News;
import kevin.news.thrift.NewsService;
import kevin.news.thrift.NewsService.Iface;
import kevin.news.web.domain.WebNews;
import kevin.news.web.thrift.NewsServiceClient;

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

	@Resource(name = "thriftClientPool")
	private ThriftClientPool thriftClientPool;

	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> getUserBasicInfo(
			@Param("startIndex") int startIndex, @Param("count") int count) {
		Object data = null;
		int status = 0;
		String msg = "";

		long startTime = System.currentTimeMillis();
		try {
			NewsService.Client client = (NewsService.Client) thriftClientPool
					.getConnection();
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
			thriftClientPool.returnCon(client);
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
	public Map<String, Object> getUserBasicInfo() {
		Object data = null;
		int status = 0;
		String msg = "";

		long startTime = System.currentTimeMillis();
		try {
			NewsService.Client client = (NewsService.Client) thriftClientPool
					.getConnection();
			List<News> news = client.getNews(0, 10);
			List<WebNews> newsList = new ArrayList<WebNews>();
			for (News _n : news) {
				WebNews n = new WebNews();
				n.setId(_n.getId());
				n.setTitle(_n.getTitle());
				n.setUrl(_n.getUrl());
				newsList.add(n);
			}
			data = newsList;
			thriftClientPool.returnCon(client);
		} catch (Exception e) {
			status = 999;
			msg = "出错啦";
			log.error("search error, startIndex:" + 0 + ", count:" + 10, e);
		}
		long endTime = System.currentTimeMillis();

		log.info("search. startIndex:{}, count:{}, time:{}", new Object[] { 0,
				10, endTime - startTime });
		return resultMap(status, msg, data);
	}
}
