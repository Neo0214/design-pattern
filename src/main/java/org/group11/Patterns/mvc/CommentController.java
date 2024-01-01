package org.group11.Patterns.mvc;

import org.group11.Entity.Comment;
import org.group11.Patterns.DAO.Impl.CommentMapperImpl;

import java.util.List;

public class CommentController {
    private Comment comment;
    private CommentView commentView;

    public CommentController(Comment comment, CommentView commentView) {
        this.comment = comment;
        this.commentView = commentView;
    }

    public void saveComment(int bookId) {
        Comment comment = commentView.getCommentFromUser(bookId);
        new CommentMapperImpl().saveBookComment(comment.getBOOK_ID(),comment.getCOMMENT_TIME(),comment.getCOMMENT_CONTENT(),comment.getSCORE());
    }

    public void getInfo(int bookId) {
        List<Comment> comment = new CommentMapperImpl().getBookComments(bookId);
        commentView.displayComments(comment);
    }
}
