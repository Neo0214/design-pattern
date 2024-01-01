package org.group11.Patterns.Bridge;

/*
 * @author Neo0214
 */
public abstract class AbstractRoom {
    protected AbstractRoomType roomType;
    public AbstractRoom(AbstractRoomType roomType){
        this.roomType=roomType;
    }
    public abstract void useRoom();
}
