package com.manage.dao.user;

import com.manage.entity.table.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/28 19:21
 */
@Component("userMapper")
public interface UserMapper
{
    User getUser(String userCode);
    List<User> getAllUser();
}
