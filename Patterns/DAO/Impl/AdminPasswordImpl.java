/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.DAO.AdminPasswordMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

import java.util.Map;

public class AdminPasswordImpl implements AdminPasswordMapper {
    @Override
    public boolean checkPassword(String password) {
        Map<String,String> params= ParamFactory.getParam("admin_key",password);
        SqlSession sqlSession= JDBCFactory.Instance();
        int isRight=sqlSession.selectOne("AdminMapper.checkPassword",params);
        sqlSession.close();
        if (isRight!=0){
            return true;
        }
        return false;
    }
}
