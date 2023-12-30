/*
 * @author Neo0214
 */
package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Proxy.ReturnBook;
import org.group11.Patterns.Proxy.VReturnBook;
import org.group11.Patterns.Proxy.VReturnBookProxy;
import org.group11.Tools.Input;

public class ReturnBookService implements Service{
    @Override
    public String getName() {
        return "ReturnBookService";
    }

    @Override
    public void execute(String... args) {
        System.out.println("请输入书籍编号");
        String bookId= Input.getInput();
        ReturnBook proxy=new VReturnBookProxy(new VReturnBook());
        if (proxy.returnBook(Integer.parseInt(bookId),Integer.parseInt(args[0]))){
            System.out.println("还书成功");
        }
        else{
            System.out.println("还书失败");
        }
    }
}
