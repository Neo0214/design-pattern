package org.group11.Patterns.serviceLocator;

/*
 * @author Neo0214
 */
public class UseRoomService implements Service{
    @Override
    public String getName() {
        return "UseRoomService";
    }

    @Override
    public void execute(String... args) {
        System.out.println("Executing UseRoomService");
    }
}
