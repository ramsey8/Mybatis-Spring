package com.isea533.mybatis.cfg;

import com.isea533.spring.config.DBConfigPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//@Configuration
public class RefreshableConfig {

    @Autowired
    private DBConfigPropertySource propertySource;

    @Autowired
    private ConfigurableEnvironment environment;

    @PostConstruct
    public void init() {

        propertySource.refresh();
        environment.getPropertySources().addLast(propertySource);
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();
        es.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                propertySource.refresh();
            }
        }, 10, 10, TimeUnit.SECONDS);
    }
}
