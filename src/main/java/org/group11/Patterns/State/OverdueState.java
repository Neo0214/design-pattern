package org.group11.Patterns.State;

import org.group11.Entity.Borrow;

public class OverdueState implements BorrowState {
    @Override
    public void sendReminder(Borrow borrow) {
        // 逾期状态下的提醒逻辑
        //LoggingReminderDecorator logger = new LoggingReminderDecorator(decoratedReminder);
        System.out.println("Warning: Your borrowed books are overdue!");
        System.out.println(borrow);
    }
}