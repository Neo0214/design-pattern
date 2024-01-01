package org.group11.Patterns.Bridge;

/*
 * @author Neo0214
 */
public class RoomWithPower extends AbstractRoomType {
    @Override
    public void getType(){
        System.out.println("带插头房间");
    }
}
