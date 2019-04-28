package com.manage.dao.user;

import com.manage.entity.table.User;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/28 19:21
 */
public interface UserMapper
{
    User getUser(String userCode);
}
