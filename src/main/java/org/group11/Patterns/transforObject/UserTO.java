package org.group11.Patterns.transforObject;

public class UserTO {
    private int id;
    private String user_key;
    private String user_name;

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return user_key;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String user_key) {
        this.user_key = user_key;
    }

    @Override
    public String toString(){
        return "id:"+id+" name:"+user_name+" password:"+user_key;
    }
}
