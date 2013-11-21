package kevin.news.web.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

public class MyExceptionHandle implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        Map<String, Object> result = new HashMap<String, Object>();
        
        result.put("code", -1);
        result.put("message", ex.getMessage());
        ModelAndView model = new ModelAndView();
        MappingJacksonJsonView v = new MappingJacksonJsonView();
        v.setAttributesMap(result);
        model.setView(v);
        return model;
    }

}
