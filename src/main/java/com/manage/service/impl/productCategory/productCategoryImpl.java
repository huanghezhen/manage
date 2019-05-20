package com.manage.service.impl.productCategory;

import com.manage.config.Const;
import com.manage.dao.productCategory.ProductCategoryMapper;
import com.manage.entity.Ret;
import com.manage.entity.productCategory.ProductCategoryModel;
import com.manage.service.iface.productCategory.ProductCategoryService;
import com.manage.vo.TreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<TreeVO> findCategoryAndChild(Integer parentId) {
        //1.先查出所有父类
        List<ProductCategoryModel> productCategoryModelList = productCategoryMapper.findByParentId(parentId);
        //2.将数据进行递归  当datas为null的时候则表示没有下级  则推出
        return findChild(productCategoryModelList,parentId);
    }

    public List<TreeVO> findChild(List<ProductCategoryModel> byParentIds,Integer parentId) {
        ArrayList<TreeVO> treeVOS = new ArrayList<>();
        if(byParentIds!=null){
            for(ProductCategoryModel productCategoryModel:byParentIds){
                //1.先查出所有父类
                List<ProductCategoryModel> byParentId = productCategoryMapper.findByParentId(productCategoryModel.getCategoryId());
                    TreeVO treeVO = new TreeVO();
                    treeVO.setId(productCategoryModel.getCategoryId());
                    treeVO.setLabel(productCategoryModel.getCategoryName());
                    treeVO.setParentId(productCategoryModel.getParentId());
                    //TODO
                    if(productCategoryModel.getParentId()==parentId){
                        //2.将数据进行递归  当datas为null的时候则表示没有下级  则推出
                        treeVO.setChildren(findChild(byParentId,productCategoryModel.getCategoryId()));
                    }
                    treeVOS.add(treeVO);
                }
            return treeVOS;
        }
        return treeVOS;
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

    @Override
    public int deleteCategoryIdAndChild(Integer categoryId) {
        List<ProductCategoryModel> byParentId = findByParentId(categoryId);
        List<Integer> collect = byParentId.stream().map(e -> e.getCategoryId()).collect(Collectors.toList());
        List<Integer> categoryIdChilds = new ArrayList<>();
        categoryIdChilds.add(categoryId);
        categoryIdChilds.addAll(findCategoryIdChilds(collect));
        int i = productCategoryMapper.deleteByIds(categoryIdChilds);
        return i;
    }

    public List<Integer> findCategoryIdChilds(List<Integer> categoryIds){
        ArrayList<Integer> ids = new ArrayList<>();
        if(categoryIds!=null){
            for(Integer id:ids){
                //1.先查出所有父类
                List<ProductCategoryModel> byParentId = productCategoryMapper.findByParentId(id);
                List<Integer> collectIds= byParentId.stream().map(e -> e.getCategoryId()).collect(Collectors.toList());
                findCategoryIdChilds(collectIds);
            }
            ids.addAll(categoryIds);
            return ids;
        }
        return ids;
    }
}
