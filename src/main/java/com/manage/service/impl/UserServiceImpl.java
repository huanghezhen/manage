package com.manage.service.impl;

import com.manage.dao.UserMapper;
import com.manage.entity.User;
import com.manage.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/22 21:26
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser()
    {
        return userMapper.getUser("1");
    }
}
