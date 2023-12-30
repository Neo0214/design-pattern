package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class OrderCoffeeService implements Service{
    @Override
    public String getName() {
        return "OrderCoffeeService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing OrderCoffeeService");
    }
}
