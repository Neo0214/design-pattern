package org.group11.Patterns.Observer;

import org.group11.Entity.Borrow;
import org.group11.Patterns.Singleton.ReminderService;
import java.util.List;

public class ReminderObserver implements Observer {
    @Override
    public void update(int userId) {
        ReminderService reminderService = ReminderService.getInstance();
        List<Borrow> unreturnedBooks = reminderService.remind(userId);
        // 实现提醒逻辑，比如打印未归还的书籍
        if (!unreturnedBooks.isEmpty()) {
            System.out.println("您有以下未归还的书籍：");
            for (Borrow book : unreturnedBooks) {
                System.out.println(book);
            }
        }
    }
}
