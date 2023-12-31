package org.group11.Patterns.Bridge;

/*
 * @author Neo0214
 */
public class TwoPersonRoom extends AbstractRoom{
    public TwoPersonRoom(AbstractRoomType roomSize){
        super(roomSize);
    }
    @Override
    public void useRoom(){
        System.out.print("使用自习室：2人");
        roomType.getType();
    }
}
