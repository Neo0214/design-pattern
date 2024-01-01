package org.group11.Patterns.DAO.Impl;
import org.group11.Entity.Borrow;
import org.group11.Patterns.DAO.ReminderMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

public class ReminderMapperImpl implements ReminderMapper {
    @Override 
    public List<Borrow> selectUnreturnedBooks(int userId) {
        Map<String,String> params = ParamFactory.getParam("userId",String.valueOf(userId));
        SqlSession sqlSession = JDBCFactory.Instance();
        List<Borrow> unreturnBooks = sqlSession.selectList("UnreturnBooksMapper.selectUnreturnedBooks", params);
        sqlSession.commit();
        sqlSession.close();
        return unreturnBooks;
    }
}