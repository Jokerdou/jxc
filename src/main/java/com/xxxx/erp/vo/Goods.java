package com.xxxx.erp.vo;

public class Goods {
    private Integer goodsId;

    private String goodsCode;

    private String goodsName;

    private Integer inventoryQuantity;

    private Integer minNum;

    private String goodsModel;

    private String goodsProducer;

    private Float purchasingPrice;

    private Float lastPurchasingPrice;

    private String remarks;

    private Float sellingPrice;

    private Integer state;

    private String goodsUnit;

    private Integer goodsTypeId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel == null ? null : goodsModel.trim();
    }

    public String getGoodsProducer() {
        return goodsProducer;
    }

    public void setGoodsProducer(String goodsProducer) {
        this.goodsProducer = goodsProducer == null ? null : goodsProducer.trim();
    }

    public Float getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(Float purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public Float getLastPurchasingPrice() {
        return lastPurchasingPrice;
    }

    public void setLastPurchasingPrice(Float lastPurchasingPrice) {
        this.lastPurchasingPrice = lastPurchasingPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit == null ? null : goodsUnit.trim();
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }
}