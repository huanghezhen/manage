package com.manage.config;

import com.manage.entity.Ret;
import com.manage.entity.table.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: CtrlAspect
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/4/27 15:39
 */
@Aspect
@Component
public class CtrlAspect
{
    private final Logger              logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.manage.ctrl..*.*(..))")
    public void ctrlPointCut()
    {
    }
    @Around("ctrlPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable
    {
        String methodName = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
        logger.info("---------------------------------------------------------------------------------开始");
        logger.info("请求开始：" + methodName);
        if (pjp.getArgs().length > 0){
            Object param = pjp.getArgs()[0];
            if (param != null)
            {
                logger.info("接口请求参数：" + param);
            }
            else
            {
                logger.info("接口请求参数为空");
            }
        }else{
            logger.info("接口请求参数为空");
        }
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        // todo 上线去掉自动登陆功能
       // autoLogin(session);
        Object user = session.getAttribute(Const.SESSION_USER);
        Object ret;
        if (Const.CAN_NOT_LOGIN_LIST.contains(methodName) || user != null){
            ret = pjp.proceed();
        }else{
            ret = Ret.getRet(Const.failedEnum.UNLOGIN.getCode(),Const.failedEnum.UNLOGIN.getMsg());
        }
        if (ret != null)
        {
            logger.info("请求返回结果：" + ret);
        }
        else
        {
            logger.info("请求返回结果为空");
        }
        logger.info("请求结束：" + methodName);
        logger.info("---------------------------------------------------------------------------------结束");
        return ret;
    }

    private void autoLogin(HttpSession session){
        User user = new User();
        user.setMerchantCode("001");
        user.setUserCode("001");
        user.setUserName("admin");
        user.setState(1);
        session.setAttribute(Const.SESSION_USER,user);
    }
}
