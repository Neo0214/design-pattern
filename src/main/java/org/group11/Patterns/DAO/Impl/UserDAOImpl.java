package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.DAO.UserDAO;
import org.group11.Patterns.serviceLocator.User;


public class UserDAOImpl implements UserDAO {
    public void createUser(SqlSession sqlSession, User user) {
        if (sqlSession != null) {
            sqlSession.insert("UserMapper.insertUser", user);
        } else {
            throw new IllegalArgumentException("SqlSession cannot be null");
        }
    }
}
