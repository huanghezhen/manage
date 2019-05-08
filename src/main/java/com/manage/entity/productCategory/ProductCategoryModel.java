package com.manage.entity.productCategory;

import java.util.Date;

/**
 * @ClassName: ProductCategoryMapper
 * @Description: 商品分类
 * @author: cl-Z
 * @date: 2019/5/7 0007 16:55
 * @Version: V1.0
 */
public class ProductCategoryModel {
    /**类目ID*/
    private Integer categoryId;
    /**类目名称*/
    private String categoryName;
    /**类目分类*/
    private Integer categoryType;
    /**创建时间*/
    private Date createTime;
    /**修改时间*/
    private Date updateTime;

    private Integer parentId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
