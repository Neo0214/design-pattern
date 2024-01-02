/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.User;
import org.group11.Patterns.DAO.UserMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

import java.util.List;
import java.util.Map;

public class UserImpl implements UserMapper {
    @Override
    public boolean checkPassword(int userID,String password) {
        // 创建参数
        Map<String,String> params= ParamFactory.getParam("id",String.valueOf(userID),"user_key",password);


        SqlSession sqlSession= JDBCFactory.Instance();
        int isRight=sqlSession.selectOne("UserMapper.checkPassword",params);
        sqlSession.close();
        if (isRight==1){

            return true;
        }
        return false;
    }

    @Override
    public List<User> getUserByName(String name) {
        Map<String,String> params= ParamFactory.getParam("name",name);
        SqlSession sqlSession= JDBCFactory.Instance();
        List<User> users=sqlSession.selectList("UserMapper.getUserByName",params);
        sqlSession.close();
        return users;
    }
}
