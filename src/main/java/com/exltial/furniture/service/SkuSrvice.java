package com.exltial.furniture.service;

import com.exltial.furniture.entity.SkuEntity;

import java.util.List;

public interface SkuSrvice {
    List<SkuEntity> getList(int limit);
}
