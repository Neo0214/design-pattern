package org.group11.Patterns.State;

import org.group11.Entity.Borrow;

public interface BorrowState {
    void sendReminder(Borrow borrow);
}
