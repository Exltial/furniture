package com.exltial.furniture.web.controller;

import com.exltial.furniture.entity.SkuEntity;
import com.exltial.furniture.service.SkuSrvice;
import com.exltial.furniture.web.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sku")
@Slf4j
public class SkuController {
    @Resource
    SkuSrvice skuSrvice;

    @RequestMapping("/getList")
    public ResultVO<List<SkuEntity>> getList() {
        ResultVO<List<SkuEntity>> resultVO = new ResultVO<>();
        List<SkuEntity> list = skuSrvice.getList(5);
        if (CollectionUtils.isEmpty(list)) {
            resultVO.setResult(false);
            resultVO.setErrorMsg("查无结果");
            return resultVO;
        }
        resultVO.setResult(true);
        resultVO.setData(list);
        return resultVO;
    }
}
