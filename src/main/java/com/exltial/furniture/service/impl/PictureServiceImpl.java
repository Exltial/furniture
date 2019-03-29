/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.service.impl;

import com.exltial.furniture.dao.PictureDao;
import com.exltial.furniture.entity.PicDetailEntity;
import com.exltial.furniture.entity.PicEntity;
import com.exltial.furniture.service.PictureService;
import com.exltial.furniture.utils.ParamUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanlei24
 * @date 2019/1/15
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao pictureDao;
    @Resource
    DataSourceTransactionManager transactionManager;

    @Override
    public List<PicEntity> getPicList(Integer pageNum) {
        if (pageNum == null) {
            return new LinkedList<>();
        }
        PageHelper.startPage(pageNum, ParamUtils.ROW);
        return pictureDao.getList();
    }

    @Override
    public boolean deleteSku(String skuId) {
        try {
            pictureDao.deleteSku(skuId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void addSku(PicEntity entity) {
        pictureDao.addSku(entity);
    }

    @Override
    public List<PicDetailEntity> getDetailBySkuId(String skuId) {
        return pictureDao.getDetailBySkuId(skuId);
    }

    @Override
    public PicEntity getSkuById(String skuId) {
        return pictureDao.getSkuById(skuId);
    }

    @Override
    public void updateSku(PicEntity entity) {
        pictureDao.updateSku(entity);
    }

    @Override
    public void addSkuDetails(PicDetailEntity picDetailEntity) {
        pictureDao.addSkuDetails(picDetailEntity);
    }
}
