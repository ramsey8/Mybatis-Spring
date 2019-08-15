package com.isea533.mybatis.controller.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValueController {

//    @Value("${name}")
    private String name;

    @RequestMapping("/query/name")
    public @ResponseBody
    String queryName() {
        return name;
    }
}
