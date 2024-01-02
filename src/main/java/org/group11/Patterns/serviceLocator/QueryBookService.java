package org.group11.Patterns.serviceLocator;

import static org.group11.Tools.Input.getInput;
import org.group11.Patterns.Iterator.BookReview;
import org.group11.Patterns.Iterator.BookReviewCollection;
import org.group11.Patterns.Iterator.BookReviewIterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.group11.Patterns.Visitor.BookReviewVisitor;
import org.group11.Patterns.Visitor.ConcreteBookReviewVisitor;

public class QueryBookService implements Service {
    public String getName() {
        return "QueryBookService";
    }
    public void execute(String... args) {
        System.out.println("请输入图书编号：");
        String bookId = getInput(); // 假定getInput是一个静态方法，用于获取用户输入
        String bookshelfId = getBookshelfId(bookId);
        if (bookshelfId != null) {
            System.out.println("编号为" + bookId + "的图书书架编号是：" + bookshelfId);

            BookReviewVisitor visitor = new ConcreteBookReviewVisitor();

            boolean foundReviews = false;
            try {
                BookReviewIterator iterator = new BookReviewCollection(bookId);

                while (iterator.hasNext()) {
                    foundReviews = true;
                    BookReview review = iterator.next();
                    review.accept(visitor); // 将visitor传递给accept方法
                }
                if (!foundReviews) {
                    System.out.println("不存在编号为" + bookId + "的书的评价。");
                }
            } catch (SQLException e) {
                System.err.println("数据库查询错误: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("输入的图书ID必须是数字。");
            } catch (Exception e) {
                System.err.println("发生错误: " + e.getMessage());
            }
        } else {
            System.out.println("该图书不存在！");
        }
    }

    // Database credentials and URL from your provided MyBatis configuration
    public static final String DB_URL = "jdbc:mysql://82.156.161.216:3306/db-design-patterns?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    public static final String USER = "design";
    public static final String PASS = "patterns";

    static {
        // Attempt to register the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to register MySQL JDBC driver", e);
        }
    }

    private String getBookshelfId(String bookId) {
        String bookshelfId = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT BOOKSHELF_ID FROM shelf_belonging WHERE BOOK_ID = ?")) {
            stmt.setInt(1, Integer.parseInt(bookId));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    bookshelfId = rs.getString("BOOKSHELF_ID");
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("输入的图书ID必须是数字。");
        }
        return bookshelfId;
    }
}