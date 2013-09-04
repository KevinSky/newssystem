package kevin.news.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URLFilter implements Filter{
    private static Logger log = LoggerFactory.getLogger(URLFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("I am initiating....");
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURL().toString();
        String uri = req.getRequestURI();
        String encoding = req.getCharacterEncoding();
        String sessionId = req.getRequestedSessionId();
        String servletpath = req.getServletPath();
        log.debug("receive a request {url:{},uri:{},encoding:{},sessionId:{},servletPath:{}}", new Object[] { url, uri,
                encoding, sessionId, servletpath });
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("go to die");
    }

}
