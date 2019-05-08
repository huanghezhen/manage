package com.manage.dao.product;

import com.manage.entity.product.ProductModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: ProductMapper
 * @Description: TODO
 * @author: cl-Z
 * @date: 2019/5/7 0007 8:52
 * @Version: V1.0
 */
@Component("productMapper")
public interface ProductMapper {
    int saveProduct(ProductModel product);
    ProductModel findOne(String productId);
    List<ProductModel> findUpAll(Integer productStatus);
    List<ProductModel> findAll();
    int updateProduct(ProductModel product);

}
