package com.xxxx.erp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.CustomerMapper;
import com.xxxx.erp.dao.GoodsMapper;
import com.xxxx.erp.query.CustomerQuery;
import com.xxxx.erp.query.GoodsQuery;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.vo.Customer;
import com.xxxx.erp.vo.Goods;
import com.xxxx.erp.vo.GoodsType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsService extends BaseService<Goods,Integer> {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     *供货商页面的多条件查询
     */
    public Map<String, Object> queryGoodsByParams(GoodsQuery goodsQuery) {
        Map<String, Object> map = new HashMap<>();
        // 开启分页
        PageHelper.startPage(goodsQuery.getPage(), goodsQuery.getLimit());
        // 得到对应分页对象
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectByParams(goodsQuery));
        // 设置map对象
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        // 设置分页好的列表
        map.put("data",pageInfo.getList());
        return map;
    }

    /**
     *查询无库存的商品
     */
    public Map<String, Object> selectByParamsNoInventory(GoodsQuery goodsQuery) {
        Map<String, Object> map = new HashMap<>();
        // 开启分页
        PageHelper.startPage(goodsQuery.getPage(), goodsQuery.getLimit());
        // 得到对应分页对象
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectByParamsNoInventory(goodsQuery));
        // 设置map对象
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        // 设置分页好的列表
        map.put("data",pageInfo.getList());
        return map;
    }

    /**
     *查询有库存的商品
     */
    public Map<String, Object> selectByParamsHaveInventory(GoodsQuery goodsQuery) {
        Map<String, Object> map = new HashMap<>();
        // 开启分页
        PageHelper.startPage(goodsQuery.getPage(), goodsQuery.getLimit());
        // 得到对应分页对象
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsMapper.selectByParamsHaveInventory(goodsQuery));
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
    public void addGoods(Goods goods){

        //参数校验
        //AssertUtil.isTrue(StringUtils.isBlank(goodsType.getGoodsTypeName()),"商品类型不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(goods.getGoodsName()),"商品名称不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(goods.getGoodsModel()),"商品型号不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(goods.getGoodsUnit()),"商品单位不能为空");
        AssertUtil.isTrue(null == goods.getPurchasingPrice(),"采购价格不能为空");
        AssertUtil.isTrue(null == goods.getSellingPrice(),"销售价格不能为空");
        AssertUtil.isTrue(null == goods.getMinNum(),"库存下限不能为空");
        AssertUtil.isTrue(null == goods.getGoodsProducer(),"生产厂商不能为空");

        goods.setInventoryQuantity(0);
        goods.setLastPurchasingPrice((float) 0);
        goods.setState(0);
        //执行操作
        AssertUtil.isTrue(insertSelective(goods)<1,"添加商品信息失败");
    }

    /**
     * 更新供货商
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateGoods(Goods goods){


        //判断待更新记录是否存在
        AssertUtil.isTrue(null == goods.getGoodsId(),"待更新记录不存在");
        Goods temp=goodsMapper.selectByPrimaryKey(goods.getGoodsId());
        AssertUtil.isTrue(null == temp,"待更新记录不存在");

        //参数校验
        //AssertUtil.isTrue(StringUtils.isBlank(goodsType.getGoodsTypeName()),"商品类型不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(goods.getGoodsName()),"商品名称不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(goods.getGoodsModel()),"商品型号不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(goods.getGoodsUnit()),"商品单位不能为空");
        AssertUtil.isTrue(null == goods.getPurchasingPrice(),"采购价格不能为空");
        AssertUtil.isTrue(null == goods.getSellingPrice(),"销售价格不能为空!!");
        AssertUtil.isTrue(null == goods.getMinNum(),"库存下限不能为空");
        AssertUtil.isTrue(null == goods.getGoodsProducer(),"生产厂商不能为空");

        //执行操作
        AssertUtil.isTrue(updateByPrimaryKeySelective(goods)<1,"更新客户信息失败");
    }

    /**
     * 删除供货商信息
     * @param ids
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void
    deleteGoodsById(Integer[] ids){
        AssertUtil.isTrue(null == ids || ids.length<1,"待删除记录不存在");
        AssertUtil.isTrue(goodsMapper.deleteBatch(ids) != ids.length,"供货商信息删除失败");
    }

}
