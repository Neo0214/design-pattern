package org.group11.Patterns.simpleFactory;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.CreateUser;
import org.group11.Patterns.DAO.Impl.UserDAOImpl;


public class UserFactory {
    public CreateUser createUser(SqlSession sqlSession, String userName, String password) {

        CreateUser user= new CreateUser(userName, password);
        UserDAOImpl userDAOImpl=new UserDAOImpl();
        userDAOImpl.createUser(sqlSession,user);
        return user;
    }
}
