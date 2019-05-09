package com.manage.entity.img;

import com.manage.entity.table.ImgCategory;

import java.util.List;

/**
 * @ClassName: ImgCategoryBO
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/5/9 10:28
 */
public class ImgCategoryBO extends ImgCategory
{
    // 子类集合
    private List<ImgCategoryBO> imgCategorieList;


    public List<ImgCategoryBO> getImgCategorieList()
    {
        return imgCategorieList;
    }

    public void setImgCategorieList(List<ImgCategoryBO> imgCategorieList)
    {
        this.imgCategorieList = imgCategorieList;
    }
}
