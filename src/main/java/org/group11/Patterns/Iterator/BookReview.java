package org.group11.Patterns.Iterator;

import org.group11.Patterns.Visitor.BookReviewVisitor;

public class BookReview {
    private String reviewTime;
    private String content;
    private int score;
    public static final BookReview EMPTY_REVIEW = new BookReview("No review", "Empty review", 0);
    public BookReview(String reviewTime, String content, int score) {
        this.reviewTime = reviewTime;
        this.content = content;
        this.score = score;
    }
    public void accept(BookReviewVisitor visitor) {
        visitor.visit(this);
    }
    // Getters
    public String getReviewTime() {
        return reviewTime;
    }

    public String getContent() {
        return content;
    }

    public int getScore() {
        return score;
    }

    // Representation of BookReview for printing
    @Override
    public String toString() {
        if (this == EMPTY_REVIEW) {
            return "没有找到评价。";
        }
        return "评价时间: " + reviewTime + ", 评价内容: " + content + ", 评分: " + score;
    }


}
