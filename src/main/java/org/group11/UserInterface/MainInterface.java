package org.group11.UserInterface;

import org.group11.Patterns.Proxy.ReturnBook;
import org.group11.Patterns.Proxy.VReturnBook;
import org.group11.Patterns.Proxy.VReturnBookProxy;

import java.util.Scanner;

public class MainInterface {
    private final Scanner scanner;

    public MainInterface(){
        scanner = new Scanner(System.in);
    }
    public void run(){
        System.out.println("start");
        printMenu();
        while (true){
            String msg=getInput();
            if (msg.equals("1")){
                execReturn("0");
            } else if (msg.equals("2")) {
                // do something
            } else if (msg.equals("q")) {
                break;
            }
        }

    }

    public void printMenu(){
        System.out.println("1. 还书");


    }
    private String getInput(){
        while (!scanner.hasNextLine()){
        } // block when no input
        return scanner.nextLine();
    }

    private void execReturn(String userId){
        System.out.println("请输入书籍编号");
        String bookId=getInput();
        ReturnBook proxy=new VReturnBookProxy(new VReturnBook());
        if (proxy.returnBook(Integer.parseInt(bookId),Integer.parseInt(userId))){
            System.out.println("还书成功");
        }
        else{
            System.out.println("还书失败");
        }
    }

}
