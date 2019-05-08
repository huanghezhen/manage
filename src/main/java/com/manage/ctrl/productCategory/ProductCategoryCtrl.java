package com.manage.ctrl.productCategory;

import com.manage.config.Const;
import com.manage.entity.Ret;
import com.manage.entity.productCategory.ProductCategoryModel;
import com.manage.exception.ManageException;
import com.manage.service.iface.productCategory.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: productCategory
 * @Description: 商品分类控制层
 * @author: cl-Z
 * @date: 2019/5/7 18:36
 * @Version: V1.0
 */
@RestController
@RequestMapping("/productCategoryCtrl")
public class ProductCategoryCtrl {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("/finOne")
    public Ret finOne(@RequestParam("categoryId") Integer categoryId){
        ProductCategoryModel productCategoryModel = productCategoryService.findOne(categoryId);
        if(productCategoryModel==null){
            throw new ManageException(Const.failedEnum.PRODUCT_CATEGORY_NOT_EXIT);
        }
        return new Ret(productCategoryModel, Const.SESSION_CODE,Const.SUCCEED_MSG);
    }

    @RequestMapping("/findAll")
    public Ret findAll(){
        List<ProductCategoryModel> all = productCategoryService.findAll();
        return new Ret(all,Const.SESSION_CODE,Const.SUCCEED_MSG);
    }

    @RequestMapping("/findByParentId")
    public Ret findByParentId(@RequestParam("parentId") Integer parentId ){
        List<ProductCategoryModel> byParentId = productCategoryService.findByParentId(parentId);
        if(CollectionUtils.isEmpty(byParentId)){
            throw new ManageException(Const.failedEnum.PRODUCT_CATEGORY_SON_NOT_EXIT);
        }
        return new Ret(byParentId,Const.SESSION_CODE,Const.SUCCEED_MSG);
    }

    @RequestMapping("/saveProductCategory")
    public Ret saveProductCategory(@RequestParam("productgory")ProductCategoryModel productCategoryModel){
        int resultCode = productCategoryService.saveProductCategory(productCategoryModel);
        if(resultCode<0){
            throw new ManageException(Const.failedEnum.SAVE_ERROR);
        }
        return new Ret(Const.SESSION_CODE,Const.SUCCEED_MSG);
    }
    @RequestMapping("/updateProductCategory")
    public Ret updateProductCategory(@RequestParam("productCategory") ProductCategoryModel productCategoryModel){
        int resultCode = productCategoryService.updateProductCategory(productCategoryModel);
        if(resultCode<0){
            throw new ManageException(Const.failedEnum.UPDATE_ERROR);
        }
        return new Ret(Const.SESSION_CODE,Const.SUCCEED_MSG);
    }






}
