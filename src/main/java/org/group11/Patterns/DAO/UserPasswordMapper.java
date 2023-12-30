/*
 * @author Neo0214
 */
package org.group11.Patterns.DAO;

public interface UserPasswordMapper {
    public boolean checkPassword(int userId,String password);
}
