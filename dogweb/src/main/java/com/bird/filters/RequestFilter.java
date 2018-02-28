package com.bird.filters;

import com.bird.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import util.Token;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * author: 牛虻.
 * time:2018/1/19 0019
 * email:pettygadfly@gmail.com
 * doc:
 */
public class RequestFilter implements Filter {
    private static String[] passType = {"css", "js"};
    private Log log = LogFactory.getLog(RequestFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 不接收get请求
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        String ip = servletRequest.getRemoteAddr();
        if (null == uri) {
            //无
        } else if (!IpFilter.isIllegal() || !IpFilter.checkIp(ip)) {
            //全员禁止登录，黑名单
        } else if (uri.equals("/")
                || uri.endsWith("/login")
                || uri.endsWith("/toLogin")) {
            //域名过滤，非本网站域名直接pass
            //所有后缀直接放过，放过登录
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (uri.endsWith("/ssoLogin")) {
            //其他登录方式
        } else if (uri.contains("/assets/")
                || uri.contains("/article/")
                || uri.contains(".css")
                || uri.contains(".png")
                || uri.contains(".js")) {
            //静态资源放过
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String token = request.getParameter("token");
            if (!StringUtil.notEmpty(token) || !Token.authToken(token)) {
                log.debug("非法请求:" + uri + "+" + ip);
                request.getRequestDispatcher("/user/toLogin").forward(servletRequest, servletResponse);
            } else {
                request.setAttribute("token", token);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    public void destroy() {

    }
}
