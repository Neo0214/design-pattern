package org.group11.UserInterface;

import org.apache.ibatis.session.SqlSession;
import org.group11.entity.Book;
import org.group11.patterns.DAO.Impl.BookDAOImpl;
import org.group11.patterns.FactoryJDBC;

import java.util.List;

public class MainInterface {
    public void run(){
        System.out.println("UI start");
        System.out.println("trying to connect server");
        SqlSession sqlSession = FactoryJDBC.Instance();
        assert sqlSession != null;
        List<Book> books=new BookDAOImpl().getAllBook(sqlSession);
        System.out.println(books);
        sqlSession.close();
    }
}
