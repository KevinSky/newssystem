package kevin.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		String propertyFileLocation = "release.properties";
		if (checkDev(args))
			propertyFileLocation = "dev.properties";

		System.getProperties().setProperty("property.file",
				propertyFileLocation);

		// String[] resources = new
		// String[]{"classpath:META-INF/spring/jetty.xml"};
		String[] resources = new String[] { "classpath:META-INF/spring/application-service.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				resources);
		context.start();
		log.info("Context started ...:" + propertyFileLocation);

//		ThriftServer server = new ThriftTThreadPoolServer();
//		ThriftServer server = new ThriftTHsHaServer();
		ThriftServer server = new ThriftTThreadedSelectorServer();

		server.start();
	}

	private static boolean checkDev(String[] args) {
		for (String a : args) {
			String[] value = a.split("=");
			if ("-dev".equals(value[0]) && "true".equals(value[1])) {
				return true;
			}
		}
		return false;
	}
}
