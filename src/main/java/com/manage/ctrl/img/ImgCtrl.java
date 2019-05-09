package com.manage.ctrl.img;

import com.manage.entity.Ret;
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
}
