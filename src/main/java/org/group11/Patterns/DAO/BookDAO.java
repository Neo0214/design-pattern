package org.group11.Patterns.DAO;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.Book;

import java.util.List;

public interface BookDAO {
    void addBook();
    void deleteBook();
    void updateBook();
    List<Book> getAllBook(SqlSession sqlSession);
}
