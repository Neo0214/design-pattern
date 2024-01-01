/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO;

// import org.group11.Entity.User;

import org.group11.Patterns.transforObject.UserTO;

// import org.group11.Patterns.transforObject.UserTO;

import java.util.List;

public interface UserMapper {
    public boolean checkPassword(int userId,String password);
    public List<UserTO> getUser(String name, String password);
    public int getMaxId();
    public boolean insertUser(int userId, String name, String password);
}
