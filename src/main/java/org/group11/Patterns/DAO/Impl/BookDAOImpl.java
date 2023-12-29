package org.group11.Patterns.DAO.Impl;

import org.apache.ibatis.session.SqlSession;
import org.group11.Entity.Book;
import org.group11.Patterns.DAO.BookDAO;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    public void addBook() {
        System.out.println("add code here");
    }
    public void deleteBook() {
        System.out.println("add code here");
    }

    public void updateBook() {
        System.out.println("add code here");
    }

    public List<Book> getAllBook(SqlSession sqlSession) {
        List<Book> books=sqlSession.selectList("BookMapper.selectAll");
        return books;
    }
}
