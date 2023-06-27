package cdu.zch.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Component("logAspect")
@Aspect // 切面类是需要使用@Aspect进行标注的
@Order(2) // 切面执行顺序由Order控制，数字越小，优先级越高
public class LogAspect { // 切面

    // 切面 == 通知 + 切点
    // 通知就是具体要编写的增强代码
    // 这里通知 Advice以方法的形式出现
    /*
    @Before 注解标注的方法就是一个前置通知
    其中需要写切点表达式 修饰符 返回值类型 全限定类型 方法 参数 异常
     */
    /*@Before("execution(* cdu.zch.spring6.service..*(..))")
    public void strong() {
        System.out.println("我是一段增强代码...");
    }*/

    // 通用切点表达式
    @Pointcut("execution(* cdu.zch.spring6.service..*(..))")
    public void universal() {
        // 这个方法只是一个通用切点表达式
    }

    // 前置通知
    @Before("universal()")
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知...");
        // 这个joinPoint Spring自动传过来
        Signature signature = joinPoint.getSignature(); // 获取目标方法的签名
        // 通过方法签名可以获取到一个方法的具体信息
        // 获取目标方法的方法名
        System.out.println("目标方法的方法名为：" + signature.getName());
    }

    // 后置通知
    @AfterReturning("universal()")
    public void afterReturning() {
        System.out.println("我是后置通知");
    }

    // 环绕通知
    /*
    环绕是最大范围的通知，在前置之前，后置之后
     */
    @Around("universal()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面代码
        System.out.println("前环绕");
        // 执行目标
        joinPoint.proceed(); // 执行目标
        // 后面代码
        System.out.println("后环绕");
    }

    // 异常通知
    @AfterThrowing("universal()")
    public void afterThrowing() {
        System.out.println("发生了异常通知");
    }

    // 最终通知
    @After("universal()")
    public void afterAdvice() {
        System.out.println("最终通知...");
    }
}
