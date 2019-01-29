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
    private UUIDUtils() {
        //do nothing here
    }

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
