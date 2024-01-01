package org.group11.Patterns.DAO;

import org.group11.Entity.Comment;
import java.time.LocalDateTime;
import java.util.List;

public interface CommentMapper {
    public boolean saveBookComment(int BOOK_ID, LocalDateTime COMMENT_TIME, String COMMENT_CONTENT, int SCORE);
    List<Comment> getBookComments(int BOOK_ID);
}
