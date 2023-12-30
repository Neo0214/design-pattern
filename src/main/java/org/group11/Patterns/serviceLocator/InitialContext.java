/*
 * @author Neo0214
 */
package org.group11.Patterns.serviceLocator;

public class InitialContext {
    public Object lookup(String name)
    {
        if (name.equalsIgnoreCase("ReturnBookService")) {
            return new ReturnBookService();
        }
        //在这里命名你的服务对象类，
        // 即MainInterface中的serviceLocator.getService("xxxx")xxxx的值
        else if (name.equalsIgnoreCase("UserPasswordMapperService")) {
            //先在org.group11.patterns.serviceLocator包下
            // 创建一个你的服务对象类文件，
            // 以上文为例即org.group11.Patterns.serviceLocator.ReturnBookService.java
            // 内容模板参照example.java
            // 然后在这里返回你的服务对象类，
            //return new UserPasswordMapperService();
        }
        return null;
    }
}
