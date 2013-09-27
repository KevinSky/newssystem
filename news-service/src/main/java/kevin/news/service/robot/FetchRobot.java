package kevin.news.service.robot;

import java.util.List;

import kevin.news.service.robot.domain.FetchNews;

public interface FetchRobot {

    List<FetchNews> fetch();

}
