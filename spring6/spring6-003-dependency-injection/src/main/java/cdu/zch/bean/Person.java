package cdu.zch.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Zch
 * @data 2023/6/16
 **/
public class Person {

    // 注入List集合
    private List<String> names;
    // 注入Set集合
    private Set<String> address;
    // 注入Map集合
    private Map<Integer, String> phone;
    // 注入属性类，properties本质上也是Map集合，父类是HashTable，实现了Map
    // 但是和Map有点区别,k-v只能是字符串
    private Properties properties;

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", address=" + address +
                ", phone=" + phone +
                ", properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }



    public void setPhone(Map<Integer, String> phone) {
        this.phone = phone;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }
}
