/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
    public void sha256() {
    }
}

@Data
class A {
    List<String> list;
    Integer num;
}
