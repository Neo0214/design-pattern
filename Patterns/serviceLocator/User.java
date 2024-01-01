package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
// 定义用户类
public class User {
    private Integer ID;
    public String USER_NAME;
    public String USER_KEY;

    public User(String USER_NAME, String USER_KEY) {
        this.USER_NAME = USER_NAME;
        this.USER_KEY = USER_KEY;
    }

    // 省略 getter 和 setter 方法
}
