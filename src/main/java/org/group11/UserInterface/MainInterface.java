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
                Service service = ServiceLocator.getService("CreateUserService");
                service.execute("0");
            } else if (msg.equals("2")) {
                Service service = ServiceLocator.getService("UserLoginService");
                service.execute("");
            }else if (msg.equals("3")){
                Service service = ServiceLocator.getService("AdminLoginService");
                service.execute("");
            }else if (msg.equals("4")) {
                Service service = ServiceLocator.getService("BorrowBookService");
                service.execute("");
            }else if (msg.equals("5")) {
                Service service = ServiceLocator.getService("ReturnBookService");
                service.execute("");
            }else if (msg.equals("6")) {
                Service service = ServiceLocator.getService("RemindReturnService");
                service.execute("1");
            }else if (msg.equals("7")) {
                Service service = ServiceLocator.getService("QueryAccountService");
                service.execute("");
            }else if (msg.equals("8")) {
                Service service = ServiceLocator.getService("QueryBookService");
                service.execute("");
            }else if (msg.equals("9")) {
                Service service = ServiceLocator.getService("GiveBookService");
                service.execute("");
            }else if (msg.equals("10")) {
                Service service = ServiceLocator.getService("OrderCoffeeService");
                service.execute("");
            }else if (msg.equals("11")) {
                Service service = ServiceLocator.getService("ShelfManageService");
                service.execute("");
            }else if (msg.equals("12")) {
                Service service = ServiceLocator.getService("UseRoomService");
                service.execute("");
            }else if (msg.equals("13")) {
                Service service = ServiceLocator.getService("CommentBookService");
                service.execute("");
            }else if (msg.equals("q")) {
                break;
            }
        }

    }

    public void printMenu(){
        System.out.println("1. 创建用户");
        System.out.println("2. 用户登录");
        System.out.println("3. 管理员登录");
        System.out.println("4. 借书");
        System.out.println("5. 还书");
        System.out.println("6. 提醒还书");
        System.out.println("7. 查询账号");
        System.out.println("8. 查询图书");
        System.out.println("9. 赠书");
        System.out.println("10. 点咖啡");
        System.out.println("11. 书架整理");
        System.out.println("12. 自习室预约");
        System.out.println("13. 图书评价");
        System.out.println("q. 退出");

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
