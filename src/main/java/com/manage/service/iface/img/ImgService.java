package com.manage.service.iface.img;

import com.manage.entity.Ret;

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
}
