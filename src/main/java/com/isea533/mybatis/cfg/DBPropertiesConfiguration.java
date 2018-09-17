package com.isea533.mybatis.cfg;

import com.isea533.mybatis.mapper.ApplicationPropertiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Properties;
import java.util.regex.Pattern;

@Configuration
public class DBPropertiesConfiguration {

    @Autowired
    private ApplicationPropertiesMapper mapper;

    @Autowired
    private ConfigurableEnvironment environment;

    @PostConstruct
    public void obtainConfigFromDB() {

        MutablePropertySources propertySources = environment.getPropertySources();

        String value = mapper.getValue("name");
        Properties properties = new Properties();
        properties.put("name", value);
        PropertiesPropertySource pps = new PropertiesPropertySource("dbPropertySource", properties);
        Pattern compile = Pattern.compile("^applicationConfig.*");

        String name = "";
        Boolean flag = false;
        if (propertySources.size() > 0) {
            for (PropertySource ps : propertySources) {
                if (compile.matcher((name = ps.getName())).matches()) {
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {
            propertySources.addBefore(name, pps);
        } else {
            propertySources.addFirst(pps);
        }
    }
}
