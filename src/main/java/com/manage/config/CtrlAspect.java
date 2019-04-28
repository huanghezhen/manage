package com.manage.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private       HttpServletRequest  request;
    private       HttpServletResponse response;
    private       String              methodName;
    private final Logger              logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.manage.ctrl..*.*(..))")
    public void ctrlPointCut()
    {
    }

    @Before("ctrlPointCut()")
    public void deBefore(JoinPoint joinPoint)
    {
        methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.info("开始---------------------------------------------------------------------------------");
        logger.info("-----请求开始：" + methodName);
        Object param = joinPoint.getArgs()[0];
        if (param != null)
        {
            logger.info("-----接口请求参数：" + param);
        }
        else
        {
            logger.info("-----接口请求参数为空");
        }

    }

    @AfterReturning(returning = "ret", pointcut = "ctrlPointCut()")
    public void doAfterReturning(Object ret)
    {
        if (ret != null)
        {
            logger.info("-----请求返回结果：" + ret);
        }
        else
        {
            logger.info("-----请求返回结果为空");
        }
        logger.info("-----请求结束：" + methodName);
        logger.info("结束---------------------------------------------------------------------------------");
    }

    @Around("ctrlPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        request = attributes.getRequest();
        response = attributes.getResponse();
        return pjp.proceed();
    }
}
