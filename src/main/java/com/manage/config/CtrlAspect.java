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
import java.util.Arrays;

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
    private   HttpServletRequest  request;
    private   HttpServletResponse response;
    private String methodName;
    private final Logger              logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.manage.ctrl..*.*(..))")
    public void ctrlPointCut()
    {
    }

    @Before("ctrlPointCut()")
    public void deBefore(JoinPoint joinPoint)
    {
        methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.info("---------------------------------------------------------------------------------");
        logger.info("请求开始："+methodName);
        logger.info("接口请求参数："+Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "ctrlPointCut()")
    public void doAfterReturning(Object ret)
    {
        logger.info("请求返回结果："+ ret);
        logger.info("请求结束："+methodName);
        logger.info("---------------------------------------------------------------------------------");
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
