/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO;

public interface BorrowMapper {
    public boolean returnBook(int bookId,int userId,String curTime);
}
