package org.group11.Patterns.Proxy;
import org.group11.Patterns.State.BookState;
import org.group11.Patterns.State.AvailableBookState;
import org.group11.Patterns.State.BorrowedBookState;
import org.group11.Patterns.DAO.Impl.BorrowImpl;
import org.group11.Entity.Book;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class RealBorrowBook implements BorrowBook{
    @Override
    public boolean borrowBook(int bookId,int userId){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String borrowTime = localDateTime.format(dateTimeFormatter);
        Book book = new Book();
        if(!book.isBorrowed(bookId)){       //未被借出
            AvailableBookState astate = new AvailableBookState();
            astate.doAction(book);

            if(book.borrow(bookId, userId, borrowTime)){
                BorrowedBookState bstate = new BorrowedBookState();
                bstate.doAction(book);
            }
        }
        return false;
    }
}

