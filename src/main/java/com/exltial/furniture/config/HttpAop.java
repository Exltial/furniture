/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanlei24
 * @date 2019/1/22
 */
@Aspect
@Component
@Slf4j
public class HttpAop {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* com.exltial.furniture.web.controller..*.*(..))&& !execution(* com.exltial.furniture.web.controller.PictureController..*.picUpload(..))")
    public void webLog() {
        //do nothing here
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        Enumeration<String> enums = request.getParameterNames();
        List<String> params = new LinkedList<>();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            String param = paraName + ":" + request.getParameter(paraName);
            params.add(param);
        }
        try {
            log.info("URL: {}, Params: {}, Args:{}", request.getRequestURL().toString(), JSON.toJSONString(params), JSON.toJSONString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        try {
            log.info("SPEND TIME: {} ms,URL:{}, RESPONSE: {} ", System.currentTimeMillis() - startTime.get(), request.getRequestURL().toString(), JSON.toJSONString(ret));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
