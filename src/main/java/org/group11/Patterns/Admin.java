package org.group11.Patterns.Singleton;

public class Admin {
    public String user_key;
    private static volatile Admin instance=null;    //保证 instance 在所有线程中同步
    private Admin(String user_key){
        this.user_key = user_key;
    }    //private 避免类在外部被实例化
    public static Admin getInstance(String user_key) {
        // 双重检查锁定（Double-Checked Locking）
        if (instance == null) {
            synchronized (Admin.class) {
                if (instance == null) {
                    instance = new Admin(user_key);
                }
            }
        }
        return instance;
    }
}
