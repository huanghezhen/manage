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
    // 插入方式  1 插入同级分类 2 插入子分类
    private int addType;
    // 子类集合
    private List<ImgCategoryBO> children;

    public int getAddType()
    {
        return addType;
    }

    public void setAddType(int addType)
    {
        this.addType = addType;
    }

    public List<ImgCategoryBO> getChildren()
    {
        return children;
    }

    public void setChildren(List<ImgCategoryBO> children)
    {
        this.children = children;
    }
}
