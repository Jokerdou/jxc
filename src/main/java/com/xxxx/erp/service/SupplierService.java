package com.xxxx.erp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.erp.base.BaseQuery;
import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.SupplierMapper;
import com.xxxx.erp.query.SupplierQuery;
import com.xxxx.erp.vo.Supplier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class SupplierService extends BaseService<Supplier,Integer> {

    @Resource
    private SupplierMapper supplierMapper;

    /**
     *供货商页面的多条件查询
     */
    public Map<String, Object> querySupplierByParams(SupplierQuery supplierQuery) {
        Map<String, Object> map = new HashMap<>();
        // 开启分页
        PageHelper.startPage(supplierQuery.getPage(), supplierQuery.getLimit());
        // 得到对应分页对象
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplierMapper.selectByParams(supplierQuery));
        // 设置map对象
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        // 设置分页好的列表
        map.put("data",pageInfo.getList());
        return map;
    }

}
