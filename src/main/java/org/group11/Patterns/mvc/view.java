package org.group11.Patterns.mvc;

import org.group11.Patterns.Composite.ShelfManage;

public class view {
    public static void Bookprint(String id) {
        System.out.println("Book ID: " + id);
    }

    public static void BookPackageprint(String shelfId) {
        System.out.println("BookPackage");
    }

    public static void BookShelfprint(String shelfId) {
        System.out.println("Shelf: " + shelfId);
    }
}
