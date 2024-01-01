/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.DAO.UserPasswordMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

import java.util.Map;

public class UserPasswordImpl implements UserPasswordMapper {
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
}
