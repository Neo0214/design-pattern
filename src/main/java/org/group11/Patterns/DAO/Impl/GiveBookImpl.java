package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.DAO.GiveBookMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GiveBookImpl implements GiveBookMapper {
    @Override
    public int AddBook(String BookName, String Author, String PublishDate){
        Map<String, String> params = ParamFactory.getParam("BookName", BookName, "Author", Author,"PublishDate", PublishDate);
        SqlSession sqlSession = JDBCFactory.Instance();
        sqlSession.insert("GiveBookMapper.AddBook", params);
        sqlSession.commit();

        Object bookIdObj = params.get("bookId");
        int bookId = 0;
        if (bookIdObj instanceof BigInteger) {
            String bookIdStr = ((BigInteger) bookIdObj).toString();
            bookId = Integer.parseInt(bookIdStr);
        }
        sqlSession.close();
        return bookId;
    }

    @Override
    public boolean GiveBookRecord(int bookId, int userId){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = now.format(formatter);

        Map<String, String> params = ParamFactory.getParam("ID", String.valueOf(userId),"BOOK_ID", String.valueOf(bookId), "Donation_date", formattedDateTime);
        SqlSession sqlSession = JDBCFactory.Instance();
        sqlSession.insert("GiveBookMapper.GiveBookRecord", params);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    @Override
    public boolean PutBook(int bookId,int bookShelfId){
        Map<String,String> params = ParamFactory.getParam("bookShelfId",String.valueOf(bookShelfId),"bookId",String.valueOf(bookId));
        SqlSession sqlSession = JDBCFactory.Instance();
        int isPut= sqlSession.insert("GiveBookMapper.PutBook",params);
        sqlSession.commit();
        sqlSession.close();
        if(isPut!=0){
            return true;
        }
        return false;
    }
}
