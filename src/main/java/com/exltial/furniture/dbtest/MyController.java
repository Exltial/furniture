package com.exltial.furniture.dbtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class MyController {
    @Resource
    public com.exltial.furniture.dbtest.service.Test test;

    @ResponseBody
    @RequestMapping("/")
    public String test() {
        return test.getAll();
    }
}
