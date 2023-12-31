package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Specification.ISpecification;
import org.group11.Patterns.Specification.UnreturnedBooksSpecification;
import org.group11.Patterns.Proxy.BorrowBook;
import org.group11.Patterns.Proxy.RealBorrowBook;
import org.group11.Patterns.Proxy.ProxyBorrowBook;
import org.group11.Tools.Input;

public class BorrowBookService implements Service{
    @Override
    public String getName() {
        return "BorrowBookService";
    }

    @Override
    public void execute(String... args) {

        System.out.println("Executing BorrowBookService");
        System.out.println("查询借书权限中...");
        //判断是否有旧书未还
        //输入书籍编号
        //输入密码验证
        //判断书是否被借出
        //借书
        //借书成功
        int userId = Integer.parseInt(args[0]);
        ISpecification spec = new UnreturnedBooksSpecification();
        if (spec.isSatisfiedBy(userId)) {
            System.out.println("您还有未归还的书籍，请先归还。");
        } else {
            System.out.println("您可以借阅新的书籍。");
            System.out.println("请输入书籍编号");
            String bookId= Input.getInput();
            BorrowBook proxy = new ProxyBorrowBook(new RealBorrowBook());
            if (proxy.borrowBook(Integer.parseInt(bookId),Integer.parseInt(args[0]))){
                System.out.println("借书成功!");
            }
            else{
                System.out.println("借书失败!");
            }
        }

    }
}
