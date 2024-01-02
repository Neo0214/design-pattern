package org.group11.Patterns.Visitor;

public interface BookReviewVisitor {
    void visit(BookReview bookReview);

    void visit(org.group11.Patterns.Iterator.BookReview bookReview);
}
