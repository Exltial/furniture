/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.utils;

import java.util.UUID;

/**
 * @author tanlei24
 * @date 2019/1/28
 */
public class UUIDUtils {
    public static String getId() {
        String s = UUID.randomUUID().toString().replace("-", "");
        return s;
    }
}
