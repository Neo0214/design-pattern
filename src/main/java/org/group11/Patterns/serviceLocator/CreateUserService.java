package org.group11.Patterns.serviceLocator;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.UserFactory;
import org.group11.Tools.Input;

/*
 * @author Neo0214
 */
public class CreateUserService implements Service{
    @Override
    public String getName() {
        return "CreateUserService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing CreateUserService");
        SqlSession sqlSession = JDBCFactory.Instance();
        String username;
        String password;
        System.out.println("请输入用户名");
        username=Input.getInput();
        System.out.println("请输入密码");
        password= Input.getInput();
        assert sqlSession != null;
        User user=new UserFactory().createUser(sqlSession,username,password);
        sqlSession.commit();
        System.out.println("创建成功");
    }
}
