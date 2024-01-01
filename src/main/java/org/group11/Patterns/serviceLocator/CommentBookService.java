package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class CommentBookService implements Service{
    @Override
    public String getName() {
        return "CommentBookService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("Executing CommentBookService");
    }
}
