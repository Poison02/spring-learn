package cn.zch;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类代替Spring的配置文件
 * @author Zch
 * @data 2023/6/24
 **/
@Configuration
@ComponentScan({"cn.zch.dao", "cn.zch.service"})
public class Spring6Config {
}
