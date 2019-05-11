package com.manage.service.iface.img;

import com.manage.entity.Ret;
import com.manage.entity.img.ImgCategoryBO;
import com.manage.entity.table.ImgCategory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ImgService
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/5/9 20:27
 */
public interface ImgService
{
    Ret getImgCategory(HttpServletRequest request);
    Ret addImgCategory(ImgCategoryBO imgCategory);
    Ret editImgCategory(ImgCategory imgCategory);
    Ret deleteImgCategory(ImgCategory imgCategory);
    Ret uploadImg(String categoryId,MultipartFile file,HttpServletRequest request);
}
