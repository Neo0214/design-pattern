# design-pattern

## 初次运行

##### 1 建库

在mysql中建立名为db-design-pattern的数据库，并输入以下语句简单建表

```sql
create table book (

id integer primary key AUTO_INCREASE,

title varchar(256)

);
insert into book(title)
values("c++ primer plus");
```





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
                <property name="url" value="jdbc:mysql://localhost:3306/db-design-pattern?characterEncoding=utf-8&amp;useSSL=false&amp;serverTimezone=GMT%2B8"/>
                <property name="username" value="root"/>
                <property name="password" value="pwd"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="BookMapper.xml"/>
    </mappers>
</configuration>
```

- 需要注意的是，第二个property的3306/ 后的内容请输入你自己的数据库名，property最后两个的value输入你自己的用户名和密码

##### 3 运行

运行main以后，看到类似一下结果说明正确：

```
UI start
[Book{id=1, title=c++ primer plus}]
```

