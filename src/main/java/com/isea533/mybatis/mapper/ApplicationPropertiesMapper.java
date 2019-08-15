package com.isea533.mybatis.mapper;

import com.isea533.mybatis.model.ApplicationProperties;

import java.util.List;

public interface ApplicationPropertiesMapper {

    String getValue(String key);

    List<ApplicationProperties> findAll();
}
