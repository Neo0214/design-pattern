package org.group11.Patterns.Observer;

import java.util.List;
import org.group11.Entity.Borrow;
import org.group11.Patterns.Singleton.ReminderSingleton;

public class User implements Observer {
    private String name;
    private int userId; // 用户的ID

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId; // 存储用户ID
    }

    @Override
    public void update(int userId) {
        checkAndRemindUnreturnedBooks();
    }

    private void checkAndRemindUnreturnedBooks() {
        // 通过 ReminderService 获取未归还书籍列表
        List<Borrow> unreturnedBooks = ReminderSingleton.getInstance().remind(this.userId);

        // 提醒用户未归还的书籍
        if (unreturnedBooks != null && !unreturnedBooks.isEmpty()) {
            System.out.println("Reminder for " + name + ": You have books to return.");
            for (Borrow book : unreturnedBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books to return.");
        }
    }
}

