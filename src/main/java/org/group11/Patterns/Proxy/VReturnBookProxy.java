package org.group11.Patterns.Proxy;

import org.group11.Patterns.DAO.Impl.UserPasswordImpl;

import java.util.Scanner;

public class VReturnBookProxy implements ReturnBook{
    private ReturnBook returnBook;
    public VReturnBookProxy(ReturnBook returnBook){
        this.returnBook = returnBook;
    }
    @Override
    public boolean returnBook(int bookId, int userId) {
        // 添加额外功能：检查密码
        System.out.print("输入密码确认：");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (new UserPasswordImpl().checkPassword(userId,password)){
            // 密码正确
            return this.returnBook.returnBook(bookId,userId);
        }
        // else do:
        System.out.println("密码错误");
        return false;



    }
}
