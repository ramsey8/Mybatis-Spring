package com.isea533.mybatis.mapper;

import com.isea533.mybatis.model.Country;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CountryMapper extends Mapper<Country> {

    int save(@Param("list") List<Country> country, @Param("dbType") String dbType);

    List<Country> findByEntity(Country country);

    int updateByEntity(Country country);
}