package com.csf.sample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ervin on 2018/11/14.
 */

public class ProductionItemBean {
    /**
     * AgeExplain : 28天-85周岁
     * BuyLimit : 1
     * CateId : 6
     * CateName : 境外个险
     * CompanyId : 4
     * CompanyName : 华泰保险
     * DisplayOrder : 8
     * EnsureTerm : 1-365天
     * InsureType : 2
     * ProductId : 1
     * ProductName : 华泰安行天下境外旅行险
     * ShowImg : http://ttbx.dbaoy.com/upload/product/fr_1803201541376973539.png
     * ShowPrice : 90
     * SkuTerms : []
     */

    @SerializedName("AgeExplain")
    private String AgeExplain;
    @SerializedName("BuyLimit")
    private int BuyLimit;
    @SerializedName("CateId")
    private int CateId;
    @SerializedName("CateName")
    private String CateName;
    @SerializedName("CompanyId")
    private int CompanyId;
    @SerializedName("CompanyName")
    private String CompanyName;
    @SerializedName("DisplayOrder")
    private int DisplayOrder;
    @SerializedName("EnsureTerm")
    private String EnsureTerm;
    @SerializedName("InsureType")
    private int InsureType;
    @SerializedName("ProductId")
    private int ProductId;
    @SerializedName("ProductName")
    private String ProductName;
    @SerializedName("ShowImg")
    private String ShowImg;
    @SerializedName("ShowPrice")
    private Number ShowPrice;
    @SerializedName("SkuTerms")
    private List<?> SkuTerms;

    public String getAgeExplain() {
        return AgeExplain;
    }

    public void setAgeExplain(String AgeExplain) {
        this.AgeExplain = AgeExplain;
    }

    public int getBuyLimit() {
        return BuyLimit;
    }

    public void setBuyLimit(int BuyLimit) {
        this.BuyLimit = BuyLimit;
    }

    public int getCateId() {
        return CateId;
    }

    public void setCateId(int CateId) {
        this.CateId = CateId;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public int getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(int DisplayOrder) {
        this.DisplayOrder = DisplayOrder;
    }

    public String getEnsureTerm() {
        return EnsureTerm;
    }

    public void setEnsureTerm(String EnsureTerm) {
        this.EnsureTerm = EnsureTerm;
    }

    public int getInsureType() {
        return InsureType;
    }

    public void setInsureType(int InsureType) {
        this.InsureType = InsureType;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getShowImg() {
        return ShowImg;
    }

    public void setShowImg(String ShowImg) {
        this.ShowImg = ShowImg;
    }

    public Number getShowPrice() {
        return ShowPrice;
    }

    public void setShowPrice(Number ShowPrice) {
        this.ShowPrice = ShowPrice;
    }

    public List<?> getSkuTerms() {
        return SkuTerms;
    }

    public void setSkuTerms(List<?> SkuTerms) {
        this.SkuTerms = SkuTerms;
    }
}
