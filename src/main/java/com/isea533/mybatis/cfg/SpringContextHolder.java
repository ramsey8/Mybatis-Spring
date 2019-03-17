package com.isea533.mybatis.cfg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component(value = "ctxHolder")
public class SpringContextHolder implements ApplicationContextAware, EnvironmentAware, DisposableBean {

    private static ApplicationContext ctx;
    private static Environment env;

    public static  <T> T getBean(Class<T> beanType) {
        return ctx.getBean(beanType);
    }

    public static <T> T getBean(String beanName) {
        return (T) ctx.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }

    public static String getProperty(String key) {
        return env.getProperty(key);
    }
    @Override
    public void destroy(){
        ctx = null;
    }
}
