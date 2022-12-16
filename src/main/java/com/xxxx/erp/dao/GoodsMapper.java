package com.xxxx.erp.dao;

import com.xxxx.erp.base.BaseMapper;
import com.xxxx.erp.base.BaseQuery;
import com.xxxx.erp.vo.Goods;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods,Integer> {
    public List<Goods> selectByParamsNoInventory(BaseQuery baseQuery);
    public List<Goods> selectByParamsHaveInventory(BaseQuery baseQuery);
}