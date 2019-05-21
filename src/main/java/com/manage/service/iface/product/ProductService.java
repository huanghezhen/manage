package com.manage.service.iface.product;

import com.manage.entity.product.ProductModel;

import java.util.List;

/**
 * @ClassName: ProductService
 * @Description: 商品service
 * @author: cl-Z
 * @date: 2019/5/7 0007 10:02
 * @Version: V1.0
 */
public interface ProductService {

    int saveProduct(ProductModel product);
    ProductModel findOne(String productId);
    List<ProductModel> findUpAll(Integer productStatus);
    List<ProductModel> findAll();
    int updateProduct(ProductModel product);
    List<ProductModel> getProductBySomething(ProductModel productModel,Integer currPage,Integer pageSize);
    int delProduct(List<String> productIds);
}
