package com.wj.interceptor;

import com.wj.filter.BodyReaderHttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wangjun
 * @date 18-2-23 下午2:41
 * @description
 * @modified by
 */
public class HttpLogInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(HttpLogInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String url = httpServletRequest.getRequestURL().toString();
        String queryString = httpServletRequest.getQueryString();
        String methodName = httpServletRequest.getMethod();
        if (StringUtils.isEmpty(queryString)) {
            String data = new BodyReaderHttpServletRequestWrapper(httpServletRequest).getBodyString(httpServletRequest);
            System.out.println(data);
            //HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(httpServletRequest);
            //InputStream inputStream = wrapper.getInputStream();
            /*InputStream inputStream = httpServletRequest.getInputStream();
            StreamUtils.copyToByteArray(httpServletRequest.getInputStream());
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);*/
            if (StringUtils.isEmpty(data)) {
                logger.info("request url=" + url + ", method=" + methodName);
            }
            else {
                logger.info("request url=" + url + ", method=" + methodName + ", param: " + data);
            }

        }
        else {
            logger.info("request url=" + url + ", method=" + methodName + ", param: " + queryString);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
