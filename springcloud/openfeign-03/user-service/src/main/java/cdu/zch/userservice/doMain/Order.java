package cdu.zch.userservice.doMain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Zch
 * @date 2023/6/29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private Integer id;
    private String name;
    private Double price;
    private Date time;

}
