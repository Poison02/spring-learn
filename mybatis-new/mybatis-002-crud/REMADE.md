使用mybatis进行CRUD

1. 什么是CRUD？
   - C：Create 增
   - R：Retrieve 查 检索
   - U：Update 改
   - D：Delete 删

2. Insert
   - 在JDBC中，占位符采用的是 `?`， 在mybatis中，使用占位符 `#{}`
   - 这两个占位符是等效的
   - Java程序中可以使用Map对insert进行传值
   ```java
   Map<String, Object> map = new HashMap<>();
   map.put("k1", "1111");
   map.put("k2", "比亚迪汉");
   map.put("k3", 10.00);
   map.put("k4", "2020-09-23");
   map.put("k5", "电车");
   int row = sqlSession.insert("insertCar", map);
   ```
   ```xml
   <insert id="insertCar">
        insert into t_car(id, car_num, brand, guide_price, produce_time, car_type)
        values(null, #{k1}, #{k2}, #{k3}, #{k4}, #{k5})
    </insert>
   ```
   - 通过Java类进行传值
   ```java
    Car car = new Car(null, "333", "比亚迪秦", 20.00,"2021-05-16", "燃油车");
    int row = sqlSession.insert("insertCar", car);
   ```
   ```xml
   <insert id="insertCar">
        insert into t_car(id, car_num, brand, guide_price, produce_time, car_type)
        values(null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
    </insert>
   ```
   这时的 `#{}` 里面写的是pojo类中的的**get方法去掉get剩下的字母首字母小写**！
   - 也就是说mybatis在底层给？传值的时候，调用pojo类的get方法进行传值！

3. delete
   - 需求：根据id删除数据
   ```java
   int row = sqlSession.delete("deleteById", 17);
   ```
   ```xml
   <delete id="deleteById">
        delete from t_car where id=#{id}
   </delete>
   ```

4. update
   - 根据id修改某条记录
   ```java
   Car car = new Car(15L, "1004", "凯迪拉克", 40.00,"2021-05-16", "燃油车");
   int row = sqlSession.update("updateById", car);
   ```
   ```xml
   <update id="updateById">
        update t_car
        set car_num=#{carNum}, brand=#{brand}, guide_price=#{guidePrice}, produce_time=#{produceTime}, car_type=#{carType}
        where id=#{id}
   </update>
   ```

5. retrieve 查询
   - 根据id查询
      - **注意**：这里需要在xml中加上 `resultType`
      ```xml
      <select id="selectById" resultType="cdu.zch.mybatis.pojo.Car">
          select * from t_car where id=#{id}
      </select>
      ```
     但是这里有坑，就是数据库中的字段和实体类的字段是有区别的！驼峰命名与蛇形命名，由于这个区别，查询到的结果就会有null
     - 可以有解决方法：修改sql语句，通过`as`起别名，别名对应实体类的字段
     ```
     select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
     from t_car
     where id=#{id}
     ```
   - 查询全部
   ```java
   List<Car> carList = sqlSession.selectList("selectAll");
   carList.forEach(System.out::println);
   ```
   ```xml
   <select id="selectAll" resultType="cdu.zch.mybatis.pojo.Car">
        select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
        from t_car
    </select>
   ```

7. 在sql mapper.xml文件中有一个`namespace`，这是用来指定命名空间的，用来防止id重复
   - 本质上，mybatis中的sqlId的完整写法是：`namespace.id` 这个id就是每条sql语句中xml的id。