package org.group11.Patterns.DAO;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.serviceLocator.User;


public interface UserDAO {
    public void createUser(SqlSession sqlSession, User user);
}
