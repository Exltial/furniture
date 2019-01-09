/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    String getPassWordById(String userName);
}

