package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.enums.StateStatus;
import com.xxxx.erp.query.SupplierQuery;
import com.xxxx.erp.service.SupplierService;
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

    /**
     * 添加供货商信息
     * @param supplier
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addSupplier(Supplier supplier){
        supplierService.addSupplier(supplier);
        return success("添加供货商信息成功");
    }

    /**
     * 更新供货商信息
     * @param supplier
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateSupplier(Supplier supplier){
        supplierService.updateSupplier(supplier);
        return success("更新供货商信息成功");
    }

    /**
     * 进入添加或者修改页面
     * @return
     */
    @RequestMapping("toSupplierPage")
    public String toSupplierPage(Integer supplierId,HttpServletRequest request){
        if(supplierId != null){
        Supplier supplier= supplierService.selectByPrimaryKey(supplierId);
        request.setAttribute("supplier",supplier);
        }
        return "supplier/addSupplier";
    }

    @DeleteMapping ("delete")
    @ResponseBody
    public ResultInfo deleteSupplierById(Integer[] ids){
        supplierService.deleteSupplierById(ids);
        return success("删除供货商信息成功");
    }
}
