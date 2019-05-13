package com.manage.service.iface.user;

import com.manage.entity.Ret;
import com.manage.entity.table.User;
import com.manage.entity.user.UserLoginModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 14:23
 */
public interface UserService
{
    Ret login(UserLoginModel userLoginModel, HttpServletRequest request);
    Ret home(HttpServletRequest request);
    Ret logout(HttpServletRequest request);
    void getCode(HttpServletRequest request, HttpServletResponse response);

    List<User> getAllUser();
}
