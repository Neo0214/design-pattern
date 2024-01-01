package org.group11.Entity;

/*
 * @author Neo0214
 */
public class User {
    private int id;
    private String password;
    private String user_name;

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "id:"+id+" name:"+user_name+" password:"+password;
    }
}
