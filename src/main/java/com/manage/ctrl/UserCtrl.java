package com.manage.ctrl;

import com.manage.entity.Ret;
import com.manage.entity.User;
import com.manage.service.iface.UserService;
import com.manage.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private       UserService userService;
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public Ret<User> getUser()
    {
        redisUtil.set("aaa", "111");
        logger.info("hhhhhhhhhhhhhhhhhhhhhhhh---------"+redisUtil.get("aaa"));
        User user = userService.getUser();
        Ret<User> ret = new Ret<>(user);
        return ret;
    }
}
