# mybatis小技巧
## 1. #{} 和 ${} 的区别

#{}的执行结果
```
Car{id=1, carNum='1001', brand='宝马x7', guidePrice=30.0, produceTime='2022-6-15', carType='燃油车'}
Car{id=4, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'}
Car{id=5, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'}
Car{id=6, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'}
```
${}的执行结果
```
org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column '燃油车' in 'where clause'
### The error may exist in CarMapper.xml
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType         from t_car         where car_type=燃油车
### Cause: java.sql.SQLSyntaxErrorException: Unknown column '燃油车' in 'where clause'
```

`#{}`：
- 底层使用PreparedStatement。特点：先进行SQL语句的编译，然后给SQL语句的占位符传值

`${}`：
- 底层使用Statement。特点：先进行SQL语句的拼接，然后再对SQL语句进行编译。存在SQL注入的风险

**优先使用#{}**，这是原则，避免SQL注入的风险。

## ${} 什么时候使用？

例子：

#{}执行结果：
```
org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''asc'' at line 3
### The error may exist in CarMapper.xml
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType         from t_car         order by produce_time ?
### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ''asc'' at line 3
```
${}执行结果：
```
Car{id=14, carNum='1003', brand='丰田霸道', guidePrice=30.0, produceTime='2000-10-11', carType='燃油车'}
Car{id=18, carNum='1004', brand='凯迪拉克', guidePrice=40.0, produceTime='2021-05-16', carType='燃油车'}
Car{id=1, carNum='1001', brand='宝马x7', guidePrice=30.0, produceTime='2022-6-15', carType='燃油车'}
Car{id=2, carNum='1002', brand='奔驰AMG', guidePrice=100.0, produceTime='2022-6-15', carType='氢能源'}
```
1. **如果需要SQL语句的关键字放到SQL语句中，只能使用${}**
2. **向SQL语句中拼接表名时，需要使用${}**
   - 现实业务，可能存在份表存储数据的情况，因为一张表存储，数据量太大，查询效率低。可以将这些数据有规律的分表存储
   ```
   业务背景：实际开发中，有的表数据量非常庞大，可能会采用分表方式进行存储，
   比如每天生成一张表，表的名字与日期挂钩，
   例如：2022年8月1日生成的表：t_user20220108。2000年1月1日生成的表：t_user20000101。
   此时前端在进行查询的时候会提交一个具体的日期，比如前端提交的日期为：2000年1月1日，那么后端就会根据这个日期动态拼接表名为：t_user20000101。
   有了这个表名之后，将表名拼接到sql语句当中，返回查询结果。
   ```
   
3. 批量删除 `delete from t_car where id in (${ids});`
4. 模糊查询 
   - `select id,car_num from t_car where brand like '%${brand}%';`
   - `select id,car_num from t_car where brand like concact('%', #{brand}, '%');`
   - `select id,car_num from t_car where brand like concact('%', '${brand}', '%');`
   - `select id,car_num from t_car where brand like "%"#{brand}"%";`

## `mappers`标签：
   ```
   <mappers>
        <mapper resource=""/>
        <mapper url=""/>
        <mapper class=""/>
    </mappers>
   ```
标签有三个：
   - `resource`：这种方式从类的根路径下开始查找资源，配置文件必须放在类路径下
   - `url`：绝对路径查找
   - `class`：全限定接口名，必须带有包名。
     如果写这个，则mapper.xml则必须和接口放在同一目录下，并且接口和xml文件名字要一致
注意！！！在IDEA的resources目录下，建目录的方法：`com/zch/mapper`