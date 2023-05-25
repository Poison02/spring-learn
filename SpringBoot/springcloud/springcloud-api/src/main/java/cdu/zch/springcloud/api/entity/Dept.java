package cdu.zch.springcloud.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Zch
 * @data 2023/5/25
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable {

    // 主键
    private Long deptNo;

    // 名字
    private String dName;

    // 这个数据存在哪个数据库，微服务，
    // 一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String dbSource;

    public Dept(String dName) {
        this.dName = dName;
    }


}
