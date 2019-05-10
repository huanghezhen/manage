package com.manage.ctrl.img;

import com.manage.entity.Ret;
import com.manage.entity.table.ImgCategory;
import com.manage.service.iface.img.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Ret addImgCategory(ImgCategory imgCategory){
        return imgService.addImgCategory(imgCategory);
    }

    @RequestMapping(value = "/editImgCategory",method = RequestMethod.GET)
    public Ret editImgCategory(ImgCategory imgCategory){
        return imgService.editImgCategory(imgCategory);
    }

    @RequestMapping(value = "/deleteImgCategory",method = RequestMethod.GET)
    public Ret deleteImgCategory(ImgCategory imgCategory){
        return imgService.deleteImgCategory(imgCategory);
    }
}
