package org.group11.Patterns.mvc;

import org.group11.Patterns.Composite.ShelfManage;

import java.util.ArrayList;
import java.util.List;

public class model {
    public List<ShelfManage.LibraryComponent> components = new ArrayList<>(); // 存储图书或图书包的列表

    // 添加图书或图书包到当前的图书包中
    public void addtopackage(ShelfManage.LibraryComponent component) {
        components.add(component);
    }

    // 从图书包中移除图书或图书包
    public void removefrompackage(ShelfManage.LibraryComponent component) {
        components.remove(component);
    }

    // 添加图书或图书包到书架上
    public void addtoshelf(ShelfManage.LibraryComponent component) {
        components.add(component);
    }

    // 从书架上移除图书或图书包
    public void removefromshelf(ShelfManage.LibraryComponent component) {
        components.remove(component);
    }
}


