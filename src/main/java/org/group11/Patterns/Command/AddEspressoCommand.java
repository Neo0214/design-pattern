package org.group11.Patterns.Command;

import org.group11.Patterns.Builder.Coffee;
import org.group11.Patterns.simpleFactory.CoffeeFactory;
import org.group11.Tools.Input;

public class AddEspressoCommand implements CoffeeCommand {
    private Coffee coffee;
    private Coffee.CoffeeMemento memento;

    public AddEspressoCommand(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void execute() {
        memento = coffee.createMemento(); // 保存当前状态
        coffee.setEspresso(coffee.getEspresso() + 1); // 执行命令
    }

    @Override
    public void undo() {
        coffee.restoreFromMemento(memento); // 撤销命令
    }
}
