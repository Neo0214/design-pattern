/*
 * @author Neo0214
 */
package org.group11.Patterns.Strategy;

import org.group11.Entity.User;

import java.util.List;

import static org.group11.Tools.Input.getInput;

public class QueryByName implements QueryAccount{
    @Override
    public void queryAccount() {
        System.out.print("请输入被查询者姓名:");
        String name = getInput();
        List<User> users = new UserImpl().getUserByName(name);
        if (users.isEmpty()) {
            System.out.println("没有这个人");
        }else {
            for (User user:users){
                System.out.println(user);
            }
        }
    }
}
