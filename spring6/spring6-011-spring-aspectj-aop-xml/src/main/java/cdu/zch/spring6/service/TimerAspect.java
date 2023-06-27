package cdu.zch.spring6.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @author Zch
 * @date 2023/6/27
 **/
public class TimerAspect {

    // 通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前环绕
        long begin = System.currentTimeMillis();
        joinPoint.proceed();
        // 后环绕
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

}
