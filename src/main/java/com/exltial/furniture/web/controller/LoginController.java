/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.exltial.furniture.entity.LoginEntity;
import com.exltial.furniture.service.LoginService;
import com.exltial.furniture.utils.SessionUtils;
import com.exltial.furniture.web.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {
    @Resource
    LoginService loginService;

    @RequestMapping(value = "/validate")
    public ResultVO validate(String request) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setResult(false);
        if (request == null) {
            resultVO.setErrorMsg("登录信息为空");
            return resultVO;
        }
        try {
            log.info("request:{}", request);
            LoginEntity loginEntity = JSON.parseObject(request, new TypeReference<LoginEntity>() {
            });
            Boolean flag = loginService.validate(loginEntity);
            if (flag) {
                resultVO.setResult(true);
                SessionUtils.set("user", loginEntity.getUserName());
            } else {
                resultVO.setErrorMsg("账号或密码错误");
            }
        } catch (Exception e) {
            resultVO.setErrorMsg("登录信息异常");
        }
        return resultVO;
    }
}
