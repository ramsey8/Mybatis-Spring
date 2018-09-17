package com.isea533.mybatis.service;

import com.isea533.mybatis.model.ApplicationProperties;

public interface ApplicationPropertiesService extends  IService<ApplicationProperties>{

    String getValue(String key);
}
