package org.group11.Patterns.serviceLocator;

import static org.group11.Tools.Input.getInput;

import org.group11.Patterns.Singleton.Admin;
import org.group11.Patterns.Employee.Login;
import org.group11.Patterns.Employee.AdminLogin;

/*
 * @author Neo0214
 */
public class AdminLoginService implements Service{
    @Override
    public String getName() {
        return "AdminLoginService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing AdminLoginService");

        System.out.println("请输入密码：");
        String password = getInput();

        Admin admin = Admin.getInstance(password);
        Login login = new Login();
        login.clean(new AdminLogin(),"",admin.user_key);

    }
}
