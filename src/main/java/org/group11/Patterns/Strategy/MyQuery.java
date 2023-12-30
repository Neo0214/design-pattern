/*
 * @author Neo0214
 */
package org.group11.Patterns.Strategy;

public class MyQuery {
    private QueryAccount queryAccount;

    public MyQuery(QueryAccount queryAccount) {
        this.queryAccount = queryAccount;
    }

    public void queryAccount() {
        queryAccount.queryAccount();
    }
}
