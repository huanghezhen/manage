package com.manage.service.impl.img;

import com.manage.config.Const;
import com.manage.dao.img.ImgMapper;
import com.manage.entity.Ret;
import com.manage.entity.img.ImgCategoryBO;
import com.manage.entity.img.ImgInfoBO;
import com.manage.entity.table.ImgCategory;
import com.manage.entity.table.ImgInfo;
import com.manage.entity.table.User;
import com.manage.service.iface.img.ImgService;
import com.manage.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Override
    public Ret getImgCategory(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.SESSION_USER);
        List<ImgCategoryBO> imgCategories = imgMapper.listImgCategory(user.getMerchantCode());
        ImgCategoryBO imgCategoryTree = getImgCategoryTree(imgCategories, user.getMerchantCode());
        List<ImgCategoryBO> imgCategoryBOList = new ArrayList<>();
        imgCategoryBOList.add(imgCategoryTree);
        return Ret.getRetT(imgCategoryBOList);
    }

    @Override
    public Ret addImgCategory(ImgCategoryBO imgCategory, HttpServletRequest request)
    {
        if (1 == imgCategory.getAddType())
        {
            if (0 == imgCategory.getParentId())
            {
                return Ret.getRet(Const.failedEnum.ALL_CATEGORY_ERROR.getCode(), Const.failedEnum.ALL_CATEGORY_ERROR.getMsg());
            }
            imgCategory.setParentId(imgMapper.getParentId(imgCategory.getParentId()));
        }
        int i = imgMapper.addImgCategory(imgCategory);
        if (i > 0)
        {
            return getImgCategory(request);
        }
        else
        {
            return Ret.getRet(Const.failedEnum.ADD_IMG_CATEGORY_ERROR.getCode(), Const.failedEnum.ADD_IMG_CATEGORY_ERROR.getMsg());
        }
    }

    @Override
    public Ret editImgCategory(ImgCategory imgCategory)
    {
        int i = imgMapper.editImgCategory(imgCategory);
        if (i > 0)
        {
            return Ret.getRet();
        }
        else
        {
            return Ret.getRet(Const.failedEnum.EDIT_IMG_CATEGORY_ERROR.getCode(), Const.failedEnum.EDIT_IMG_CATEGORY_ERROR.getMsg());
        }
    }

    @Override
    public Ret deleteImgCategory(ImgCategory imgCategory)
    {
        int i = imgMapper.deleteImgCategory(imgCategory);
        if (i > 0)
        {
            return Ret.getRet();
        }
        else
        {
            return Ret.getRet(Const.failedEnum.DELETE_IMG_CATEGORY_ERROR.getCode(), Const.failedEnum.DELETE_IMG_CATEGORY_ERROR.getMsg());
        }
    }

    @Override
    public Ret uploadImg(Integer categoryId, MultipartFile file, HttpServletRequest request)
    {
        User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
        try
        {
            String path = upload(file, request);
            ImgInfo imgInfo = new ImgInfo();
            imgInfo.setCategoryId(categoryId);
            imgInfo.setImgUrl(path);
            imgInfo.setMerchantCode(user.getMerchantCode());
            imgInfo.setUserCode(user.getUserCode());
            int i = imgMapper.addImgInfo(imgInfo);
            if (i <= 0)
            {
                return Ret.getRet(Const.failedEnum.UPLOAD_IMG__ERROR.getCode(),
                        Const.failedEnum.UPLOAD_IMG__ERROR.getMsg() + file.getOriginalFilename());
            }
            return Ret.getRetT(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return Ret.getRet(Const.failedEnum.UPLOAD_IMG__ERROR.getCode(), Const.failedEnum.UPLOAD_IMG__ERROR.getMsg() + file.getOriginalFilename());
        }
    }

    @Override
    public Ret countImgInfo(String categoryIdList, HttpServletRequest request)
    {
        categoryIdList = categoryIdList.substring(1, categoryIdList.length() - 1);
        ImgInfoBO imgInfoBO = new ImgInfoBO();
        imgInfoBO.setCategoryIdList(categoryIdList);
        User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
        imgInfoBO.setMerchantCode(user.getMerchantCode());
        return Ret.getRetT(imgMapper.countImgInfo(imgInfoBO));
    }

    @Override
    public Ret listImgInfo(ImgInfoBO imgInfoBO, HttpServletRequest request)
    {
        imgInfoBO.setCategoryIdList(imgInfoBO.getCategoryIdList().substring(1, imgInfoBO.getCategoryIdList().length() - 1));
        User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
        imgInfoBO.setMerchantCode(user.getMerchantCode());
        imgInfoBO.setPageNum((imgInfoBO.getPageNum() - 1) * imgInfoBO.getPageSize());
        return Ret.getRetT(imgMapper.listImgInfo(imgInfoBO));
    }

    private ImgCategoryBO getImgCategoryTree(List<ImgCategoryBO> imgCategorieList, String merchantCode)
    {
        ImgCategoryBO imgCategoryBO = new ImgCategoryBO();
        imgCategoryBO.setId(0);
        imgCategoryBO.setLabel(Const.FIRST_LABEL);
        imgCategoryBO.setMerchantCode(merchantCode);
        imgCategoryBO.setChildren(new ArrayList<>());
        for (ImgCategoryBO imgCategory : imgCategorieList)
        {
            if (0 == imgCategory.getParentId())
            {
                imgCategoryBO.getChildren().add(findImgCategoryChildren(imgCategory, imgCategorieList));
            }
        }
        return imgCategoryBO;
    }

    private ImgCategoryBO findImgCategoryChildren(ImgCategoryBO imgCategoryP, List<ImgCategoryBO> imgCategorieList)
    {
        imgCategoryP.setChildren(new ArrayList<>());
        for (ImgCategoryBO imgCategoryC : imgCategorieList)
        {
            if (imgCategoryP.getId() == imgCategoryC.getParentId())
            {
                imgCategoryP.getChildren().add(findImgCategoryChildren(imgCategoryC, imgCategorieList));
            }
        }
        return imgCategoryP;
    }

    private String upload(MultipartFile file, HttpServletRequest request) throws IOException
    {

        String fileName = file.getOriginalFilename();// 文件名称
        String last = fileName.substring(fileName.lastIndexOf("."));
        fileName = sequenceGenerator.next() + last;
        // 项目在容器中实际发布运行的根路径
        String realPath = ResourceUtils.getURL("classpath:").getPath() + Const.IMG_PATH;
        // 设置存放图片文件的路径
        String path = realPath + fileName;
        // 转存文件到指定的路径
        file.transferTo(new File(path));
        return fileName;
    }
}
