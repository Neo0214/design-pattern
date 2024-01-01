/*
 * @author Neo0214
 */
package org.group11.Patterns.serviceLocator;

public class InitialContext {
    public Object lookup(String name) {
        if (name.equalsIgnoreCase("CreateUserService")) {
            return new CreateUserService();
        } else if (name.equalsIgnoreCase("UserLoginService")) {
            return new UserLoginService();
        } else if (name.equalsIgnoreCase("AdminLoginService")) {
            return new AdminLoginService();
        } else if (name.equalsIgnoreCase("ReturnBookService")) {
            return new ReturnBookService();
        } else if (name.equalsIgnoreCase("BorrowBookService")) {
            return new BorrowBookService();
        } else if (name.equalsIgnoreCase("RemindReturnService")) {
            return new RemindReturnService();
        } else if (name.equalsIgnoreCase("QueryAccountService")) {
            return new QueryAccountService();
        } else if (name.equalsIgnoreCase("QueryBookService")) {
            return new QueryBookService();
        } else if (name.equalsIgnoreCase("GiveBookService")) {
            return new GiveBookService();
        } else if (name.equalsIgnoreCase("OrderCoffeeService")) {
            return new OrderCoffeeService();
        } else if (name.equalsIgnoreCase("ShelfManageService")) {
            return new ShelfManageService();
        } else if (name.equalsIgnoreCase("UseRoomService")) {
            return new UseRoomService();
        } else if (name.equalsIgnoreCase("CommentBookService")) {
            return new CommentBookService();
        }
        else if (name.equalsIgnoreCase("NoticeReturnService")) {
            return new NoticeReturnService();
        }
        else if (name.equalsIgnoreCase("NoticeReturnService")) {
            return new NoticeReturnService();
        }
        return null;
    }
}
