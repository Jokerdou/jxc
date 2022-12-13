package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.enums.StateStatus;
import com.xxxx.erp.query.SupplierQuery;
import com.xxxx.erp.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("supplier")
public class SupplierController extends BaseController {

    @Resource
    private SupplierService supplierService;

    /**
     * 进入客户管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "supplier/supplier";
    }

    /**
     * 供货商页面的多条件查询
     * @param supplierQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> querySupplierByParams(SupplierQuery supplierQuery) {
        return supplierService.querySupplierByParams(supplierQuery);
    }
}
