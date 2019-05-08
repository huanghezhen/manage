package com.manage.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manage.entity.product.ProductModel;

import java.util.List;

/**
 * @ClassName: ProductVo
 * @Description:
 * @author: cl-Z
 * @date: 2019/5/7 13:58
 * @Version: V1.0
 */
public class ProductVo {
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductModel> productModelVOList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductModel> getProductModelVOList() {
        return productModelVOList;
    }

    public void setProductModelVOList(List<ProductModel> productModelVOList) {
        this.productModelVOList = productModelVOList;
    }
}
