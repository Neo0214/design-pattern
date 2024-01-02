package org.group11.Patterns.DAO;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.CreateUser;


public interface UserDAO {
    public void createUser(SqlSession sqlSession, CreateUser user);
}
