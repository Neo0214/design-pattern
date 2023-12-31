package org.group11.Patterns.serviceLocator;
import org.group11.Patterns.Singleton.Reminder;
import org.group11.Patterns.Singleton.ReminderService;
import org.group11.Patterns.Decorator.LoggingReminderDecorator;
import org.group11.Entity.Borrow;
import java.util.List;

public class RemindReturnService implements Service {
    @Override
    public String getName() {
        return "RemindReturnService";
    }

    @Override
    public void execute(String... args) {
        System.out.println("Executing RemindReturnService");

        // 获取ReminderService的单例
        Reminder reminderService = ReminderService.getInstance();

        // 使用LoggingReminderDecorator装饰reminderService
        Reminder decoratedReminderService = new LoggingReminderDecorator(reminderService);

        // 解析用户ID
        int userId = Integer.parseInt(args[0]);

        // 通过装饰后的服务获取未归还的书籍列表
        List<Borrow> unreturnedBooks = decoratedReminderService.remind(userId);

        // 进一步处理unreturnedBooks，例如打印书籍信息
        for (Borrow book : unreturnedBooks) {
            System.out.println(book); // 假设Borrow类重写了toString方法
        }
    }
}
