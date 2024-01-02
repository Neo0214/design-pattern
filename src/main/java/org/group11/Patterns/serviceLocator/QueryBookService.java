package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class QueryBookService implements Service{
    @Override
    public String getName() {
        return "QueryBookService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing QueryBookService");
    }
}
