package org.group11.Patterns.State;

import org.group11.Entity.Book;
public interface BookState {

    public void doAction(Book book);
    public void printState();
}
