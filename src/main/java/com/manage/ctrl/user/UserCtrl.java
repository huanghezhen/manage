package com.manage.ctrl.user;

import com.manage.entity.Ret;
import com.manage.entity.user.UserLoginModel;
import com.manage.service.iface.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: UserCtrl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 13:06
 */
@RestController
@RequestMapping("/userCtrl")
public class UserCtrl
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Ret login(UserLoginModel userLoginModel,HttpServletRequest request){
        Ret ret = userService.login(userLoginModel, request);
        return ret;
    }

    /**
     * 图片验证码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        userService.getCode(request,response);
    }

}
