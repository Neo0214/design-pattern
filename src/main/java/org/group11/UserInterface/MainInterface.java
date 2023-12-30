/*
 * @author Neo0214
 */
package org.group11.UserInterface;

import org.group11.Patterns.DAO.Impl.UserPasswordImpl;
import org.group11.Patterns.Strategy.MyQuery;
import org.group11.Patterns.Strategy.QueryByBorrow;
import org.group11.Patterns.Strategy.QueryByName;
import org.group11.Patterns.serviceLocator.Service;
import org.group11.Patterns.serviceLocator.ServiceLocator;

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
                Service service = ServiceLocator.getService("ReturnBookService");
                service.execute("0");
            } else if (msg.equals("2")) {
                // do something
            }else if (msg.equals("10")){
                // do something
            }
            else if (msg.equals("q")) {
                break;
            }
        }

    }

    public void printMenu(){
        System.out.println("1. 还书");
        System.out.println("2. 查询用户");

    }
    private String getInput(){
        while (!scanner.hasNextLine()){
        } // block when no input
        return scanner.nextLine();
    }



    public void execQueryAccount(String adminId){
        System.out.print("输入密码确认：");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (new UserPasswordImpl().checkPassword(Integer.parseInt(adminId),password)){
            // 密码正确
            System.out.println("选择查询方法：1.按借书查询 2.按姓名查询");
            String choice = getInput();
            if (choice.equals("1")){
                System.out.print("正在查询所有借书人信息...");
                MyQuery myQuery = new MyQuery(new QueryByBorrow());
                myQuery.queryAccount();
            }
            else if (choice.equals("2")){
                System.out.print("请输入被查询者姓名:");
                String name = getInput();
                MyQuery myQuery = new MyQuery(new QueryByName());
                myQuery.queryAccount();
            }
        }else{
            System.out.println("密码错误");
        }
    }
}
