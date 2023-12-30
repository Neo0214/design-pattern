/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO;

public interface UserPasswordMapper {
    public boolean checkPassword(int userId,String password);
    //在这里定义接口，其他设计模式不一定采取接口与实现分离的方式，请选取合适的实现方法
    //此处转到UserPasswordImpl.java看具体数据库操作方式
}
