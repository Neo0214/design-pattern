package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class QueryAccountService implements Service{
    @Override
    public String getName() {
        return "QueryAccountService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing QueryAccountService");
    }
}
