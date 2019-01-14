/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view")
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
    public String toPictureAdd() {
        return "picture-add";
    }

    @RequestMapping(value = "/toArticleClassEdit")
    public String toArticleClassEdit() {
        return "article-class-edit";
    }

    @RequestMapping(value = "/toPictureShow")
    public String toPictureShow() {
        return "picture-show";
    }

    @RequestMapping(value = "/toProductCategoryAdd")
    public String toProductCategoryAdd() {
        return "product-category-add";
    }
}
