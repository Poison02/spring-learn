package cdu.zch.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author Zch
 * @data 2023/6/24
 **/
// 标注注解的注解，元注解，@Target表示自定义注解出现的位置
// 以下标注表示该注解可以出现在类上，使用某个注解的时候，注解的属性名是value，value可以省略
// 如果注解的属性值是数组，并且数组中只有一个元素，大括号可以省略
@Target(ElementType.TYPE)
// @Retention也是一个元注解。
// 以下配置用来标注@Component注解最终保留在class文件中，并且可以被反射机制读取到
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    // 定义注解的属性
    // String 属性类型
    // value 属性名
    String value();

    // 其他属性
    // 属性类型String
    // 属性名 name
    // String name();

}
