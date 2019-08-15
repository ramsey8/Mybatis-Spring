package com.isea533.mybatis.service;

import com.isea533.mybatis.model.ApplicationProperties;

import java.util.List;

public interface ApplicationPropertiesService extends  IService<ApplicationProperties>{

    String getValue(String key);

    List<ApplicationProperties> findAll();
}
