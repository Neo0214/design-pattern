# design-pattern

## 初次运行


##### 2 在resources下新建文件mybatis-config.xml，并输入以下内容

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://82.156.161.216:3306/db-design-patterns?characterEncoding=utf-8&amp;useSSL=false&amp;serverTimezone=GMT%2B8&amp;allowPublicKeyRetrieval=true"/>
                <property name="username" value="?"/>
                <property name="password" value="?"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="BookMapper.xml"/>
    </mappers>
</configuration>
```

- 需要注意的是,property最后两个的value更换为用户名和密码（请注意保密）

##### 3 运行

运行main以后，看到以下结果说明正确：

```
UI start
trying to connect server
[Book{id=1, title=c++ primer plus}]
```

##### 4 DAO模式
已经实现了DAO模式，详情请查看package patterns.DAO

##### 5 工厂模式
patterns.FactoryJDBC.java实现了简单工厂模式
