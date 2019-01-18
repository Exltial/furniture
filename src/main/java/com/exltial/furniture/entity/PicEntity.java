/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.entity;

import lombok.Data;

/**
 * @author:tanlei24
 * @date:2019/1/15
 */
@Data
public class PicEntity {
    private Long id;
    private double price;
    private String skuUrl;
    private String skuName;
    private String skuDescr;
    private String skuType;
    private String skuSize;
    private String createTime;
    private int status;
    private Long skuId;
}
