package com.xxxx.erp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.erp.base.BaseQuery;
import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.SupplierMapper;
import com.xxxx.erp.query.SupplierQuery;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.vo.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 添加供货商
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addSupplier(Supplier supplier){
        //参数校验
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getSupplierName()),"供货商姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getContacts()),"供货商联系人不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getPhoneNumber()),"联系人电话不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getAddress()),"供货商地址不能为空");

        //执行操作
        AssertUtil.isTrue(insertSelective(supplier)<1,"添加供货商信息失败");
    }

    /**
     * 更新供货商
     * @param supplier
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateSupplier(Supplier supplier){
        //判断待更新记录是否存在
        AssertUtil.isTrue(null == supplier.getSupplierId(),"待更新记录不存在");
        Supplier temp=supplierMapper.selectByPrimaryKey(supplier.getSupplierId());
        AssertUtil.isTrue(null == temp,"待更新记录不存在");

        //参数校验
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getSupplierName()),"供货商姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getContacts()),"供货商联系人不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getPhoneNumber()),"联系人电话不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(supplier.getAddress()),"供货商地址不能为空");

        //执行操作
        AssertUtil.isTrue(updateByPrimaryKeySelective(supplier)<1,"更新供货商信息失败");
    }

    /**
     * 删除供货商信息
     * @param ids
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteSupplierById(Integer[] ids){
        AssertUtil.isTrue(null == ids || ids.length<1,"待删除记录不存在");
        AssertUtil.isTrue(supplierMapper.deleteBatch(ids) != ids.length,"供货商信息删除失败");
    }

}
