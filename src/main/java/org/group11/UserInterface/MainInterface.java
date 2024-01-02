/*
 * @author Neo0214
 */
package org.group11.UserInterface;

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
        while (true){
            printMenu();
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
                service.execute("0");
            }else if (msg.equals("6")) {
                Service service = ServiceLocator.getService("RemindReturnService");
                service.execute("");
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
            System.out.println("按回车键继续");
            getInput();
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




}
