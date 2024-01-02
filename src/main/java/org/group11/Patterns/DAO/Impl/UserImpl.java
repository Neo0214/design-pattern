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
        // 在这里建立sql参数，传入模板如下：
        // Map<String,String> params= ParamFactory.getParam("xml文件语句变量名1",数值1,"xml文件语句变量名2",数值2);
        //上面的数值1/2必须要转为string
        Map<String,String> params= ParamFactory.getParam("id",String.valueOf(userID),"user_key",password);
        //下面这句话建立查询实例
        SqlSession sqlSession= JDBCFactory.Instance();
        //下面这句话执行查询，返回结果，UserMapper是xml文件的namespace，checkPassword是查询语句的id
        //到UserMapper.xml看具体查询语句
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
