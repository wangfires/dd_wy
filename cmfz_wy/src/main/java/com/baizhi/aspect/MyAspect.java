package com.baizhi.aspect;

import com.baizhi.dao.LogMapper;
import com.baizhi.entity.Log;
import com.baizhi.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class MyAspect {
    @Pointcut("@annotation(testAspect)")
    public void pointcut(TestAspect testAspect){}
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private HttpServletRequest request;
    @Around("@annotation(testAspect)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,TestAspect testAspect){
        System.out.println("进入环绕通知");
        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        User user = new User();
        user.setName("ww");
        log.setUsername(user.getName());
        Date date = new Date();
        log.setCreatedate(date);
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.setMethodName(testAspect.value());
        System.out.println(log);
        try {
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println("proceed:"+proceed);
            log.setSuccess("成功");
            logMapper.insertSelective(log);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.setSuccess("失败");
            logMapper.insertSelective(log);
            System.out.println(log);
            return null;
        }

    }
}
