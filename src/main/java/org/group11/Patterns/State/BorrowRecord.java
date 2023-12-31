package org.group11.Patterns.State;
import org.group11.Patterns.Singleton.Reminder;

public class BorrowRecord {
    private BorrowState state;
    private int userId;

    public BorrowRecord(int userId) {
        this.userId = userId;
        this.state = new ApproachingReturnDateState(); // 默认为未还状态
    }

    public void setState(BorrowState state) {
        this.state = state;
    }

    public void sendReminder(Reminder decoratedReminder) {
        state.sendReminder(userId, decoratedReminder);
    }
}
