package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class BorrowBookService implements Service{
    @Override
    public String getName() {
        return "BorrowBookService";
    }

    @Override
    public void execute(String... args) {
        System.out.println("Executing BorrowBookService");
    }
}
