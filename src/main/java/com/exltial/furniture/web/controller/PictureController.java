/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.web.controller;

import com.exltial.furniture.entity.PicEntity;
import com.exltial.furniture.service.PictureService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:tanlei24
 * @date:2019/1/15
 */
@RestController
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    PictureService pictureService;

    @RequestMapping("/list")
    public PageInfo<PicEntity> getList(Integer pageNum) {
        List<PicEntity> list = pictureService.getPicList(pageNum);
        return new PageInfo<>(list);
    }
}
