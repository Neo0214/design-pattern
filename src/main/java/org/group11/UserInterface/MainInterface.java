package org.group11.UserInterface;

import org.apache.ibatis.session.SqlSession;
import org.group11.patterns.DAO.Impl.BookDAOImpl;
import org.group11.patterns.FactoryJDBC;

public class MainInterface {
    public void run(){
        System.out.println("UI start");
        SqlSession sqlSession = FactoryJDBC.Instance();
        assert sqlSession != null;
        System.out.println(new BookDAOImpl().getAllBook(sqlSession));
    }
}
