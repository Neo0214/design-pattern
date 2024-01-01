package org.group11.Patterns.Facade;

import org.group11.Entity.Comment;
import org.group11.Patterns.mvc.CommentController;
import org.group11.Patterns.mvc.CommentView;

public class CommentFacade {
    private Comment comment;
    private CommentView commentView;
    private CommentController commentController;

    public CommentFacade() {
        comment = new Comment();
        commentView = new CommentView();
        commentController = new CommentController(comment, commentView);
    }

    public void saveComment(int bookId) {
        commentController.saveComment(bookId);
    }

    public void getInfo(int bookId) { commentController.getInfo(bookId); }
}
