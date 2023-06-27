package cdu.zch.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Component
@Aspect
@Order(3)
public class SecurityAspect {

    // 通知加切点
    @Before("execution(* cdu.zch.spring6.service..*(..))")
    public void before() {
        System.out.println("安全切面的前置通知");
    }

}
