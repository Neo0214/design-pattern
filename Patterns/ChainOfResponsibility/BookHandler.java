package org.group11.Patterns.ChainOfResponsibility;

import java.util.regex.Pattern;

import org.group11.Patterns.DAO.Impl.BorrowImpl;
import org.group11.Patterns.DAO.Impl.UserImpl;

public class BookHandler extends LoginHandler{
    @Override
    public boolean handleRequest(int username, String password) {
        String bookname = new BorrowImpl().latestBorrow(username);
        if(bookname==password){
            System.out.println("用户验证通过");
            return true;
        }
        
        // 如果当前处理器无法处理请求，则将请求传递给下一个处理器
        if (nextHandler != null) {
            return nextHandler.handleRequest(username, password);
        }
        
        System.out.println("无法验证登录！");
        return false;
    }
}
