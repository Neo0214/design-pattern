package org.group11.Patterns.Proxy;

import org.group11.Patterns.DAO.Impl.UserImpl;

import java.util.Scanner;

public class ProxyBorrowBook implements BorrowBook{
    private BorrowBook borrowBook;
    public ProxyBorrowBook(BorrowBook borrowBook){
        this.borrowBook = borrowBook;
    }
    @Override
    public boolean borrowBook(int bookId, int userId) {
        // 添加额外功能：检查密码
        System.out.print("输入密码确认：");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (new UserImpl().checkPassword(userId,password)){
            // 密码正确
            return this.borrowBook.borrowBook(bookId,userId);
        }
        // else do:
        System.out.println("密码错误");
        return false;

    }
}
