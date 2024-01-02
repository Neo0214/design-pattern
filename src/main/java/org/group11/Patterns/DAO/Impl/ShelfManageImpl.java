package org.group11.Patterns.DAO.Impl;
import org.group11.Patterns.DAO.ShelfManageMapper;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.group11.Patterns.simpleFactory.JDBCFactory;
import org.group11.Patterns.simpleFactory.ParamFactory;

public class ShelfManageImpl implements ShelfManageMapper {
    @Override
    public boolean ShelfBelong(String bookId, String shelfId) {
        SqlSession sqlSession = JDBCFactory.Instance();

        try {
            // 检查书籍是否已存在
            String existingShelfId = sqlSession.selectOne("ShelfManageMapper.getShelfIdByBookId", bookId);

            if (existingShelfId != null) {
                // 如果书籍已存在，更新书架ID
                Map<String,String> params = ParamFactory.getParam("BOOK_ID",bookId,"SHELF_ID",shelfId);
                params.put("BOOK_ID", bookId);
                params.put("SHELF_ID", shelfId);
                sqlSession.update("ShelfManageMapper.updateShelfId", params);
            } else {
                // 如果书籍不存在，插入新行
                Map<String,String> params = ParamFactory.getParam("BOOK_ID",bookId,"SHELF_ID",shelfId);
                params.put("BOOK_ID", bookId);
                params.put("SHELF_ID", shelfId);
                sqlSession.insert("ShelfManageMapper.insertBookShelf", params);
            }

            sqlSession.commit();
            return true;
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}

