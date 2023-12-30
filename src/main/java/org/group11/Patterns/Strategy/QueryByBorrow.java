/*
 * @author Neo0214
 */
package org.group11.Patterns.Strategy;

public class QueryByBorrow implements QueryAccount{
    @Override
    public void queryAccount() {
        System.out.println("查询借阅信息");
    }
}
