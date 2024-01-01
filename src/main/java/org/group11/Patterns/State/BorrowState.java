package org.group11.Patterns.State;

import org.group11.Patterns.Singleton.Reminder;

public interface BorrowState {
    void sendReminder(int userId, Reminder decoratedReminder);
}
