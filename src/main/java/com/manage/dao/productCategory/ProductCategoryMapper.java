package com.manage.dao.productCategory;

import com.manage.entity.productCategory.ProductCategoryModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ProductCategoryMapper
 * @Description: TODO
 * @author: cl-Z
 * @date: 2019/5/7 0007 17:01
 * @Version: V1.0
 */
@Component("productCategoryMapper")
public interface ProductCategoryMapper {
    ProductCategoryModel findOne(int categoryId);
    List<ProductCategoryModel> findAll();
    int updateProductCategory(ProductCategoryModel productCategoryModel);
    int saveProductCategory(ProductCategoryModel productCategoryModel);
    List<ProductCategoryModel> findByParentId(int parentId);
    List<ProductCategoryModel> findByIdIn(List<Integer> categoryIds);
    int deleteByIds(List<Integer> categoryIds);

}
