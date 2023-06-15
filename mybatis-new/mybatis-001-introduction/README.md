开发我的第一个Mybatis程序

1. resources目录
   - 放在这个目录当中的，一般都是资源文件，配置文件。
   - 直接放扎起resources目录下的资源，等同于放到了类的根路径下。

2. 开发步骤
   - 第一步：打包方式：jar
   - 第二步：引入依赖
     - Mybatis依赖
     - MySQL驱动
   - 第三步：编写Mybatis核心配置文件：mybatis-config.xml
     - 注意：
       1. 这个文件名不是必须叫做mybatis-config.xml，可以用其他名字，只是大家都采用这个名字
       2. 这个文件存放的位置也是随意的，但是一般情况下放在类的根路径下
     - mybatis-config.xml文件中的配置信息先不用管啊，先改连接数据库的信息即可
   - 第四步：编写XxxMapper.xml文件
     - 在这个文件中编写SQL语句
     - 文件名不是固定，位置也不是固定的，我们在这里起名：CarMapper.xml
     - 这里暂时放在根路径下
   - 第五步：在mybatis-config.xml文件中指定XxxMapper.xml文件的路径，resources自动从类的根路径下查找
   - 第六步：编写MyBatis程序（使用mybatis的类库编写mybatis程序，连接数据库作增删改查）
     - 在MyBatis中，负责执行SQL语句的那个对象叫做什么？
       - SqlSession，专门用来执行SQL语句的，是一个Java程序和数据库之间的一次会话。
       - 要想获取SqlSession对象，需要先获取SqlSessionFactory对象，通过SqlSessionFactory工厂来生产SqlSession
       - 怎么获取SqlSessionFactory对象呢？需要首先获取SqlSessionFactoryBuilder对象，通过SqlSessionFactoryBuilder对象的build方法，来获取SqlSessionFactory对象
   - mybatis的核心对象包括：
     - SqlSessionFactoryBuilder
     - SqlSessionFactory
     - SqlSession

3. 从 XML 中构建 SqlSessionFactory
   - 通过官方的这句话，你能想到什么呢？
      1. 在Mybatis中一定是有一个很重要的对象， SqlSessionFactory
      2. SqlSessionFactory对象的创建需要XML
   - XML是什么？
     - 是一个配置文件

4. Mybatis中有两个主要的配置文件：
   - 其中一个是：mybatis-config.xml，这个是核心配置文件，主要用于配置数据库的连接信息等
   - 另一个是：XxxMapper.xml，这个文件是专门用来编写SQL语句的配置文件（一个表一个）

5. 关于第一个程序的小细节
   - mybatis中 SQL 语句的结尾分号可以省略
   - Resources.getResourceAsStream
     - 小技巧：以后凡是遇到resources这个单词，大部分情况下，这种加载资源的方式都是从类的根路径下开始加载
     - 优点：采用这种方式，从类路径中加载资源，项目的移植性很强，移植到其他操作系统中不用修改Java代码
   - InputStream InputStream = new FileInputStream("d:\\mybatis-config.xml");
     - 采用这种方式也可以：
     - 缺点：可移植性太差，程序不够健壮。可能会移植到其他操作系统中，导致路径无效，还需要修改代码中的路径，违背了OCP原则
   - 已经验证了：
     - mybatis核心配置文件的名字，不一定是：mybatis-config.xml
     - mybatis核心配置文件存放的路径，也不一定是在类路径下，但是为了移植性好，最好放在类路径下
   - InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
     - ClassLoader.getSystemClassLoader() 获取系统的类加载器
     - 系统类加载器有一个方法：getResourceAsStream()
     - 它就是从类路径中加载
     - 通过源代码分析，发现InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");这个底层其实就是系统类加载器那里！
   - CarMapper.xml文件的名字是固定的吗？路径是固定的吗？
     - 都不是固定的！
     - `<mapper resource="CarMapper.xml"/>` 是从类路径中加载
     - `<mapper url="file:///d:/CarMapper.xml"/>` 是从绝对路径中加载
