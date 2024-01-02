package org.group11.Patterns.State;

import org.group11.Entity.Borrow;

public class NormalState implements BorrowState {
    @Override
    public void sendReminder(Borrow borrow) {
        // 在正常状态下的提醒逻辑
        // 例如，您可以选择不发送提醒或发送一般性提醒
        System.out.println("Reminder: Your borrowed book is currently in a normal state.");
        System.out.println(borrow);
    }
}
