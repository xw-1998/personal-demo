package com.itself.example.filter;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 第一种方式：定义一个过滤器实现Filter接口，需要在application启动器上添加@ServletComponentScan注解配合使用
 * @Author xxw
 * @Date 2023/01/04
 */
@Order(1) //示如果有多个拦截器的话就是设置这个拦截器的运行等级，数字越小，越先执行
@WebFilter(filterName = "myFilter",urlPatterns = {"/*"}) //urlPatter表示要拦截的URL资源，可以是一个或者多个
public class MyFilter implements Filter {

    /**
     * 方法只会执行一次，初始化过滤器
     * @param filterConfig The configuration information associated with the
     *                     filter instance being initialised
     *
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
        System.out.println("初始化过滤器");
    }

    /**
     * 核心方法，配置过滤器的逻辑代码
     * @param servletRequest  The request to process
     * @param servletResponse The response associated with the request
     * @param filterChain    Provides access to the next filter in the chain for this
     *                 filter to pass the request and response to for further
     *                 processing
     *
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入目标资源之前先干点啥====");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("处理一下服务端返回的response====");
    }


    /**
     * 会在项目停止或者是项目重新部署的时候才会执行
     */
    @Override
    public void destroy() {
        // Filter.super.destroy();
        System.out.println("过滤器被销毁====");
    }
}
