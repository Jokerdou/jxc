package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.query.CustomerQuery;
import com.xxxx.erp.query.SupplierQuery;
import com.xxxx.erp.service.CustomerService;
import com.xxxx.erp.service.SupplierService;
import com.xxxx.erp.vo.Customer;
import com.xxxx.erp.vo.Supplier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    /**
     * 进入客户管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "customer/customer";
    }

    /**
     * 客户页面的多条件查询
     * @param customerQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryCustomerByParams(CustomerQuery customerQuery) {
        return customerService.queryCustomerByParams(customerQuery);
    }

    /**
     * 添加客户信息
     * @param customer
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return success("添加客户信息成功");
    }

    /**
     * 更新客户信息
     * @param customer
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return success("更新客户信息成功");
    }

    /**
     * 进入添加或者修改页面
     * @return
     */
    @RequestMapping("toCustomerPage")
    public String toSupplierPage(Integer customerId,HttpServletRequest request){
        if(customerId != null){
            Customer customer= customerService.selectByPrimaryKey(customerId);
            request.setAttribute("customer",customer);
        }
        return "customer/addCustomer";
    }

    /**
     * 删除客户信息
     * @param ids
     * @return
     */
    @DeleteMapping ("delete")
    @ResponseBody
    public ResultInfo deleteCustomerById(Integer[] ids){
        customerService.deleteCustomerById(ids);
        return success("删除供货商信息成功");
    }
}
