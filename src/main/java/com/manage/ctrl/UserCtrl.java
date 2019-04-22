package com.manage.ctrl;

import com.manage.entity.User;
import com.manage.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserCtrl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/22 20:42
 */
@RestController
@RequestMapping("/userCtrl")
public class UserCtrl
{
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public User getUser(){
        return userService.getUser();
    }
}
