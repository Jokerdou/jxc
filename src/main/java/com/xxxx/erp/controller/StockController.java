package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("stock")
public class StockController extends BaseController {

    @Resource
    private CustomerService customerService;

    /**
     * 进入客户管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "stock/stock";
    }


}
