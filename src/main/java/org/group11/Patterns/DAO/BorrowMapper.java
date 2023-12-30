/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO;

import org.group11.Entity.User;

import java.util.ArrayList;
import java.util.List;

public interface BorrowMapper {
    public boolean returnBook(int bookId,int userId,String curTime);
    public List<User> queryBorrowUsers();
}
