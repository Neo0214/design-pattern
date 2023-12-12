package org.group11.patterns.DAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.group11.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookDAO {
    void addBook();
    void deleteBook();
    void updateBook();
    List<Book> getAllBook(SqlSession sqlSession);
}
