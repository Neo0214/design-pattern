package org.group11.Patterns.Employee;

import org.group11.Patterns.DAO.Impl.AdminPasswordImpl;

public class AdminLogin implements IClean {
    public void cleaned(String name,String password) {
        boolean isright = new AdminPasswordImpl().checkPassword(password);
        if(isright == true){
            System.out.println("管理员登录成功！");
        }
        else{
            System.out.println("管理员登录失败！");
        }
    }
}
