package org.group11.Patterns.abstractFactory;

import org.group11.Patterns.abstractFactory.AbstractFactory;
import org.group11.Patterns.DAO.GiveBookMapper;
import org.group11.Patterns.DAO.AdminPasswordMapper;
import org.group11.Patterns.DAO.UserMapper;
import org.group11.Patterns.DAO.UserPasswordMapper;
import org.group11.Patterns.DAO.Impl.GiveBookImpl;
import org.group11.Patterns.DAO.Impl.AdminPasswordImpl;
import org.group11.Patterns.DAO.Impl.UserImpl;
import org.group11.Patterns.DAO.Impl.UserPasswordImpl;

public class ConcreteFactory extends AbstractFactory {
    // 创建UserMapper对象
    public UserMapper createUserMapper() {
        return new UserImpl();
    }

    // 创建AdminPasswordMapper对象
    public AdminPasswordMapper createAdminPasswordMapper() { return new AdminPasswordImpl();  }

    // 创建UserPasswordMapper对象
    public UserPasswordMapper createUserPasswordMapper() {
        return new UserPasswordImpl();
    }

    // 创建GiveBookMapper对象
    public GiveBookMapper createGiveBookMapper() {
        return new GiveBookImpl();
    }
}
