package org.group11.Patterns.ChainOfResponsibility;


public abstract class LoginHandler {
    protected LoginHandler nextHandler;

    public void setNextHandler(LoginHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean handleRequest(int username, String password);
}
