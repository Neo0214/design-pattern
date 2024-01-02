package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class UserLoginService implements Service{
    @Override
    public String getName() {
        return "UserLoginService";
    }

    @Override
    public void execute(String... args) {
        System.out.println("Executing UserLoginService");
    }
}
