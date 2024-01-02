package org.group11.Patterns.State;

import org.group11.Entity.Borrow;

public class ApproachingReturnDateState implements BorrowState {
    @Override
    public void sendReminder(Borrow borrow) {
        // 未还状态下的提醒逻辑
        //LoggingReminderDecorator logger = new LoggingReminderDecorator(decoratedReminder);
        System.out.println("Reminder: Your borrowed books are approaching return date!");
        System.out.println(borrow);
    }
}