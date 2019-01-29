/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.dao;

import com.exltial.furniture.entity.PicDetailEntity;
import com.exltial.furniture.entity.PicEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tanlei24
 * @date 2019/1/15
 */
@Mapper
public interface PictureDao {
    List<PicEntity> getList();

    void deleteSku(String skuId);

    void addSku(PicEntity entity);

    List<PicDetailEntity> getDetailBySkuId(String skuId);

    PicEntity getSkuById(String skuId);

    void updateSku(PicEntity entity);
}
