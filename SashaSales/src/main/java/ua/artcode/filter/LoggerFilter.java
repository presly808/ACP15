package ua.artcode.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by work on 11.12.2016.
 */
public class LoggerFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(LoggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("created LoggerFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)){
            // nope
        } else {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            LOG.info(String.format("Request %s", req.getRequestURI()));
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
