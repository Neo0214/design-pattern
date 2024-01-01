package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Bridge.AbstractRoom;
import org.group11.Patterns.Bridge.RoomWithPower;
import org.group11.Patterns.Bridge.TwoPersonRoom;

import static org.group11.Tools.Input.getInput;

/*
 * @author Neo0214
 */
public class UseRoomService implements Service {
    @Override
    public String getName() {
        return "UseRoomService";
    }

    @Override
    public void execute(String... args) {
        System.out.print("请选择房间人数(2、4、6):");
        String num = getInput();
        System.out.print("请选择房间类型(1-带插头，2-无插头):");
        String type = getInput();
        AbstractRoom room;
        if (num.equals("2")) {
            if (type.equals("1")) {
                room = new TwoPersonRoom(new RoomWithPower());
            } else {
                room = new TwoPersonRoom(new RoomWithPower());
            }
        } else if (num.equals("4")) {
            if (type.equals("1")) {
                room = new TwoPersonRoom(new RoomWithPower());
            } else {
                room = new TwoPersonRoom(new RoomWithPower());
            }
        } else if (num.equals("6")) {
            if (type.equals("1")) {
                room = new TwoPersonRoom(new RoomWithPower());
            } else {
                room = new TwoPersonRoom(new RoomWithPower());
            }
        } else {
            System.out.println("没有该类型房间");
            return;
        }
        room.useRoom();
    }
}
