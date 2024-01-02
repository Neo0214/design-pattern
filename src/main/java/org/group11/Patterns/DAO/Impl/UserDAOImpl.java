package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.CreateUser;
import org.group11.Patterns.DAO.UserDAO;


public class UserDAOImpl implements UserDAO {
    public void createUser(SqlSession sqlSession, CreateUser user) {
        if (sqlSession != null) {
            sqlSession.insert("UserMapper.insertUser", user);
        } else {
            throw new IllegalArgumentException("SqlSession cannot be null");
        }
    }
}
