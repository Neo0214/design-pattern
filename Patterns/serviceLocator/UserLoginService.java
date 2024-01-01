package org.group11.Patterns.serviceLocator;

import java.util.ArrayList;
import java.util.List;
import org.group11.Patterns.Observer.Observer;
import org.group11.Patterns.Observer.ReminderObserver;
import org.group11.Patterns.Prototype.UserProto;
import org.group11.Patterns.ChainOfResponsibility.LoginHandler;
import org.group11.Patterns.ChainOfResponsibility.PasswordHandler;
import org.group11.Patterns.ChainOfResponsibility.BookHandler;
import org.group11.Patterns.ChainOfResponsibility.UserLogin;
import org.group11.Patterns.Employee.Login;

import static org.group11.Tools.Input.getInput;

/*
 * @author Neo0214
 */
public class UserLoginService implements Service{

    private List<Observer> observers = new ArrayList<>();

    public UserLoginService() {
        ReminderObserver reminderObserver = new ReminderObserver();
        addObserver(reminderObserver);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(int userId) {
        for (Observer observer : observers) {
            observer.update(userId);
        }
    }


    @Override
    public String getName() {
        return "UserLoginService";
    }

    @Override
    public void execute(String... args) {

        LoginHandler PasswordHandler = new PasswordHandler();
        LoginHandler BookHandler = new BookHandler();
        PasswordHandler.setNextHandler(BookHandler);

        System.out.println("Executing UserLoginService");

        System.out.println("请输入ID：");
        String name = getInput();
        int id = Integer.parseInt(name);
        System.out.println("请输入密码或最近一次读过的书名：");
        String password = getInput();
        UserProto userprototype = new UserProto(0, "", "");
        UserProto clone = (UserProto) userprototype.clone();
        clone.set(id,"",password);
        clone.setAuthenticationHandler(PasswordHandler);
        boolean flag=false;
        while(!flag){
            flag = clone.login(id, password);
        }
        // 假设验证成功，并且我们能够从args数组中获取到用户ID
        if (flag==true) {
            try {
                int userId = id; // 将字符串参数转换为整型用户ID
                // 假设登录验证成功，我们通知所有观察者用户已登录
                notifyObservers(userId);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid user ID format.");
            }
        }
    }
}
