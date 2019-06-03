package com.manage.entity.product;

import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: product
 * @Description: 商品模型类
 * @author: cl-Z
 * @date: 2019/5/6 17:20
 * @Version: V1.0
 */
public class ProductModel {
    /**
     * 商品ID*/
    private String productId;
    /**
     * 商品名称*/
    private String productName;
    /**
     * 商品价格*/
    private BigDecimal productPrice;
    /**
     * 商品描述*/
    private String productDescription;
    /**
     * 商品图片*/
    private String productIcon;
    /**
     * 商品状态  0:下架   1：上架*/
    private Integer productStatus;

    /**商品的分类*/
    private Integer categoryType;

    /**商品的分类名字   数据库中无   视图返回使用*/
    private String categoryName;

    private Date createTime;

    private Date updateTime;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", productStatus=" + productStatus +
                ", categoryType=" + categoryType +
                ", categoryName='" + categoryName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
