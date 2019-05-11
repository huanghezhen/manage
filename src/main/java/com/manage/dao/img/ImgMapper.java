package com.manage.dao.img;

import com.manage.entity.img.ImgCategoryBO;
import com.manage.entity.img.ImgInfoBO;
import com.manage.entity.table.ImgCategory;
import com.manage.entity.table.ImgInfo;

import java.util.List;

/**
 * @ClassName: ImgMapper
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/5/9 21:03
 */
public interface ImgMapper
{
    List<ImgCategoryBO> listImgCategory(String merchantCode);
    int getParentId(int id);
    int addImgCategory(ImgCategory imgCategory);
    int editImgCategory(ImgCategory imgCategory);
    int deleteImgCategory(ImgCategory imgCategory);
    int countImgInfo(ImgInfoBO imgInfoBO);
    List<ImgInfo> listImgInfo(ImgInfoBO imgInfoBO);
}
