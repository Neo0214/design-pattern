package org.group11.Patterns.Bridge;

/*
 * @author Neo0214
 */
public class SixPersonRoom extends AbstractRoom{
    public SixPersonRoom(AbstractRoomType roomSize){
        super(roomSize);
    }
    @Override
    public void useRoom(){
        System.out.print("使用自习室：6人");
        roomType.getType();
    }
}
