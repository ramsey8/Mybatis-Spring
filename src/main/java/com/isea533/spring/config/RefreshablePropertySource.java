package com.isea533.spring.config;

import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public abstract class RefreshablePropertySource extends MapPropertySource {

    public RefreshablePropertySource(String name, Map<String, Object> source) {
        super(name, source);
    }

    @Override
    public Object getProperty(String name) {
        return this.source.get(name);
    }

    protected abstract void refresh();
}
