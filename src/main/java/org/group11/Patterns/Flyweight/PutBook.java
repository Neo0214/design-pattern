package org.group11.Patterns.Flyweight;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class PutBook {
    // 图书类（Book）
// 这个类代表了图书，包含一个唯一的标识符：ID。
    static class Book {
        private final String id; // 图书的唯一标识符

        public Book(String id) {
            this.id = id; // 构造函数初始化图书ID
        }

        public String getId() {
            return id; // 获取图书ID的方法
        }
    }

    // 享元接口（Flyweight）
// 这个接口定义了享元对象的外部状态操作。
    public interface Flyweight {
        void placeOnShelf(); // 放置在书架上的方法
    }

    // 实现享元类（ConcreteFlyweight）
// 这个类实现了享元接口，代表具体的享元对象。
    static class ConcreteFlyweight implements Flyweight {
        private final Book book; // 内部状态，这里是图书对象

        public ConcreteFlyweight(Book book) {
            this.book = book; // 构造函数，接收图书对象
        }

        @Override
        public void placeOnShelf() {
            // 放置在书架上
            // System.out.println("Book with ID " + book.getId() + " is placed on the shelf.");
        }
    }

    // 享元工厂（FlyweightFactory）
    // 这个类用于创建和管理享元对象。
    public static class FlyweightFactory {
        private final Map<String, Flyweight> flyweights = new HashMap<>(); // 用于存储享元对象的映射

        public Flyweight getFlyweight(String bookId) {
            // 获取享元对象的方法
            Flyweight flyweight = flyweights.get(bookId);
            if (flyweight == null) {
                // 如果不存在该ID的享元对象，则创建一个新的享元对象
                flyweight = new ConcreteFlyweight(new Book(bookId));
                flyweights.put(bookId, flyweight); // 将新创建的享元对象存入映射中
            }
            return flyweight; // 返回享元对象
        }
    }


}
