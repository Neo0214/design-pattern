package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class AdminLoginService implements Service{
    @Override
    public String getName() {
        return "AdminLoginService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing AdminLoginService");
    }
}
