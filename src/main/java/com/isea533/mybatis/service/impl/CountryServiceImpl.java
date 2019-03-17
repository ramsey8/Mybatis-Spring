package com.isea533.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.model.ApplicationProperties;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.service.ApplicationPropertiesService;
import com.isea533.mybatis.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
@Service("countryService")
public class CountryServiceImpl extends BaseService<Country> implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private ApplicationPropertiesService applicationPropertiesService;

    @Override
    public List<Country> selectByCountry(Country country, int page, int rows) {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(country.getCountryname())) {
            criteria.andLike("countryname", "%" + country.getCountryname() + "%");
        }
        if (StringUtil.isNotEmpty(country.getCountrycode())) {
            criteria.andLike("countrycode", "%" + country.getCountrycode() + "%");
        }
        if (country.getId() != null) {
            criteria.andEqualTo("id", country.getId());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

    @Override
    public int save(Country country, String dbType) {
        return countryMapper.save(Arrays.asList(country), dbType);
    }

    @Override
    public List<Country> findByEntity(Country country) {
        return countryMapper.findByEntity(country);
    }

    @Override
    public int updateByEntity(Country country) {
        return this.countryMapper.updateByEntity(country);
    }

    @Transactional
    public void testTransactional() {
        Country country = new Country();
        country.setCountryname("xxxx");
        country.setId(2222);
        country.setCountrycode("xxxx");
        this.save(country);

//        ApplicationProperties ap = new ApplicationProperties();
//        ap.setId(2222);
//        throw new RuntimeException();
    }

}
