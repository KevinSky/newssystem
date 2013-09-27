package kevin.news.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * appId为0003
 * appVer为app版本号
 * ver第一个正式版本前均为1
 * @author huangjinjie@yy.com
 *
 */
public class BaseController {
    protected static final int SUCCESS_CODE = 1;
    protected static final int ERROR_CODE = -1;

    protected Map<String, Object> resultMap(int code, String message, Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", code);
        result.put("data", data);
        result.put("message", message);

        return result;
    }
}
