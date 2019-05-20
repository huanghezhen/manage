package com.manage.ctrl.productCategory;

import com.manage.config.Const;
import com.manage.entity.Ret;
import com.manage.entity.productCategory.ProductCategoryModel;
import com.manage.exception.ManageException;
import com.manage.service.iface.productCategory.ProductCategoryService;
import com.manage.vo.TreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
        return new Ret(productCategoryModel, Const.SUCCEED,Const.SUCCEED_MSG);
    }

    @RequestMapping("/findAll")
    public Ret findAll(){
        return new Ret( productCategoryService.findCategoryAndChild(0),Const.SUCCEED,Const.SUCCEED_MSG);
    }

    @RequestMapping("/findByParentId")
    public Ret findByParentId(@RequestParam("parentId") Integer parentId ){
        List<ProductCategoryModel> byParentId = productCategoryService.findByParentId(parentId);
        if(CollectionUtils.isEmpty(byParentId)){
            throw new ManageException(Const.failedEnum.PRODUCT_CATEGORY_SON_NOT_EXIT);
        }
        return new Ret(byParentId,Const.SUCCEED,Const.SUCCEED_MSG);
    }
    @RequestMapping("/saveProductCategory")
    public Ret saveProductCategory(TreeVO treeVO){
        ProductCategoryModel productCategoryModel = new ProductCategoryModel();
        productCategoryModel.setParentId(Integer.valueOf(treeVO.getParentId()));
        productCategoryModel.setCategoryName(treeVO.getLabel());
        productCategoryModel.setCreateTime(new Date());
        int resultCode = productCategoryService.saveProductCategory(productCategoryModel);
        if(resultCode<0){
            throw new ManageException(Const.failedEnum.SAVE_ERROR);
        }
        return Ret.getRetT(findAll().getData());
    }
    @RequestMapping("/updateProductCategory")
    public Ret updateProductCategory(TreeVO treeVO){
        ProductCategoryModel productCategoryModel = new ProductCategoryModel();
        productCategoryModel.setCategoryId(Integer.valueOf(treeVO.getId()));
        productCategoryModel.setCategoryName(treeVO.getLabel());
        int resultCode = productCategoryService.updateProductCategory(productCategoryModel);
        if(resultCode<0){
            throw new ManageException(Const.failedEnum.UPDATE_ERROR);
        }
        return Ret.getRetT(findAll().getData());
    }

    @RequestMapping("/deleteCategoryIdAndChild")
    public Ret deleteCategoryIdAndChild(Integer categoryId){
        int resultCode = productCategoryService.deleteCategoryIdAndChild(categoryId);
        if(resultCode<0){
            throw new ManageException(Const.failedEnum.UPDATE_ERROR);
        }
        return Ret.getRetT(findAll().getData());
    }






}
