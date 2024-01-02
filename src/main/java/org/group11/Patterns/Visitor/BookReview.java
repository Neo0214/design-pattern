package org.group11.Patterns.Visitor;

import org.group11.Patterns.Visitor.BookReviewVisitor;

public class BookReview {
    private String content;
    private int score;

    public BookReview(String content, int score) {
        this.content = content;
        this.score = score;
    }


    // 构造函数和其他方法

    public String getContent() {
        return content;
    }

    public int getScore() {
        return score;
    }

    public void accept(BookReviewVisitor visitor) {
        visitor.visit(this);
    }
}
