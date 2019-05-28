/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.web.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequestMapping(value = "/view")
@Slf4j
public class ViewController {

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/toWelcome")
    public String toWelcome() {
        return "welcome";
    }

    @RequestMapping(value = "/toPictureList")
    public String toPictureList() {
        return "picture-list";
    }

    @RequestMapping(value = "/toProductBrand")
    public String toProductBrand() {
        return "product-brand";
    }

    @RequestMapping(value = "/toProductCategory")
    public String toProductCategory() {
        return "product-category";
    }

    @RequestMapping(value = "/toProductList")
    public String toProductList() {
        return "product-list";
    }

    @RequestMapping(value = "/toCharts1")
    public String toCharts1() {
        return "charts-1";
    }

    @RequestMapping(value = "/toSystemBase")
    public String toSystemBase() {
        return "system-base";
    }

    @RequestMapping(value = "/toSystemCategory")
    public String toSystemCategory() {
        return "system-category";
    }

    @RequestMapping(value = "/toSystemData")
    public String toSystemData() {
        return "system-data";
    }

    @RequestMapping(value = "/toSystemShielding")
    public String toSystemShielding() {
        return "system-shielding";
    }

    @RequestMapping(value = "/toSystemLog")
    public String toSystemLog() {
        return "system-log";
    }

    @RequestMapping(value = "/toPictureAdd")
    public String toPictureAdd(String skuId) {
        return "picture-add";
    }

    @RequestMapping(value = "/toPictureEdit")
    public String toPictureEdit(String skuId) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        requestAttributes.getRequest().setAttribute("skuId", skuId);
        return "picture-edit";
    }
    @RequestMapping(value = "/toArticleClassEdit")
    public String toArticleClassEdit() {
        return "article-class-edit";
    }

    @RequestMapping(value = "/toPictureShow")
    public String toPictureShow(String skuId) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        requestAttributes.getRequest().setAttribute("skuId", skuId);
        log.info(skuId);
        return "picture-show";
    }

    @RequestMapping(value = "/toProductCategoryAdd")
    public String toProductCategoryAdd() {
        return "product-category-add";
    }

    @RequestMapping(value = "/toDetailAdd")
    public String toDetailAdd(String skuId) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        requestAttributes.getRequest().setAttribute("skuId", skuId);
        return "details-add";
    }

    @RequestMapping(value = "/toMall")
    public String toMall() {
        return "ctps_361_ov/index";
    }
}
