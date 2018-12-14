package com.csf.sample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ervin on 2018/10/20.
 */

public class GetProductsResponse {

    /**
     * GetProductsResponse : {"Items":[{"AgeExplain":"28天-85周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":8,"EnsureTerm":"1-365天","InsureType":2,"ProductId":1,"ProductName":"华泰安行天下境外旅行险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803201541376973539.png","ShowPrice":90,"SkuTerms":[]},{"AgeExplain":"30天-85周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":9,"EnsureTerm":"5-21天","InsureType":2,"ProductId":2,"ProductName":"华泰境外全球旅行保险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803201625244317289.png","ShowPrice":34,"SkuTerms":[]},{"AgeExplain":"1周岁-80周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":1,"EnsureTerm":"7-183天","InsureType":2,"ProductId":3,"ProductName":"华泰签证全球旅游险(拒签)","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1711222110312249164.png","ShowPrice":80,"SkuTerms":[]},{"AgeExplain":"19周岁-80周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":10,"EnsureTerm":"1-365天","InsureType":2,"ProductId":4,"ProductName":"华泰安达天下全球旅游险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1711222114454766843.png","ShowPrice":30,"SkuTerms":[]},{"AgeExplain":"28天-150周岁","BuyLimit":1,"CateId":5,"CateName":"境外团险","CompanyId":5,"CompanyName":"中国人保","DisplayOrder":10,"EnsureTerm":"1-30天","InsureType":2,"ProductId":5,"ProductName":"人保环球游旅游险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1802252135071507477.jpg","ShowPrice":2.5,"SkuTerms":[]},{"AgeExplain":"28天-80周岁","BuyLimit":1,"CateId":9,"CateName":"境内团险","CompanyId":3,"CompanyName":"长安责任保险","DisplayOrder":1,"EnsureTerm":"1-90天","InsureType":2,"ProductId":6,"ProductName":"天天长安行境内旅行意外险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1801152114483771696.jpg","ShowPrice":0.9,"SkuTerms":[]},{"AgeExplain":"28天-80周岁","BuyLimit":1,"CateId":5,"CateName":"境外团险","CompanyId":3,"CompanyName":"长安责任保险","DisplayOrder":1,"EnsureTerm":"1-180天","InsureType":2,"ProductId":7,"ProductName":"天天长安行境外旅行意外险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1802251621443609919.png","ShowPrice":11.5,"SkuTerms":[]},{"AgeExplain":"28天-80周岁","BuyLimit":1,"CateId":10,"CateName":"境内个险","CompanyId":3,"CompanyName":"长安责任保险","DisplayOrder":1,"EnsureTerm":"1-30天","InsureType":2,"ProductId":8,"ProductName":"天天长安行个人境内旅行意外保险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1802251624363836814.png","ShowPrice":2,"SkuTerms":[]},{"AgeExplain":"28天-150周岁","BuyLimit":1,"CateId":9,"CateName":"境内团险","CompanyId":5,"CompanyName":"中国人保","DisplayOrder":1,"EnsureTerm":"1天","InsureType":2,"ProductId":9,"ProductName":"人保一日游","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803031637333918427.jpg","ShowPrice":0.9,"SkuTerms":[]},{"AgeExplain":"28天-150周岁","BuyLimit":1,"CateId":9,"CateName":"境内团险","CompanyId":5,"CompanyName":"中国人保","DisplayOrder":1,"EnsureTerm":"16天","InsureType":2,"ProductId":10,"ProductName":"人保境内旅游险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803031655101971299.jpg","ShowPrice":1.2,"SkuTerms":[]}],"Message":null,"StatusCode":0}
     */

    @SerializedName("GetProductsResult")
    private GetProductsResultBean GetProductsResult;

    public GetProductsResultBean getGetProductsResult() {
        return GetProductsResult;
    }

    public void setGetProductsResult(GetProductsResultBean GetProductsResult) {
        this.GetProductsResult = GetProductsResult;
    }

