package com.manage.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName: InitData
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/28 21:53
 */
@Component
public class InitData implements ApplicationRunner
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        logger.info("开始初始化参数");
        // 添加可以不登陆访问的接口
        Const.CAN_NOT_LOGIN_LIST.add("com.manage.ctrl.user.UserCtrl.getCode");
        Const.CAN_NOT_LOGIN_LIST.add("com.manage.ctrl.user.UserCtrl.login");
        logger.info("初始化参数结束");
    }
}
