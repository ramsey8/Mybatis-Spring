package com.isea533.mybatis.filter;

import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author liuzh
 * @since 2017/10/8.
 */
//@Component
public class MapperFilter implements Filter {

    @Value("${sign.filter.mappings}")
    private String[] mappings;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        List<Country> countries = countryMapper.selectAll();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
