/*
 * @author Neo0214
 */
package org.group11.Patterns.Strategy;

public class QueryByName implements QueryAccount{
    @Override
    public void queryAccount() {
        System.out.println("查询姓名");
    }
}
