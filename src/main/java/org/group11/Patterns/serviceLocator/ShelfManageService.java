package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class ShelfManageService implements Service{
    @Override
    public String getName() {
        return "ShelfManageService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing ShelfManageService");
    }
}
