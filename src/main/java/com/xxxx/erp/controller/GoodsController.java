package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.dao.GoodsMapper;
import com.xxxx.erp.query.CustomerQuery;
import com.xxxx.erp.query.GoodsQuery;
import com.xxxx.erp.service.CustomerService;
import com.xxxx.erp.service.GoodsService;
import com.xxxx.erp.vo.Customer;
import com.xxxx.erp.vo.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("goods")
public class GoodsController extends BaseController {

    @Resource
    private GoodsService goodsService;

    /**
     * 进入客户管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "goods/goods";
    }

    /**
     * 客户页面的多条件查询
     * @param goodsQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryGoodsByParams(GoodsQuery goodsQuery) {
        return goodsService.queryGoodsByParams(goodsQuery);
    }

    /**
     * 查询有库存的商品
     * @param goodsQuery
     * @return
     */
    @RequestMapping("listHaveInventory")
    @ResponseBody
    public Map<String, Object> selectByParamsHaveInventory(GoodsQuery goodsQuery) {
        return goodsService.selectByParamsHaveInventory(goodsQuery);
    }

    /**
     * 查询无库存的商品
     * @param goodsQuery
     * @return
     */
    @RequestMapping("listNoInventory")
    @ResponseBody
    public Map<String, Object> selectByParamsNoInventory(GoodsQuery goodsQuery) {
        return goodsService.selectByParamsNoInventory(goodsQuery);
    }


    /**
     * 添加客户信息
     * @param goods
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addGoods(Goods goods){
        goodsService.addGoods(goods);
        return success("添加客户信息成功");
    }

    /**
     * 更新客户信息
     * @param goods
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateGoods(Goods goods){
        goodsService.updateGoods(goods);
        return success("更新客户信息成功");
    }

    /**
     * 进入添加或者修改页面
     * @return
     */
    @RequestMapping("toGoodsPage")
    public String toGoodsPage(Integer goodsId,HttpServletRequest request){
        if(goodsId != null){
            Goods goods= goodsService.selectByPrimaryKey(goodsId);
            request.setAttribute("goods",goods);
        }
        return "goods/addGoods";
    }

    /**
     * 删除客户信息
     * @param ids
     * @return
     */
    @DeleteMapping ("delete")
    @ResponseBody
    public ResultInfo deleteGoodsById(Integer[] ids){
        goodsService.deleteGoodsById(ids);
        return success("删除供货商信息成功");
    }
}
