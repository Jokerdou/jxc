package com.xxxx.erp.vo;

public class GoodsType {
    private Integer goodsTypeId;

    private String goodsTypeName;

    private Integer pId;

    private Integer goodsTypeState;

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName == null ? null : goodsTypeName.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getGoodsTypeState() {
        return goodsTypeState;
    }

    public void setGoodsTypeState(Integer goodsTypeState) {
        this.goodsTypeState = goodsTypeState;
    }
}