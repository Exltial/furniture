/*
 * Copyright (c) 2018-2019 JiaNing All Rights Reserved.
 */

package com.exltial.furniture.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.exltial.furniture.entity.PicDetailEntity;
import com.exltial.furniture.entity.PicEntity;
import com.exltial.furniture.service.PictureService;
import com.exltial.furniture.utils.DateUtils;
import com.exltial.furniture.utils.ParamUtils;
import com.exltial.furniture.utils.SessionUtils;
import com.exltial.furniture.utils.UUIDUtils;
import com.exltial.furniture.web.vo.ResultVO;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.util.List;

/**
 * @author:tanlei24
 * @date:2019/1/15
 */
@RestController
@RequestMapping("/pic")
@Slf4j
public class PictureController {
    @Autowired
    PictureService pictureService;

    @Value("${web.upload-path}")
    private String filePath;

    /**
     * 获取sku列表
     *
     * @param pageNum
     * @return
     */
    @RequestMapping("/list")
    public PageInfo<PicEntity> getList(Integer pageNum) {
        List<PicEntity> list = pictureService.getPicList(pageNum);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return new PageInfo<>(list);
    }

    /**
     * 删除sku
     *
     * @param skuId
     * @return
     */
    @RequestMapping("/deleteSku")
    public ResultVO deleteSku(String skuId) {
        log.info("delete sku:{}", skuId);
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setResult(false);
        try {
            boolean flag = pictureService.deleteSku(skuId);
            resultVO.setResult(flag);
        } catch (Exception ex) {
            resultVO.setErrorMsg("删除sku发生了异常。" + ex.getMessage());
        }
        return resultVO;
    }

    /**
     * 添加sku
     *
     * @param request
     * @return
     */
    @RequestMapping("/addSku")
    public ResultVO addSku(String request) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(false);
        log.info("addSku:{}", request);
        String fileName = SessionUtils.get(ParamUtils.FILENAME) instanceof String ? (String) SessionUtils.get(ParamUtils.FILENAME) : "";
        if (request == null) {
            return resultVO;
        }
        PicEntity entity;
        try {
            entity = JSON.parseObject(request, new TypeReference<PicEntity>() {
            });
        } catch (Exception e) {
            resultVO.setErrorMsg(e.getMessage());
            return resultVO;
        }
        if (entity == null) {
            return resultVO;
        }
        try {
            entity.setSkuUrl("/" + fileName);
            entity.setCreateTime(DateUtils.getNow());
            entity.setSkuId(UUIDUtils.getId());
            entity.setStatus(1);
            entity.setCover(1);
            pictureService.addSku(entity);
            resultVO.setResult(true);
        } catch (Exception ex) {
            resultVO.setErrorMsg("新增sku发生了异常。" + ex.getMessage());
        }
        return resultVO;
    }

    /**
     * 获取详情列表
     *
     * @param skuId
     * @return
     */
    @RequestMapping("/getDetailPic")
    public ResultVO<List<PicDetailEntity>> getDetailPic(String skuId) {
        ResultVO<List<PicDetailEntity>> resultVO = new ResultVO();
        resultVO.setResult(false);
        if (StringUtils.isEmpty(skuId)) {
            resultVO.setErrorMsg("skuId为空");
            return resultVO;
        }
        try {
            List<PicDetailEntity> list = pictureService.getDetailBySkuId(skuId);
            if (CollectionUtils.isEmpty(list)) {
                resultVO.setErrorMsg("查询结果为空");
                return resultVO;
            }
            resultVO.setResult(true);
            resultVO.setData(list);
        } catch (Exception e) {
            resultVO.setErrorMsg("查询异常:" + e.getMessage());
        }
        return resultVO;
    }

    /**
     * 图片上传
     *
     * @param file
     * @return
     */
    @RequestMapping("/picUpload")
    public ResultVO picUpload(@RequestParam MultipartFile file) {
        ResultVO resultVO = new ResultVO();
        resultVO.setResult(false);
        if (file.isEmpty()) {
            return resultVO;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        SessionUtils.set(ParamUtils.FILENAME, fileName);
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf('.'));
        log.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            resultVO.setResult(true);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return resultVO;
    }

    /**
     * 获取sku详情
     */
    @RequestMapping(value = "/getSkuById")
    public ResultVO<PicEntity> getSkuById(String skuId) {
        ResultVO<PicEntity> resultVO = new ResultVO<>();
        resultVO.setResult(false);
        if (StringUtils.isEmpty(skuId)) {
            return resultVO;
        }
        try {
            PicEntity entity = pictureService.getSkuById(skuId);
            resultVO.setResult(true);
            resultVO.setData(entity);
        } catch (Exception ex) {
            resultVO.setErrorMsg(ex.getMessage());
        }
        return resultVO;
    }

    /**
     * 更新sku
     */
    @RequestMapping(value = "updateSku")
    public ResultVO updateSku(String uploadFlag, String request) {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setResult(false);
        try {
            PicEntity entity = JSON.parseObject(request, new TypeReference<PicEntity>() {
            });
            if (!StringUtils.isEmpty(uploadFlag)) {
                //上传图片
                String fileName = SessionUtils.get(ParamUtils.FILENAME) instanceof String ? (String) SessionUtils.get(ParamUtils.FILENAME) : null;
                entity.setSkuUrl("/" + fileName);
            }
            entity.setCreateTime(DateUtils.getNow());
            pictureService.updateSku(entity);
            resultVO.setResult(true);
        } catch (Exception e) {
            resultVO.setErrorMsg(e.getMessage());
        }
        return resultVO;
    }
}