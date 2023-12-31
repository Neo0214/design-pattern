package org.group11.Patterns.State;

import org.group11.Patterns.Singleton.*;
import org.group11.Patterns.Decorator.*;

public class OverdueState implements BorrowState {
    @Override
    public void sendReminder(int userId, Reminder decoratedReminder) {
        // 逾期状态下的提醒逻辑
        LoggingReminderDecorator logger = new LoggingReminderDecorator(decoratedReminder);
        logger.remind(userId);
        System.out.println("Warning: Your borrowed books are overdue!");
    }
}