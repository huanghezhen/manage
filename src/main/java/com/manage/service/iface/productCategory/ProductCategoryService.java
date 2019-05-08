package com.manage.service.iface.productCategory;

import com.manage.entity.productCategory.ProductCategoryModel;

import java.util.List;

/**
 * @ClassName: ProductCategoryService
 * @Description: 商品分类Service
 * @author: cl-Z
 * @date: 2019/5/7 0007 17:19
 * @Version: V1.0
 */
public interface ProductCategoryService {
    ProductCategoryModel findOne(int categoryId);
    List<ProductCategoryModel> findAll();
    int updateProductCategory(ProductCategoryModel productCategoryModel);
    int saveProductCategory(ProductCategoryModel productCategoryModel);
    List<ProductCategoryModel> findByParentId(int parentId);
    List<ProductCategoryModel> findByIdIn(List<Integer> categoryIds);

}
