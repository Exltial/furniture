package com.exltial.furniture.dao;

import com.exltial.furniture.entity.SkuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SkuDao {
    List<SkuEntity> getList(int limit);
}
