package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class GiveBookService implements Service{
    @Override
    public String getName() {
        return "GiveBookService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing GiveBookService");
    }
}
