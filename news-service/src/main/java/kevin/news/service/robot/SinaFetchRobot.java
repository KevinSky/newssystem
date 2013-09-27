package kevin.news.service.robot;

import java.util.List;

import kevin.news.service.robot.domain.FetchNews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SinaFetchRobot implements FetchRobot {
    private static Logger log = LoggerFactory.getLogger(SinaFetchRobot.class);

    @Override
    public List<FetchNews> fetch() {
        
//        String html = getHtml();
//        System.out.println(html);
        return null;
    }
    
    /*private String getHtml() {
        String html = null;
        HttpClient client = new HttpClient();
        HttpMethod method= new GetMethod("http://www.qq.com/");
        try {
            HostConfiguration conf = new HostConfiguration();
            client.executeMethod(method);
            html = method.getResponseBodyAsString();
            html = new String(html.getBytes(), "utf-8");
        } catch (HttpException e) {
            log.error("get sina html error.", e);
        } catch (IOException e) {
            log.error("get sina html error.", e);
        }
        return html;
    }
    
    public static void main(String[] args) {
        SinaFetchRobot client =  new SinaFetchRobot();
//        client.fetch();
        String html = "<a>中国</a><b class=\"test\">电影票</b><a class=\"test\">哈哈</a>";
        client.parseA(html);
    }
    
    private List<String> parseA(String html) {
        Pattern p = Pattern.compile("<a.*>(.*)</a>");
        Matcher m = p.matcher(html);
        while(m.find()) {
            System.out.println(m.group(1));
        }
        return null;
    }*/
    
    

}
