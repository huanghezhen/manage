package com.manage.service.impl.img;

import com.manage.config.Const;
import com.manage.dao.img.ImgMapper;
import com.manage.entity.Ret;
import com.manage.entity.img.ImgCategoryBO;
import com.manage.entity.table.ImgCategory;
import com.manage.entity.table.User;
import com.manage.service.iface.img.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ImgServiceImpl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/5/9 20:27
 */
@Service
public class ImgServiceImpl implements ImgService
{
    @Autowired
    private ImgMapper imgMapper;
    @Override
    public Ret getImgCategory(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.SESSION_USER);
        List<ImgCategoryBO> imgCategories = imgMapper.listImgCategory(user.getMerchantCode());
        ImgCategoryBO imgCategoryTree = getImgCategoryTree(imgCategories);
        return Ret.getRetT(imgCategoryTree);
    }

    @Override
    public Ret addImgCategory(ImgCategory imgCategory)
    {
        return null;
    }

    @Override
    public Ret editImgCategory(ImgCategory imgCategory)
    {
        return null;
    }

    @Override
    public Ret deleteImgCategory(ImgCategory imgCategory)
    {
        return null;
    }

    private ImgCategoryBO getImgCategoryTree(List<ImgCategoryBO> imgCategorieList){
        ImgCategoryBO imgCategoryBO = new ImgCategoryBO();
        imgCategoryBO.setId(0);
        imgCategoryBO.setLabel("全部");
        imgCategoryBO.setChildren(new ArrayList<>());
        for (ImgCategoryBO imgCategory:imgCategorieList){
            if (0 == imgCategory.getParentId()){
                imgCategoryBO.getChildren().add(findImgCategoryChildren(imgCategory,imgCategorieList));
            }
        }
        return imgCategoryBO;
    }
    private ImgCategoryBO findImgCategoryChildren(ImgCategoryBO imgCategoryP,List<ImgCategoryBO> imgCategorieList){
        for (ImgCategoryBO imgCategoryC:imgCategorieList){
            if (imgCategoryP.getId() == imgCategoryC.getParentId()){
                imgCategoryP.setChildren(new ArrayList<>());
                imgCategoryP.getChildren().add(findImgCategoryChildren(imgCategoryC,imgCategorieList));
            }
        }
        return imgCategoryP;
    }
}
