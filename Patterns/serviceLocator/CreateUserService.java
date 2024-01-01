package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.transforObject.UserTO;
import org.group11.Patterns.DAO.Impl.UserImpl;
import static org.group11.Tools.Input.getInput;

import java.util.List;

public class CreateUserService implements Service{
    @Override
    public String getName() {
        return "CreateUserService";
    }
    @Override
    public void execute(String... args) {
        boolean flag = true;
        while(flag){
            System.out.println("请输入姓名：");
            String name = getInput();
            System.out.println("请输入密码：");
            String password = getInput();
            int id = new UserImpl().getMaxId();
            id = id + 1;
            // System.out.println(id);
            List<UserTO> users = new UserImpl().getUser(name, password);
            int length = users.size();
            boolean isright = false;
            if(length==0){
                isright = new UserImpl().insertUser(id, name, password);
                if(isright == true){
                    flag = false;
                    System.out.println("创建用户成功，用户信息如下：");
                    List<UserTO> users2 = new UserImpl().getUser(name, password);
                    for (UserTO user:users2){
                        System.out.println(user);
                    }
                }
                else{
                    System.out.println("创建用户失败，请重新尝试！");
                }
            }
            else{
                System.out.println("该用户已存在，请重新创建并输入新密码！");
            }
        }
    }
}
