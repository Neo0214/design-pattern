package org.group11.Patterns.serviceLocator;
import static org.group11.Tools.Input.getInput;
import java.util.ArrayList;
import java.util.List;

import org.group11.Patterns.Composite.ShelfManage;
import org.group11.Patterns.Flyweight.PutBook;
import org.group11.Patterns.DAO.Impl.ShelfManageImpl;
import org.group11.Patterns.DAO.ShelfManageMapper;

public class ShelfManageService implements Service{

    @Override
    public String getName() {
        return "ShelfManageService";
    }

    @Override
    public void execute(String... args) {

        System.out.println("Executing ShelfManageService");

        System.out.print("请输入要放入的书架编号：");
        String shelfId = getInput();
        ShelfManage.BookShelf shelf = new ShelfManage.BookShelf(shelfId); // 创建书架

        System.out.print("整理前: ");
        shelf.print(); // 打印书架上的所有内容，包括单本图书和图书包

        // 使用享元工厂和享元对象
        PutBook.FlyweightFactory factory = new PutBook.FlyweightFactory(); // 创建享元工厂实例

        System.out.print("请输入要打包的图书数量：");
        String num = getInput();

        ShelfManageImpl smi = new ShelfManageImpl();

        try {
            if(num.equals("1")) {
                System.out.print("请输入图书的编号：");
                String BookId = getInput();

                // 获取图书的享元对象，并放置在书架上
                PutBook.Flyweight flyweight1 = factory.getFlyweight(BookId);
                ShelfManage.Book book = new ShelfManage.Book(BookId); // 创建图书

                flyweight1.placeOnShelf();
                shelf.add(book); // 将单本图书添加到书架上

                smi.ShelfBelong(BookId,shelfId);  // 存储到数据库
                shelf.print(); // 打印书架上的所有内容，包括单本图书和图书包
            } else if(Integer.parseInt(num)>1) {
                ShelfManage.BookPackage bookPackage = new ShelfManage.BookPackage(); // 创建图书包
                for (int i = 0; i < Integer.parseInt(num); i++) { // 循环输入图书编号，并创建图书对象
                    System.out.print("请输入第 " + (i + 1) + " 本图书的编号：");
                    String BookId = getInput();
                    ShelfManage.Book book = new ShelfManage.Book(BookId); // 创建图书
                    bookPackage.add(book); // 将图书添加到图书包中
                }
                shelf.add(bookPackage); // 将图书包添加到书架上
                for (ShelfManage.LibraryComponent component : bookPackage.components) {
                    if (component instanceof ShelfManage.Book) {
                        smi.ShelfBelong(((ShelfManage.Book) component).id,shelfId);  // 存储每一本图书到数据库
                    }
                }

                System.out.print("整理后: ");
                shelf.print(); // 打印书架上的所有内容，包括单本图书和图书包

                }else{
                System.out.print("图书数量不能小于1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库操作失败！");
        }

    }

}
