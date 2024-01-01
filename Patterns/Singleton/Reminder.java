package org.group11.Patterns.Singleton;

import java.util.List;

import org.group11.Entity.Borrow;
public interface Reminder {
    public List<Borrow> remind(int userId);
}
