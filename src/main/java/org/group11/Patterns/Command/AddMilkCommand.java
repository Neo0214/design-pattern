package org.group11.Patterns.Command;

import org.group11.Patterns.Builder.Coffee;

public class AddMilkCommand implements CoffeeCommand{
    private Coffee coffee;
    private Coffee.CoffeeMemento memento;

    public AddMilkCommand(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void execute() {
        memento = coffee.createMemento(); // 保存当前状态
        coffee.setMilk(coffee.getMilk() + 1); // 执行命令
    }

    @Override
    public void undo() {
        coffee.restoreFromMemento(memento); // 撤销命令
    }
}
