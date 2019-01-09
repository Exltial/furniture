/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.exltial.furniture.entity.LoginEntity;
import com.exltial.furniture.utils.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class MyTest {
    @Test
    public void test() {
        LoginEntity loginEntity = JSON.parseObject("{\"userName\":\"tony\",\"passWord\":\"asdf105\"}", new TypeReference<LoginEntity>() {
        });
        log.info(JSON.toJSONString(loginEntity));
    }

    @Test
    public void sha256() {
        log.info(SHA256Utils.coding("tony"));
        log.info(SHA256Utils.coding("asdf105"));
    }
}
