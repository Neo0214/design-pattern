package org.group11.Patterns.Bridge;

/*
 * @author Neo0214
 */
public class FourPersonRoom extends AbstractRoom{
    public FourPersonRoom(AbstractRoomType roomSize){
        super(roomSize);
    }
    @Override
    public void useRoom(){
        System.out.print("使用自习室：4人");
        roomType.getType();
    }
}
