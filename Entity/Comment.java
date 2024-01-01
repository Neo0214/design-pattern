package org.group11.Entity;

import java.time.LocalDateTime;

public class Comment {
    private int ID;
    private int BOOK_ID;
    private LocalDateTime COMMENT_TIME;
    private String COMMENT_CONTENT;
    private int SCORE;

    public int getBOOK_ID() {
        return BOOK_ID;
    }
    public int getSCORE() {
        return SCORE;
    }
    public LocalDateTime getCOMMENT_TIME() {
        return COMMENT_TIME;
    }
    public String getCOMMENT_CONTENT() {
        return COMMENT_CONTENT;
    }

    public void setBOOK_ID(int BOOK_ID) {
        this.BOOK_ID = BOOK_ID;
    }
    public void setCOMMENT_CONTENT(String COMMENT_CONTENT) {
        this.COMMENT_CONTENT = COMMENT_CONTENT;
    }
    public void setCOMMENT_TIME(LocalDateTime COMMENT_TIME) {
        this.COMMENT_TIME = COMMENT_TIME;
    }
    public void setSCORE(int SCORE) {
        this.SCORE = SCORE;
    }
}
