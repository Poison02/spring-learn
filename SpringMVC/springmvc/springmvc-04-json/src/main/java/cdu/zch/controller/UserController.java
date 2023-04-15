package cdu.zch.controller;

import cdu.zch.entity.User;
import cdu.zch.utils.JsonUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Zch
 **/
@RestController
public class UserController {

    /**
     * 使用jackson
     * */
    @RequestMapping("/j1")
    public String json1() {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("hahaha", 3, "男");
        //将我们的对象解析成为json格式
        String str = null;
        try {
            str = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return str;
    }

    @RequestMapping("/j2")
    public String json2() {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }

    /**
     * 使用fastjson
     * */
    @RequestMapping("/j3")
    public String json3() {
        //创建一个对象
        User user1 = new User("hahah1", 3, "男");
        User user2 = new User("hahah2", 3, "男");
        User user3 = new User("hahah3", 3, "男");
        User user4 = new User("haha4", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "Hello";
    }
}
