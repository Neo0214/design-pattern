/*
 * @author Neo0214
 */
package org.group11.Patterns.Proxy;

import org.group11.Patterns.DAO.Impl.BorrowImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VReturnBook implements ReturnBook{
    @Override
    public boolean returnBook(int bookId, int userId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String returnTime = localDateTime.format(dateTimeFormatter);
        return new BorrowImpl().returnBook(bookId, userId, returnTime);
    }
}
