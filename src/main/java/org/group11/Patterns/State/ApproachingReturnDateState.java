package org.group11.Patterns.State;

import org.group11.Patterns.Singleton.Reminder;
import org.group11.Patterns.Decorator.LoggingReminderDecorator;

public class ApproachingReturnDateState implements BorrowState {
    @Override
    public void sendReminder(int userId, Reminder decoratedReminder) {
        // 未还状态下的提醒逻辑
        LoggingReminderDecorator logger = new LoggingReminderDecorator(decoratedReminder);
        logger.remind(userId);
    }
}