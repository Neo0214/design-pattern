package org.group11.Patterns.State;

import org.group11.Entity.Book;

public class BorrowedBookState implements BookState{        //被借出
    public void doAction(Book book){
        book.setState(this);
        System.out.println("本书已被借出！！！");
    }
    public void printState(){
        System.out.println("本书已被借出！！！");
    }
}
