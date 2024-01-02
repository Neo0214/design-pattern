package org.group11.Patterns.abstractFactory;

import org.group11.Patterns.DAO.GiveBookMapper;
import org.group11.Patterns.DAO.AdminPasswordMapper;
import org.group11.Patterns.DAO.UserMapper;
public abstract class AbstractFactory {

    // 创建AdminPasswordMapper对象
    public abstract AdminPasswordMapper createAdminPasswordMapper();

    // 创建GiveBookMapper对象
    public abstract GiveBookMapper createGiveBookMapper();
}