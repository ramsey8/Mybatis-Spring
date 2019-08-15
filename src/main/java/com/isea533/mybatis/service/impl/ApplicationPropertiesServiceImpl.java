package com.isea533.mybatis.service.impl;

import com.isea533.mybatis.mapper.ApplicationPropertiesMapper;
import com.isea533.mybatis.model.ApplicationProperties;
import com.isea533.mybatis.service.ApplicationPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationPropertiesServiceImpl implements ApplicationPropertiesService {

    @Autowired
    private ApplicationPropertiesMapper mapper;

    @Override
    public String getValue(String key) {
        return mapper.getValue(key);
    }

    @Override
    public List<ApplicationProperties> findAll() {
        return mapper.findAll();
    }

    @Override
    public ApplicationProperties selectByKey(Object key) {
        return null;
    }

    @Override
    public int save(ApplicationProperties entity) {
        return 0;
    }

    @Override
    public int delete(Object key) {
        return 0;
    }

    @Override
    public int updateAll(ApplicationProperties entity) {
        return 0;
    }

    @Override
    public int updateNotNull(ApplicationProperties entity) {
        return 0;
    }

    @Override
    public List<ApplicationProperties> selectByExample(Object example) {
        return null;
    }
}
