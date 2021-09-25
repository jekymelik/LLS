package com.example.springboot04webrestfulcrud.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterr) throws IOException, ServletException {
        System.out.println("MyFilter process..");
        filterr.doFilter(request,response);

    }
}
