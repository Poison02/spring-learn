package cdu.zch.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Component
@Aspect
public class SecurityAspect {

    @Pointcut("execution(* cdu.zch.spring6.biz..save*(..))")
    public void savePointCut() {}

    @Pointcut("execution(* cdu.zch.spring6.biz..delete*(..))")
    public void deletePointCut() {}

    @Pointcut("execution(* cdu.zch.spring6.biz..update*(..))")
    public void updatePointCut() {}

    @Before("savePointCut() || deletePointCut() || updatePointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTime = sdf.format(new Date());
        // 输出日志信息
        System.out.println(nowTime + "zhangsan : " + joinPoint);
    }

}
