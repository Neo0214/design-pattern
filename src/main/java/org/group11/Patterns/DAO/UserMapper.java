/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO;

import org.group11.Entity.User;

import java.util.List;

public interface UserMapper {
    public boolean checkPassword(int userId,String password);
    public List<User> getUserByName(String name);
}
