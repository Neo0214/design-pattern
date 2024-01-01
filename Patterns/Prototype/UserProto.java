package org.group11.Patterns.Prototype;

import org.group11.Patterns.ChainOfResponsibility.LoginHandler;

// interface Cloneable {
//     public Object clone();
// }

public class UserProto {
    private int id;
    private String user_name;
    private String user_key;
    
    public UserProto(int id,String user_name,String user_key) {
        this.id = id;
        this.user_name = user_name;
        this.user_key = user_key;
    }
    
    public Object clone() {
        return new UserProto(this.id,this.user_name,this.user_key);
    }
    
    public void set(int id,String user_name,String user_key) {
        this.id = id;
        this.user_name = user_name;
        this.user_key = user_key;
    }
    
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.user_name;
    }

    public String getKey() {
        return this.user_key;
    }

    private LoginHandler authenticationHandler;

    public void setAuthenticationHandler(LoginHandler authenticationHandler) {
        this.authenticationHandler = authenticationHandler;
    }

    public boolean login(int username, String password) {
        if (authenticationHandler != null) {
            return authenticationHandler.handleRequest(username, password);
        }
        
        System.out.println("没有设置身份验证处理器");
        return false;
    }
}

