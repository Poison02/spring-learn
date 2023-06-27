package cdu.zch.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Zch
 * @date 2023/6/27
 **/
@Configuration // 代替xml配置
@ComponentScan({"cdu.zch.spring6.service"}) // 组件扫描
@EnableAspectJAutoProxy // 启用Aspect的自动代理
public class Spring6Config {
}
