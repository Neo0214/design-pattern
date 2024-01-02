package org.group11.Patterns.Command;

import org.group11.Patterns.Builder.Coffee;
import org.group11.Patterns.simpleFactory.CoffeeFactory;
import org.group11.Tools.Input;

// 命令接口
public interface CoffeeCommand {
    void execute();
    void undo();
}