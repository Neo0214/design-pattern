package org.group11.Patterns.Composite;

import org.group11.Patterns.mvc.model;
import org.group11.Patterns.mvc.view;

import java.util.ArrayList;
import java.util.List;

public class ShelfManage {
    // Component（组件）
    // 这是一个接口，用于定义在图书组合结构中所有对象共有的行为。
    public interface LibraryComponent {
        void print(); // 定义一个打印方法，用于输出信息

        // 实现打印方法，首先打印书架的名称，然后输出书架上所有图书或图书包的名称
        void print(String shelfId);
    }

    // Leaf（叶子节点）
    // 这个类代表单本图书，实现了LibraryComponent接口。
    public static class Book implements LibraryComponent {
        public String id; // 图书编号

        public Book(String id) {
            this.id = id; // 构造方法，设置图书编号
        }

        // 打印图书信息的方法
        public void print() {
            System.out.println("Book ID: " + id);
        }

        @Override
        public void print(String id) {
            view.Bookprint(id);
        }
    }

    // Composite（复合节点，打包）
    // 这个类代表图书的组合，可以是多本图书的集合，实现了LibraryComponent接口。
    public static class BookPackage implements LibraryComponent {
        public List<LibraryComponent> components = new ArrayList<>(); // 存储图书或图书包的列表

        // 添加图书或图书包到当前的图书包中
        public void add(LibraryComponent component) {
            components.add(component);

            model model = new model();
            model.addtopackage(component);
        }

        // 从图书包中移除图书或图书包
        public void remove(LibraryComponent component) {
            components.remove(component);

            model model = new model();
            model.removefrompackage(component);
        }

        // 实现打印方法，输出图书包中所有图书或图书包的名称
        @Override
        public void print() {
            for (LibraryComponent component : components) {
                component.print();
            }
        }

        @Override
        public void print(String shelfId) {
            view.BookPackageprint(shelfId);
        }
    }

    // Composite（复合节点，书架）
    // 这个类代表一个书架，可以包含图书和图书包，实现了LibraryComponent接口。
    public static class BookShelf implements LibraryComponent {
        private List<LibraryComponent> components = new ArrayList<>(); // 存储图书架上的组件
        private String shelfId; // 书架的名称

        public BookShelf(String shelfId) {
            this.shelfId = shelfId; // 构造函数，初始化书架名称
        }

        // 添加图书或图书包到书架上
        public void add(LibraryComponent component) {
            components.add(component);

            model model = new model();
            model.addtoshelf(component);
        }

        // 从书架上移除图书或图书包
        public void remove(LibraryComponent component) {
            components.remove(component);

            model model = new model();
            model.removefromshelf(component);
        }

        @Override
        public void print() {
            System.out.println("Shelf: " + shelfId);
            for (ShelfManage.LibraryComponent component : components) {
                component.print();
            }
        }

        // 实现打印方法，首先打印书架的名称，然后输出书架上所有图书或图书包的名称
        @Override
        public void print(String shelfId) {
            view.BookShelfprint(shelfId);
            for (ShelfManage.LibraryComponent component : components) {
                component.print();
            }
        }
    }

}
