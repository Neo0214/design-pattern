package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.DAO.BorrowMapper;
import org.group11.simpleFactory.JDBCFactory;
import org.group11.simpleFactory.ParamFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

public class BorrowMapperImpl implements BorrowMapper {
    @Override
    public boolean returnBook(int bookId, int userId, String curTime){
        Map<String,String> params = ParamFactory.getParam("returnDate",curTime,"bookId",String.valueOf(bookId),"userId",String.valueOf(userId));
        SqlSession sqlSession = JDBCFactory.Instance();
        int isReturn= sqlSession.update("BorrowRecordMapper.returnBook",params);
        sqlSession.commit();
        sqlSession.close();
        if(isReturn!=0){
            return true;
        }
        return false;
    }
}
