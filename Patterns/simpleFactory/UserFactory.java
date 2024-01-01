package org.group11.Patterns.simpleFactory;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.DAO.Impl.UserDAOImpl;
import org.group11.Patterns.serviceLocator.User;


public class UserFactory {
    public  User createUser(SqlSession sqlSession, String userName, String password) {

        User user= new User(userName, password);
        UserDAOImpl userDAOImpl=new UserDAOImpl();
        userDAOImpl.createUser(sqlSession,user);
        return user;
    }
}
