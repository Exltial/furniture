package com.exltial.furniture.service.impl;

import com.exltial.furniture.dao.SkuDao;
import com.exltial.furniture.entity.SkuEntity;
import com.exltial.furniture.service.SkuSrvice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkuSrviceImpl implements SkuSrvice {
    @Resource
    SkuDao skuDao;

    @Override
    public List<SkuEntity> getList(int limit) {
        return skuDao.getList(limit);
    }
}
