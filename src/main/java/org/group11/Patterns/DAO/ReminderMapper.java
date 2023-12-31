package org.group11.Patterns.DAO;


import java.util.List;
import org.group11.Entity.Borrow;

public interface ReminderMapper {
    List<Borrow> selectUnreturnedBooks(int userId);
}

