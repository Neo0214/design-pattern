package org.group11.Patterns.serviceLocator;

import java.util.ArrayList;
import java.util.List;
import org.group11.Patterns.Observer.Observer;
import org.group11.Patterns.Observer.ReminderObserver;

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
        System.out.println("Executing UserLoginService");

        // 这里编写用户登录验证的逻辑
        // 假设验证成功，并且我们能够从args数组中获取到用户ID
        if (args.length > 0) {
            try {
                int userId = Integer.parseInt(args[0]); // 将字符串参数转换为整型用户ID
                // 假设登录验证成功，我们通知所有观察者用户已登录
                notifyObservers(userId);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid user ID format.");
            }
        }
    }
}
