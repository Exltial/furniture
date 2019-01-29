/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture;

import com.exltial.furniture.dao.PictureDao;
import com.exltial.furniture.entity.PicEntity;
import com.exltial.furniture.service.PictureService;
import com.exltial.furniture.web.controller.LoginController;
import com.exltial.furniture.web.controller.PictureController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FurnitureApplicationTests {
    @Autowired
    LoginController loginController;
    @Autowired
    PictureController pictureController;
    @Autowired
    PictureDao pictureDao;
    @Autowired
    PictureService pictureService;

    @Test
    public void contextLoads() {
        PicEntity picEntity = new PicEntity();
        picEntity.setSkuId("222");
        log.info(picEntity.toString());
        pictureService.updateSku(picEntity);
    }

}
