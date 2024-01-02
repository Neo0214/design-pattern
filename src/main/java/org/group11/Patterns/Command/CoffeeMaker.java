package org.group11.Patterns.Command;

public class CoffeeMaker {
    private CoffeeCommand command;

    public void setCommand(CoffeeCommand command) {
        this.command = command;
    }

    public void modifyCoffee() {
        command.execute();
    }

    public void undoModification() {
        command.undo();
    }
}
