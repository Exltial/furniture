package com.exltial.furniture.dbtest.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestImpl implements Test {
    @Resource
    public com.exltial.furniture.dbtest.dao.Test test;

    @Override
    public String getAll() {
        return test.getAll();
    }
}
