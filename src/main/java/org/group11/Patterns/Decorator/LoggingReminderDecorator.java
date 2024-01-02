package org.group11.Patterns.Decorator;

import org.group11.Patterns.Singleton.Reminder;
import java.util.List;
import org.group11.Entity.Borrow;

public class LoggingReminderDecorator implements Reminder {
    private Reminder decoratedReminder;

    public LoggingReminderDecorator(Reminder decoratedReminder) {
        this.decoratedReminder = decoratedReminder;
    }

    @Override
    public List<Borrow> remind(int userId) {
        System.out.println("Log: Fetching unreturned books for user ID: " + userId);
        List<Borrow> books = decoratedReminder.remind(userId);
        System.out.println("Log: Retrieved " + books.size() + " unreturned books for user ID: " + userId);
        return books;
    }
}
