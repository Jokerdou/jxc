package com.xxxx.erp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.CustomerMapper;
import com.xxxx.erp.dao.SupplierMapper;
import com.xxxx.erp.query.CustomerQuery;
import com.xxxx.erp.query.SupplierQuery;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.vo.Customer;
import com.xxxx.erp.vo.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService extends BaseService<Customer,Integer> {

    @Resource
    private CustomerMapper customerMapper;

    /**
     *供货商页面的多条件查询
     */
    public Map<String, Object> queryCustomerByParams(CustomerQuery customerQuery) {
        Map<String, Object> map = new HashMap<>();
        // 开启分页
        PageHelper.startPage(customerQuery.getPage(), customerQuery.getLimit());
        // 得到对应分页对象
        PageInfo<Customer> pageInfo = new PageInfo<>(customerMapper.selectByParams(customerQuery));
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
    public void addCustomer(Customer customer){
        //参数校验
        AssertUtil.isTrue(StringUtils.isBlank(customer.getCustomerName()),"客户姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(customer.getContacts()),"联系人不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(customer.getPhoneNumber()),"联系人电话不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(customer.getAddress()),"客户地址不能为空");

        //执行操作
        AssertUtil.isTrue(insertSelective(customer)<1,"添加客户信息失败");
    }

    /**
     * 更新供货商
     * @param customer
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCustomer(Customer customer){
        //判断待更新记录是否存在
        AssertUtil.isTrue(null == customer.getCustomerId(),"待更新记录不存在");
        Customer temp=customerMapper.selectByPrimaryKey(customer.getCustomerId());
        AssertUtil.isTrue(null == temp,"待更新记录不存在");

        //参数校验
        AssertUtil.isTrue(StringUtils.isBlank(customer.getCustomerName()),"客户姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(customer.getContacts()),"联系人不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(customer.getPhoneNumber()),"联系人电话不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(customer.getAddress()),"客户地址不能为空");

        //执行操作
        AssertUtil.isTrue(updateByPrimaryKeySelective(customer)<1,"更新客户信息失败");
    }

    /**
     * 删除供货商信息
     * @param ids
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCustomerById(Integer[] ids){
        AssertUtil.isTrue(null == ids || ids.length<1,"待删除记录不存在!!!");
        AssertUtil.isTrue(customerMapper.deleteBatch(ids) != ids.length,"供货商信息删除失败");
    }

}
