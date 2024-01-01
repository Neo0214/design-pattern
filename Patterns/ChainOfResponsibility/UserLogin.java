package org.group11.Patterns.ChainOfResponsibility;

public class UserLogin {
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
