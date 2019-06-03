package com.manage.ctrl.product;

import com.manage.config.Const;
import com.manage.entity.Ret;
import com.manage.entity.TableRet;
import com.manage.entity.product.ProductModel;
import com.manage.entity.productCategory.ProductCategoryModel;
import com.manage.exception.ManageException;
import com.manage.service.iface.product.ProductService;
import com.manage.service.iface.productCategory.ProductCategoryService;
import com.manage.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ProductCtrl
 * @Description: 商品交互层
 * @author: cl-Z
 * @date: 2019/5/7 14:03
 * @Version: V1.0
 */
@RestController
@RequestMapping("/productCtrl")
public class ProductCtrl {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/saveProduct")
    public Ret saveProduct(ProductModel productModel){
        int resultCode = productService.saveProduct(productModel);
        if(resultCode<0){
            throw new ManageException(Const.failedEnum.SAVE_ERROR);
        }
        return Ret.getRet();
    }

    @RequestMapping("/findOne")
    public Ret findOne(@RequestParam("productId")String productId){
        ProductModel productModel = productService.findOne(productId);
        if(productModel==null){
            throw new ManageException(Const.failedEnum.PRODUCT_NOT_EXIT);
        }
        return new Ret(productModel, Const.SESSION_CODE,Const.SUCCEED_MSG);
    }

    @RequestMapping("/findAll")
    public Ret finAll(){
        List<ProductModel> all = productService.findAll();
        return new Ret(Const.SESSION_CODE,Const.SUCCEED_MSG);
    }

    @RequestMapping("/findUpAll")
    public Ret findUpAll(){
        //查出所有已经上架的商品
        List<ProductModel> upAll = productService.findUpAll(Const.PRODUCT_UP_STATUS);
        //得到所有的上架商品里包含的分类
        List<Integer> categoryIdList = upAll.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        //得到分类详情  得到一个分类集合
        List<ProductCategoryModel> productCategoryModelList =productCategoryService.findByIdIn(categoryIdList);
        //然后按照不同的分类得到相应的集合
        List<ProductVo> productVoList=new ArrayList<>();
        for(ProductCategoryModel productCategoryModel:productCategoryModelList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategoryModel.getCategoryName());
            productVo.setCategoryType(productCategoryModel.getCategoryType());
            List<ProductModel> productModels=new ArrayList<>();
            for(ProductModel productModel:upAll){
                if(productCategoryModel.getCategoryId().equals(productModel.getCategoryType())){
                    productModels.add(productModel);
                }
            }
            productVo.setProductModelVOList(productModels);
            productVoList.add(productVo);
        }

        //然后返回一个data返回
        return new Ret(productVoList,Const.SESSION_CODE,Const.SUCCEED_MSG);

    }
    @RequestMapping("/updateProduct")
    public Ret updateProduct(ProductModel productModel){
        int resultCode = productService.updateProduct(productModel);
        if (resultCode<0)
            throw new ManageException(Const.failedEnum.UPDATE_ERROR);
        return Ret.getRet();
    }


    @RequestMapping("/findProduct")
    public TableRet findProduct(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit){
        System.out.println("page:"+page+"limit:"+limit);
        ProductModel productModel = new ProductModel();
        List<ProductModel> allProduct = productService.getProductBySomething(productModel, null, null);
        if (allProduct.size()<0)
            throw new ManageException(Const.failedEnum.FIND_ERROR);
        List<ProductModel> productBySomething = productService.getProductBySomething(productModel,page, limit);
        return TableRet.getTableRetT(productBySomething,allProduct.size());
    }

    @RequestMapping("/delProduct")
    public Ret delProduct(@RequestParam("ids[]") String... ids){
        List<String> productIds = new ArrayList<>();
        System.out.println(ids[0]);
        for (String id:ids)
            productIds.add(id);
        int resultCode = productService.delProduct(productIds);
        if(resultCode<0)
            throw new ManageException(Const.failedEnum.UPDATE_ERROR);
        return Ret.getRet();
    }

}
