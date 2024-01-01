package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.Comment;
import org.group11.Patterns.DAO.CommentMapper;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CommentMapperImpl implements CommentMapper {
    @Override
    public boolean saveBookComment(int BOOK_ID, LocalDateTime COMMENT_TIME, String COMMENT_CONTENT, int SCORE) {
        // 创建参数
        Map<String,String> params= ParamFactory.getParam("id",String.valueOf(BOOK_ID),"COMMENT_TIME",String.valueOf(COMMENT_TIME),"COMMENT_CONTENT",COMMENT_CONTENT,"SCORE",String.valueOf(SCORE));
        SqlSession sqlSession= JDBCFactory.Instance();
        int isRight=sqlSession.update("CommentMapper.saveComment",params);
        sqlSession.commit();
        sqlSession.close();
        if (isRight==1){
            System.out.println("插入成功");
            return true;
        }
        System.out.println("插入失败");
        return false;
    }

    @Override
    public List<Comment> getBookComments(int BOOK_ID) {
        // 创建参数
        Map<String,String> params= ParamFactory.getParam("id",String.valueOf(BOOK_ID));


        SqlSession sqlSession= JDBCFactory.Instance();
        List<Comment> Comment=sqlSession.selectList("CommentMapper.checkComment",params);
        sqlSession.close();
        return Comment;
    }
}
