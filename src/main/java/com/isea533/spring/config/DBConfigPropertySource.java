package com.isea533.spring.config;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.isea533.mybatis.model.ApplicationProperties;
import com.isea533.mybatis.service.ApplicationPropertiesService;
import org.apache.commons.collections.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DBConfigPropertySource extends RefreshablePropertySource {

    public static final Map<String, ApplicationProperties> cache = new ConcurrentHashMap<>();

    @Autowired
    private ApplicationPropertiesService applicationPropertiesService;

    @Autowired
    private ConfigurableApplicationContext ctx;

    public DBConfigPropertySource() {
        super("DBConfig", new HashMap<>());
    }

    @Override
    public void refresh() {
        List<ApplicationProperties> properties = applicationPropertiesService.findAll();

        Sets.SetView<ApplicationProperties> difference = Sets.difference(Sets.newHashSet(properties), Sets.newHashSet(cache.values()));
        if (difference.size() > 0) {
            int size = cache.size();
            for (ApplicationProperties property : properties) {
                this.source.put(property.getKey(), property.getValue());
                cache.put(property.getKey(), property);
            }
            if (size != 0) {
                HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
                WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext( session.getServletContext());
                if (context.getParent() !=null) {
                    ((AbstractRefreshableApplicationContext) context.getParent()) .refresh();
                }
                ((AbstractRefreshableApplicationContext) context).refresh();
                ctx.refresh();
            }
        }
    }
}
