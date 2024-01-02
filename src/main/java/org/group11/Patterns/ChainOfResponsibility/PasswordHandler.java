package org.group11.Patterns.ChainOfResponsibility;

import java.util.regex.Pattern;

public class PasswordHandler extends LoginHandler{
    @Override
    public boolean handleRequest(int username, String password) {
        // 进行用户名密码验证的逻辑判断
        boolean containsDigit = Pattern.compile("\\d").matcher(password).find();
        if (containsDigit==true) {
            boolean isright = new UserImpl().checkPassword(username, password);
            if(isright==true){
                System.out.println("用户名密码验证通过");
                return true;
            }
            else{
                System.out.println("用户名密码验证未通过，请再次尝试");
                return true;
            }
        }
        
        // 如果当前处理器无法处理请求，则将请求传递给下一个处理器
        else if (nextHandler != null) {
            return nextHandler.handleRequest(username, password);
        }
        
        System.out.println("无法验证用户名密码");
        return false;
    }
}
