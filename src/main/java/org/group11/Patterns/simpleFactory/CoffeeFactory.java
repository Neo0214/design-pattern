package org.group11.Patterns.simpleFactory;

import org.group11.Patterns.Builder.Coffee;

public class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        Coffee.Builder builder = new Coffee.Builder();
        switch (type) {
            case "1":
                return builder.espresso(1).Price().build();
            case "2":
                return builder.espresso(1).milk(1).milkForth(1).Price().build();
            case "3":
                return builder.espresso(1).milk(1).milkForth(1).cocoa(1).Price().build();
            default:
                throw new IllegalArgumentException("未知的咖啡类型：" + type);
        }
    }
}

