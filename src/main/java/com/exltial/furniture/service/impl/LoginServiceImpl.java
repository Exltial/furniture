/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.service.impl;

import com.exltial.furniture.dao.LoginDao;
import com.exltial.furniture.entity.LoginEntity;
import com.exltial.furniture.service.LoginService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginDao loginDao;

    @Override
    public Boolean validate(LoginEntity loginEntity) {
        String password = loginDao.getPassWordById(loginEntity.getUserName());
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        return StringUtils.equals(password, loginEntity.getPassWord());
    }
}
