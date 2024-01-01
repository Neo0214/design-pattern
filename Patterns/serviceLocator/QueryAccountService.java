package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Strategy.MyQuery;
import org.group11.Patterns.Strategy.QueryByBorrow;
import org.group11.Patterns.Strategy.QueryByName;


import static org.group11.Tools.Input.getInput;

/*
 * @author Neo0214
 */
public class QueryAccountService implements Service{
    @Override
    public String getName() {
        return "QueryAccountService";
    }
    @Override
    public void execute(String... args) {
        System.out.println("选择查询方法：1.按借书查询 2.按姓名查询");
        String choice = getInput();
        if (choice.equals("1")){
            MyQuery myQuery = new MyQuery(new QueryByBorrow());
            myQuery.queryAccount();
        }
        else if (choice.equals("2")){
            MyQuery myQuery = new MyQuery(new QueryByName());
            myQuery.queryAccount();
        }
    }
}
