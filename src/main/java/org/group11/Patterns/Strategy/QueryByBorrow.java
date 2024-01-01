/*
 * @author Neo0214
 */
package org.group11.Patterns.Strategy;

import org.group11.Entity.User;
import org.group11.Patterns.DAO.Impl.BorrowImpl;

import java.util.List;

public class QueryByBorrow implements QueryAccount{
    @Override
    public void queryAccount() {
        System.out.println("正在查询所有借书人信息...");
        List<User> users = new BorrowImpl().queryBorrowUsers();
        if (users.isEmpty()){
            System.out.println("没有正在借书的人");
        }else {
            for (User user:users){
                System.out.println(user);
            }
        }
    }
}
