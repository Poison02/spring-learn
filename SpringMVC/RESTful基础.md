RESTFUL是一种网络应用程序的**设计风格和开发方式**，基于HTTP，可以使用XML或者JSON格式定义。<br />RESTful设计风格的典型表现就是：将某些唯一的请求参数的值放在URL中，使之称为URL的一部分<br />RESTful只是一种设计风格，并不是一种规定，没有明确的或统一的执行方式。<br />例如在开发中，以处理用户数据为例：

- `/users`：查看用户列表
- `/users/999`：查询id=999的用户的数据
- `/users/999/delete`：删除id=999的用户的数据

RESTful建议希望实现的数据操作不同而使用不同的请求方式：

- 查询：`GET`
- 新增：`POST`
- 修改：`PUT`
- 删除：`DELETE`

通常在开发实践中，仅仅使用`GET`、`POST`两种更为常见。大部分开发者更习惯于使用`GET`、`POST`这两种请求方式。<br />通常，以查询为主要目标的请求使用`GET`请求方式，否则，使用`POST`请求方式。<br />在`SpringMVC`中使用这种方法：<br />![image.png](https://cdn.nlark.com/yuque/0/2023/png/35204765/1678717298991-41bd295e-7d3c-4911-b2ca-ad4463c5381b.png#averageHue=%23f1f1e4&clientId=u323459f9-cff6-4&from=paste&height=176&id=u7f95776e&name=image.png&originHeight=176&originWidth=561&originalType=binary&ratio=1&rotation=0&showTitle=false&size=85108&status=done&style=none&taskId=u97b17b9b-b19e-4ea7-9ed1-e9237f57ed5&title=&width=561)<br />占位符还可以加正则表达式：`{id: [0-9]+}`或`{name: [a-zA-Z]+}`
