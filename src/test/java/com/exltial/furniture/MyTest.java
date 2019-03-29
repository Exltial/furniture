/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Slf4j
public class MyTest {
    @Test
    public void test() {
        String uuid = UUID.randomUUID().toString();
        log.info(uuid);
    }

    @Test
    public void sha256() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = String.valueOf(format.parse("2018-12-01 00:00:00").getTime());
        log.info(s);
        String s1 = String.valueOf(format.parse("2019-01-01 00:00:00").getTime());
        log.info(s1);
    }

    @Test
    public void test1() {
        String s = "{skuId:\"1231445\"}";

        SkuId skuId = JSON.parseObject(s, SkuId.class);
        System.out.println(skuId);
    }
}

@Data
class SkuId {
    private String skuId;
}
@Data
class A {
    List<String> list;
    Integer num;
}