    public static class GetProductsResultBean{
        /**
         * Items : [{"AgeExplain":"28天-85周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":8,"EnsureTerm":"1-365天","InsureType":2,"ProductId":1,"ProductName":"华泰安行天下境外旅行险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803201541376973539.png","ShowPrice":90,"SkuTerms":[]},{"AgeExplain":"30天-85周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":9,"EnsureTerm":"5-21天","InsureType":2,"ProductId":2,"ProductName":"华泰境外全球旅行保险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803201625244317289.png","ShowPrice":34,"SkuTerms":[]},{"AgeExplain":"1周岁-80周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":1,"EnsureTerm":"7-183天","InsureType":2,"ProductId":3,"ProductName":"华泰签证全球旅游险(拒签)","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1711222110312249164.png","ShowPrice":80,"SkuTerms":[]},{"AgeExplain":"19周岁-80周岁","BuyLimit":1,"CateId":6,"CateName":"境外个险","CompanyId":4,"CompanyName":"华泰保险","DisplayOrder":10,"EnsureTerm":"1-365天","InsureType":2,"ProductId":4,"ProductName":"华泰安达天下全球旅游险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1711222114454766843.png","ShowPrice":30,"SkuTerms":[]},{"AgeExplain":"28天-150周岁","BuyLimit":1,"CateId":5,"CateName":"境外团险","CompanyId":5,"CompanyName":"中国人保","DisplayOrder":10,"EnsureTerm":"1-30天","InsureType":2,"ProductId":5,"ProductName":"人保环球游旅游险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1802252135071507477.jpg","ShowPrice":2.5,"SkuTerms":[]},{"AgeExplain":"28天-80周岁","BuyLimit":1,"CateId":9,"CateName":"境内团险","CompanyId":3,"CompanyName":"长安责任保险","DisplayOrder":1,"EnsureTerm":"1-90天","InsureType":2,"ProductId":6,"ProductName":"天天长安行境内旅行意外险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1801152114483771696.jpg","ShowPrice":0.9,"SkuTerms":[]},{"AgeExplain":"28天-80周岁","BuyLimit":1,"CateId":5,"CateName":"境外团险","CompanyId":3,"CompanyName":"长安责任保险","DisplayOrder":1,"EnsureTerm":"1-180天","InsureType":2,"ProductId":7,"ProductName":"天天长安行境外旅行意外险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1802251621443609919.png","ShowPrice":11.5,"SkuTerms":[]},{"AgeExplain":"28天-80周岁","BuyLimit":1,"CateId":10,"CateName":"境内个险","CompanyId":3,"CompanyName":"长安责任保险","DisplayOrder":1,"EnsureTerm":"1-30天","InsureType":2,"ProductId":8,"ProductName":"天天长安行个人境内旅行意外保险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1802251624363836814.png","ShowPrice":2,"SkuTerms":[]},{"AgeExplain":"28天-150周岁","BuyLimit":1,"CateId":9,"CateName":"境内团险","CompanyId":5,"CompanyName":"中国人保","DisplayOrder":1,"EnsureTerm":"1天","InsureType":2,"ProductId":9,"ProductName":"人保一日游","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803031637333918427.jpg","ShowPrice":0.9,"SkuTerms":[]},{"AgeExplain":"28天-150周岁","BuyLimit":1,"CateId":9,"CateName":"境内团险","CompanyId":5,"CompanyName":"中国人保","DisplayOrder":1,"EnsureTerm":"16天","InsureType":2,"ProductId":10,"ProductName":"人保境内旅游险","ShowImg":"http://ttbx.dbaoy.com/upload/product/fr_1803031655101971299.jpg","ShowPrice":1.2,"SkuTerms":[]}]
         * Message : null
         * StatusCode : 0
         */

        @SerializedName("Items")
        private List<ProductionItemBean> Items;

        public List<ProductionItemBean> getItems() {
            return Items;
        }

        public void setItems(List<ProductionItemBean> Items) {
            this.Items = Items;
        }

    }
}
