package org.group11.Patterns.Template;

import org.group11.Entity.BookInfo;

public abstract class BookDonationTemplate {
    public final void donateBook(int id) {
        BookInfo book=createBook();
        createDonationRecord(id,book.getBookId());
        updateBookBelongings(book.getBookId());
    }

    protected abstract BookInfo createBook();
    protected abstract void createDonationRecord(int id, int BookId);
    protected abstract void updateBookBelongings(int BookId);
}


