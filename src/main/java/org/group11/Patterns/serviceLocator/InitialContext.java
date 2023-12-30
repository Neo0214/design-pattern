/*
 * @author Neo0214
 */
package org.group11.Patterns.serviceLocator;

public class InitialContext {
    public Object lookup(String name)
    {
        if (name.equalsIgnoreCase("ReturnBookService")) {
            return new ReturnBookService();
        }
        return null;
    }
}
