package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class CreateUserService implements Service{
    @Override
    public String getName() {
        return "CreateUserService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing CreateUserService");
    }
}
