/*
 * @author umer-wn
 */
package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Builder.Coffee;
import org.group11.Patterns.simpleFactory.CoffeeFactory;
import org.group11.Patterns.Adapter.MyPayment;
import org.group11.Patterns.Strategy.WechatPayment;
import org.group11.Patterns.Adapter.AliPayment;
import org.group11.Patterns.Adapter.CardPayment;
import org.group11.Patterns.Command.CoffeeCommand;
import org.group11.Patterns.Command.CoffeeMaker;
import org.group11.Patterns.Command.AddEspressoCommand;
import org.group11.Patterns.Command.AddMilkCommand;
import org.group11.Patterns.Command.AddMilkForthCommand;
import org.group11.Patterns.Command.AddCocoaCommand;
import org.group11.Tools.Input;


public class OrderCoffeeService implements Service{
    @Override
    public String getName() {
        return "OrderCoffeeService";
    }

    @Override
    public void execute(String... args) {
        Boolean isValid = false;
        String input = "";
        //创建订单-工厂模式and建造者模式
        while (!isValid) {
            System.out.println("请输入想要的咖啡种类（1-3）");
            System.out.println("1.美式咖啡");
            System.out.println("2.拿铁咖啡");
            System.out.println("3.卡布奇诺咖啡");
            input = Input.getInput();
            if (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                System.out.println("咖啡种类错误，重新输入");
            } else {
                isValid = true;
            }
        }
        Coffee coffee= CoffeeFactory.createCoffee(input);

        System.out.println("您的咖啡需要额外添加配料吗？（y/任意键）");
        input = Input.getInput();
        //添加配料-命令模式and备忘录模式
        isValid = false;
        if (input.equals("y")||input.equals("Y")) {
            isValid = false;
            boolean added = false;
            CoffeeCommand lastCommand = null;
            while (!isValid) {
                System.out.println("请输入想要的配料种类（1-4）");
                System.out.println("1.浓缩咖啡");
                System.out.println("2.牛奶");
                System.out.println("3.奶泡");
                System.out.println("4.可可粉");
                System.out.println("5.配料足够");
                if (added) {
                    System.out.println("6.撤销上步操作");
                }
                added = true;

                CoffeeMaker maker = new CoffeeMaker();

                input = Input.getInput();
                if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")
                        && !input.equals("5") && !input.equals("6")) {
                    System.out.println("输入错误，重新输入");
                } else if (input.equals("1")) {
                    CoffeeCommand addEspresso = new AddEspressoCommand(coffee);
                    maker.setCommand(addEspresso);
                    lastCommand = addEspresso;
                    maker.modifyCoffee();
                } else if (input.equals("2")) {
                    CoffeeCommand addMilk = new AddMilkCommand(coffee);
                    maker.setCommand(addMilk);
                    lastCommand = addMilk;
                    maker.modifyCoffee();
                } else if (input.equals("3")) {
                    CoffeeCommand addMilkForth = new AddMilkForthCommand(coffee);
                    maker.setCommand(addMilkForth);
                    lastCommand = addMilkForth;
                    maker.modifyCoffee();
                } else if (input.equals("4")) {
                    CoffeeCommand addCocoa = new AddCocoaCommand(coffee);
                    maker.setCommand(addCocoa);
                    lastCommand = addCocoa;
                    maker.modifyCoffee();
                } else if (input.equals("5")) {
                    isValid = true;
                } else if (input.equals("6")) {
                    maker.setCommand(lastCommand);
                    maker.undoModification();
                }
            }
        }
        System.out.println("您的咖啡已经制作完成，包括浓缩咖啡" +coffee.getEspresso()+"份，牛奶"+coffee.getMilk()+"份，奶泡"+coffee.getMilkForth()+"份，可可粉"+coffee.getCocoa()+"份");
        System.out.println("总价为"+coffee.getPrice()+"元");
        isValid = false;


        //支付方式-策略模式
        while (!isValid) {
            System.out.println("请选择支付方式（1-3）");
            System.out.println("1.支付宝");
            System.out.println("2.微信");
            System.out.println("3.信用卡");
            String paymentType=Input.getInput();
            if (paymentType.equals("1") || paymentType.equals("2") || paymentType.equals("3")) {
                isValid = true;
                if (paymentType.equals("1")) {
                    MyPayment payment = new MyPayment(new AliPayment());
                    payment.Payment(coffee.getPrice());
                } else if (paymentType.equals("2")) {
                    MyPayment payment = new MyPayment(new WechatPayment());
                    payment.Payment(coffee.getPrice());
                } else if (paymentType.equals("3")) {
                    MyPayment payment = new MyPayment(new CardPayment());
                    payment.Payment(coffee.getPrice());
                }
            } else {
                System.out.println("支付方式错误，重新输入");
            }
        }

    }
}
