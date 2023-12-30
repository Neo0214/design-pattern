package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class RemindReturnService implements Service{
    @Override
    public String getName() {
        return "RemindReturnService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing RemindReturnService");
    }
}
