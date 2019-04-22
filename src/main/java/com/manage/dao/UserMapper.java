package com.manage.dao;

import com.manage.entity.User;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/22 21:02
 */
public interface UserMapper
{
    User getUser(String name);
}
