package org.group11.Entity;
import org.group11.Patterns.State.BookState;
import org.group11.Patterns.State.AvailableBookState;
import org.group11.Patterns.State.BorrowedBookState;
import org.group11.Patterns.DAO.Impl.BorrowImpl;
public class Book {
    private BookState state;
    public Book(){
        state = null;
    }

    public void setState(BookState state){
        this.state = state;
    }

    public BookState getState(){
        return state;
    }

    public boolean isBorrowed(int id){
        return new BorrowImpl().isBorrowed(id);
    }
    public boolean borrow(int bookId, int userId, String borrowTime){
        return new BorrowImpl().borrowBook(bookId, userId, borrowTime);
    }
}
