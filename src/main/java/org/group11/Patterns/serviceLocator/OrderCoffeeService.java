/*
 * @author umer-wn
 */
package org.group11.Patterns.serviceLocator;

import org.group11.Patterns.Builder.Coffee;
import org.group11.Patterns.simpleFactory.CoffeeFactory;
import org.group11.Patterns.Strategy.Payment;
import org.group11.Tools.Input;

public class OrderCoffeeService implements Service{
    @Override
    public String getName() {
        return "OrderCoffeeService";
    }

    @Override
    public void execute(String... args) {
        System.out.println("请输入想要的咖啡种类（1-3）");
        System.out.println("1.美式咖啡");
        System.out.println("2.拿铁咖啡");
        System.out.println("3.卡布奇诺咖啡");
        String coffeeType= Input.getInput();
        if(!coffeeType.equals("1")&&!coffeeType.equals("2")&&!coffeeType.equals("3")){
            System.out.println("咖啡种类不足");
            return;
        }
        Coffee coffee= CoffeeFactory.createCoffee(coffeeType);
        System.out.println("您的咖啡需要额外添加配料吗？（y/n）");
        System.out.println("您的咖啡已经制作完成，总价为"+coffee.getPrice()+"元");
        System.out.println("请选择支付方式（1-3）");
        System.out.println("1.支付宝");
        System.out.println("2.微信");
        System.out.println("3.信用卡");
        String paymentType=Input.getInput();
        Payment payment=Payment
        if (proxy.returnBook(Integer.parseInt(bookId),Integer.parseInt(args[0]))){
            System.out.println("还书成功");
        }
        else{
            System.out.println("还书失败");
        }
    }
}
