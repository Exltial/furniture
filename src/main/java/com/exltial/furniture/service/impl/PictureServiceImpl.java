/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.service.impl;

import com.exltial.furniture.dao.PictureDao;
import com.exltial.furniture.entity.PicEntity;
import com.exltial.furniture.service.PictureService;
import com.exltial.furniture.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanlei24
 * @date 2019/1/15
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureDao pictureDao;

    @Override
    public List<PicEntity> getPicList(Integer pageNum) {
        if (pageNum == null) {
            return null;
        }
        PageHelper.startPage(pageNum, PageUtils.ROW);
        return pictureDao.getList();
    }
}
