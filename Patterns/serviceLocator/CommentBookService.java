package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Facade.CommentFacade;
import org.group11.Tools.Input;

/*
 * @author Neo0214
 */
public class CommentBookService implements Service{
    @Override
    public String getName() {
        return "CommentBookService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("请输入书籍编号");
        String bookId= Input.getInput();
        System.out.println("1. 查看指定图书评价");
        System.out.println("2. 对指定图书进行评价");
        String operation= Input.getInput();

        if (operation.equals("1")) {
            // 执行查看指定图书评价的操作逻辑
            CommentFacade cf = new CommentFacade();
            cf.getInfo(Integer.valueOf(bookId));
        } else if (operation.equals("2")) {
            // 执行对指定图书进行评价的操作逻辑
            CommentFacade cf = new CommentFacade();
            cf.saveComment(Integer.valueOf(bookId));
            System.out.println("评价已保存");
        } else {
            System.out.println("无效的操作");
        }

    }
}
