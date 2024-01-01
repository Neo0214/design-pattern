package org.group11.Patterns.Visitor;

import org.group11.Patterns.Iterator.BookReview;

public class ConcreteBookReviewVisitor implements BookReviewVisitor {
    @Override
    public void visit(org.group11.Patterns.Visitor.BookReview bookReview) {

    }

    @Override
    public void visit(BookReview bookReview) {
        // 实现对BookReview的具体访问逻辑
        System.out.println("访问者输出 - 评价时间: " + bookReview.getReviewTime() +
                ", 评价内容: " + bookReview.getContent() +
                ", 评分: " + bookReview.getScore());
    }
}
