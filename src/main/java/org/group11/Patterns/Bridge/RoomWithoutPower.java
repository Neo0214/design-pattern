package org.group11.Patterns.Bridge;

/*
 * @author Neo0214
 */
public class RoomWithoutPower extends AbstractRoomType {
    @Override
    public void getType(){
        System.out.println("不带插头房间");
    }
}
