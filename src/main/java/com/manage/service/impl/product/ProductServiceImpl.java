package com.manage.service.impl.product;

import com.manage.dao.product.ProductMapper;
import com.manage.entity.product.ProductModel;
import com.manage.service.iface.product.ProductService;
import com.manage.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProductServiceImpl
 * @Description: 商品service实现层
 * @author: cl-Z
 * @date: 2019/5/7 10:03
 * @Version: V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Override
    public int saveProduct(ProductModel product) {
        product.setProductId(sequenceGenerator.next());
        int resultCode=productMapper.saveProduct(product);
        return resultCode;
    }

    @Override
    public ProductModel findOne(String productId) {
        ProductModel product = productMapper.findOne(productId);
        return product;
    }

    @Override
    public List<ProductModel> findUpAll(Integer productStatus) {
        List<ProductModel> upAll = productMapper.findUpAll(productStatus);
        return upAll;
    }

    @Override
    public List<ProductModel> findAll() {
        List<ProductModel> all = productMapper.findAll();
        return all;
    }

    @Override
    public int updateProduct(ProductModel product) {
        int resultCode = productMapper.updateProduct(product);
        return resultCode;
    }

    @Override
    public List<ProductModel> getProductBySomething(ProductModel productModel,Integer currPage,Integer pageSize) {

        if(currPage!=null){
            currPage=(currPage - 1) * pageSize;

        }
        List<ProductModel> countBySomething = productMapper.getProductBySomething(productModel,currPage,pageSize);
        return countBySomething;
    }

    @Override
    public int delProduct(List<String> productIds) {
        int resultCode = productMapper.delProduct(productIds);
        return resultCode;
    }
}
