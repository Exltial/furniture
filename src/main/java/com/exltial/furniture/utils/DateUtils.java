/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.utils;

import org.assertj.core.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tanlei24
 * @date 2019/1/28
 */
public class DateUtils {
    private DateUtils() {
        //do nothing here
    }
    public static String getNow() {
        Date now = DateUtil.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(now);
    }

}
