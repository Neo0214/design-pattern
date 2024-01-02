package org.group11.Patterns.Template;

import org.group11.Entity.Book;

public abstract class BookDonationTemplate {
    public final void donateBook(int id) {
        Book book=createBook();
        createDonationRecord(id,book.getBookId());
        updateBookBelongings(book.getBookId());
    }

    protected abstract Book createBook();
    protected abstract void createDonationRecord(int id, int BookId);
    protected abstract void updateBookBelongings(int BookId);
}


