package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.Comment;
import org.group11.Patterns.DAO.CommentMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CommentMapperImp implements CommentMapper {
    @Override
    public boolean saveBookComment(int BOOK_ID, LocalDateTime COMMENT_TIME, String COMMENT_CONTENT, int SCORE) {
        // 创建参数
        Map<String,String> params= ParamFactory.getParam("id",String.valueOf(BOOK_ID),"COMMENT_TIME",String.valueOf(COMMENT_TIME),"COMMENT_CONTENT",COMMENT_CONTENT,"SCORE",String.valueOf(SCORE));
        SqlSession sqlSession= JDBCFactory.Instance();
        int isRight=sqlSession.selectOne("CommentMapper.saveComment",params);
        sqlSession.close();
        if (isRight==1){

            return true;
        }
        return false;
    }

    @Override
    public List<Comment> getBookComments(int BOOK_ID) {
        // 创建参数
        Map<String,String> params= ParamFactory.getParam("id",String.valueOf(BOOK_ID));


        SqlSession sqlSession= JDBCFactory.Instance();
        List<Comment> Comment=sqlSession.selectOne("CommentMapper.checkComment",params);
        sqlSession.close();
        return Comment;
    }
}
