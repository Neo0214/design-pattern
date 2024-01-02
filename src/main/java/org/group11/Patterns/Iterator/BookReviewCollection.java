package org.group11.Patterns.Iterator;

import org.group11.Patterns.serviceLocator.QueryBookService;

import java.sql.*;

public class BookReviewCollection implements BookReviewIterator {
    private ResultSet resultSet;
    private Connection conn;
    private PreparedStatement stmt;

    public BookReviewCollection(String bookId) throws SQLException {
        conn = DriverManager.getConnection(
                QueryBookService.DB_URL, QueryBookService.USER, QueryBookService.PASS);
        stmt = conn.prepareStatement(
                "SELECT COMMENT_TIME, COMMENT_CONTENT, SCORE FROM comment WHERE BOOK_ID = ?");
        stmt.setInt(1, Integer.parseInt(bookId));
        this.resultSet = stmt.executeQuery();
    }

    @Override
    public boolean hasNext() {
        try {
            boolean hasMore = resultSet.next();
            if (!hasMore) {
                // Close resources when done
                resultSet.close();
                stmt.close();
                conn.close();
            }
            return hasMore;
        } catch (SQLException e) {
            closeResources();
            throw new RuntimeException("Error moving to the next review", e);
        }
    }

    @Override
    public BookReview next() {
        try {
            String reviewTime = resultSet.getString("COMMENT_TIME");
            String content = resultSet.getString("COMMENT_CONTENT");
            int score = resultSet.getInt("SCORE");
            return new BookReview(reviewTime, content, score);
        } catch (SQLException e) {
            closeResources();
            throw new RuntimeException("Error getting review data", e);
        }
    }

    private void closeResources() {
        try {
            if (resultSet != null && !resultSet.isClosed()) resultSet.close();
            if (stmt != null && !stmt.isClosed()) stmt.close();
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            // Log error or take additional action
        }
    }
}