/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.User;
import org.group11.Patterns.DAO.BorrowMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

import java.util.List;
import java.util.Map;

public class BorrowImpl implements BorrowMapper {
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

    @Override
    public List<User> queryBorrowUsers(){
        SqlSession sqlSession = JDBCFactory.Instance();
        List<User> users =sqlSession.selectList("BorrowRecordMapper.allBorrowUser");
        sqlSession.close();
        return users;
    }


    @Override
    public boolean borrowBook(int bookId, int userId, String curTime){
        Map<String,String> params = ParamFactory.getParam("borrowDate",curTime,"bookId",String.valueOf(bookId),"userId",String.valueOf(userId));
        SqlSession sqlSession = JDBCFactory.Instance();
        int isBorrow = sqlSession.insert("BorrowRecordMapper.borrowBook",params);
        sqlSession.commit();
        sqlSession.close();
        if(isBorrow!=0){
            return true;
        }
        return false;
    }
    @Override
    public boolean isBorrowed(int bookId){
        Map<String,String> params= ParamFactory.getParam("bookId",String.valueOf(bookId));
        SqlSession sqlSession= JDBCFactory.Instance();
        int isBorrowed=sqlSession.selectOne("BorrowRecordMapper.isBorrowed",params);
        sqlSession.close();
        if (isBorrowed!=0){
            return true;
        }
        return false;
    }
    @Override
    public boolean hasUnreturned(int userId){
        Map<String,String> params= ParamFactory.getParam("userId",String.valueOf(userId));
        SqlSession sqlSession= JDBCFactory.Instance();
        int has=sqlSession.selectOne("BorrowRecordMapper.hasUnreturned",params);
        sqlSession.close();
        if (has!=0){
            return true;
        }
        return false;
    }
}
