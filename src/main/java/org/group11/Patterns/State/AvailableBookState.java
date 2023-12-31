package org.group11.Patterns.State;

import org.group11.Entity.Book;
import org.group11.Patterns.DAO.Impl.BorrowImpl;
public class AvailableBookState implements BookState{       //可外借

    public void doAction(Book book){
        book.setState(this);
        System.out.println("本书可以借出！！！");
    }
    public boolean changeToBorrowed(int bookId,int userId,String curTime){

        return new BorrowImpl().borrowBook(bookId, userId, curTime);
    }
    public void printState(){
        System.out.println("本书可以借出！！！");
    }
}
