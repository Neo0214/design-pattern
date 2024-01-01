package org.group11.Patterns.mvc;

import org.group11.Entity.Comment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CommentView {
    public void displayComments(List<Comment> comments) {
        // 显示图书评价信息列表
        for (Comment comment : comments) {
            System.out.println("BookComment: ");
            System.out.println("Bookid: " + comment.getBOOK_ID());
            System.out.println("Content: " + comment.getCOMMENT_CONTENT());
            System.out.println("Time: " + comment.getCOMMENT_TIME());
            System.out.println("Score: " + comment.getSCORE());
            System.out.println("------------------------------");
        }
    }
    public Comment getCommentFromUser(int id) {
        // 获取用户输入的评价信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的评价内容：");
        String content = scanner.nextLine();
        System.out.println("请输入您的打分：");
        String score = scanner.nextLine();

        // 创建Comment对象
        Comment comment = new Comment();
        comment.setBOOK_ID(id);
        comment.setCOMMENT_CONTENT(content);
        comment.setSCORE(Integer.valueOf(score));
        comment.setCOMMENT_TIME(LocalDateTime.now());

        return comment;
    }
}
