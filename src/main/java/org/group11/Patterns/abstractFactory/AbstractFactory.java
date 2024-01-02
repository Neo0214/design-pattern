package org.group11.Patterns.abstractFactory;

import org.group11.Patterns.DAO.GiveBookMapper;
import org.group11.Patterns.DAO.AdminPasswordMapper;
import org.group11.Patterns.DAO.UserMapper;
import org.group11.Patterns.DAO.UserPasswordMapper;
public abstract class AbstractFactory {
    // 创建UserMapper对象
    public abstract UserMapper createUserMapper();

    // 创建AdminPasswordMapper对象
    public abstract AdminPasswordMapper createAdminPasswordMapper();

    // 创建UserPasswordMapper对象
    public abstract UserPasswordMapper createUserPasswordMapper();

    // 创建GiveBookMapper对象
    public abstract GiveBookMapper createGiveBookMapper();
}