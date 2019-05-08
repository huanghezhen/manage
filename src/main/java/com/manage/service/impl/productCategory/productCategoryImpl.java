package com.manage.service.impl.productCategory;

import com.manage.dao.productCategory.ProductCategoryMapper;
import com.manage.entity.productCategory.ProductCategoryModel;
import com.manage.service.iface.productCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: productCategoryImpl
 * @Description: TODO
 * @author: cl-Z
 * @date: 2019/5/7 0007 17:20
 * @Version: V1.0
 */
@Service
public class productCategoryImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategoryModel findOne(int categoryId) {
        ProductCategoryModel one = productCategoryMapper.findOne(categoryId);
        return one;
    }

    @Override
    public List<ProductCategoryModel> findAll() {
        List<ProductCategoryModel> all = productCategoryMapper.findAll();
        return all;
    }

    @Override
    public int updateProductCategory(ProductCategoryModel productCategoryModel) {
        int resultCode = productCategoryMapper.updateProductCategory(productCategoryModel);
        return resultCode;
    }

    @Override
    public int saveProductCategory(ProductCategoryModel productCategoryModel) {
        int resultCode = productCategoryMapper.saveProductCategory(productCategoryModel);
        return resultCode;
    }

    @Override
    public List<ProductCategoryModel> findByParentId(int parentId) {
        List<ProductCategoryModel> byParentId = productCategoryMapper.findByParentId(parentId);
        return byParentId;
    }

    @Override
    public List<ProductCategoryModel> findByIdIn(List<Integer> categoryIds) {
        List<ProductCategoryModel> byIdIn = productCategoryMapper.findByIdIn(categoryIds);
        return byIdIn;
    }
}
