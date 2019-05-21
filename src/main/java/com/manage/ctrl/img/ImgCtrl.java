package com.manage.ctrl.img;

import com.manage.entity.Ret;
import com.manage.entity.img.ImgCategoryBO;
import com.manage.entity.img.ImgInfoBO;
import com.manage.entity.table.ImgCategory;
import com.manage.service.iface.img.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ImgCtrl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/5/9 20:23
 */
@RestController
@RequestMapping("/imgCtrl")
public class ImgCtrl
{
    @Autowired
    private ImgService imgService;
    @RequestMapping(value = "/getImgCategory",method = RequestMethod.GET)
    public Ret getImgCategory(String str,HttpServletRequest request){
        return imgService.getImgCategory(request);
    }

    @RequestMapping(value = "/addImgCategory",method = RequestMethod.GET)
    public Ret addImgCategory(ImgCategoryBO imgCategory,HttpServletRequest request){
        return imgService.addImgCategory(imgCategory,request);
    }

    @RequestMapping(value = "/editImgCategory",method = RequestMethod.GET)
    public Ret editImgCategory(ImgCategory imgCategory){
        return imgService.editImgCategory(imgCategory);
    }

    @RequestMapping(value = "/deleteImgCategory",method = RequestMethod.GET)
    public Ret deleteImgCategory(ImgCategory imgCategory){
        return imgService.deleteImgCategory(imgCategory);
    }

    @RequestMapping(value = "/uploadImg")
    public Ret uploadImg(Integer categoryId,MultipartFile file,HttpServletRequest request){
        return imgService.uploadImg(categoryId,file,request);
    }
    @RequestMapping(value = "/uploadImgBackLayVo")
    public Ret uploadImgBackLayVo(Integer categoryId,MultipartFile file,HttpServletRequest request){
        return imgService.uploadImgBackLayVo(categoryId,file,request);
    }

    @RequestMapping(value = "/countImgInfo")
    public Ret countImgInfo(String categoryIdList,HttpServletRequest request){
        return imgService.countImgInfo(categoryIdList,request);
    }

    @RequestMapping(value = "/listImgInfo")
    public Ret listImgInfo(ImgInfoBO imgInfoBO,HttpServletRequest request){
        return imgService.listImgInfo(imgInfoBO,request);
    }
}
