package org.group11.Patterns.Singleton;

import java.time.LocalDate;
import java.util.List;

import org.group11.Entity.Borrow;
import org.group11.Patterns.DAO.Impl.ReminderMapperImpl;
import org.group11.Patterns.State.ApproachingReturnDateState;
import org.group11.Patterns.State.BorrowState;
import org.group11.Patterns.State.OverdueState;



public class ReminderService implements Reminder {
    // 使用 volatile 关键字确保多线程环境下的可见性和有序性
    private static volatile ReminderService instance;

    public ReminderService() {
        // 私有构造函数，防止外部通过 new 创建多个实例
    }

    public static ReminderService getInstance() {
        // 双重检查锁定（Double-Checked Locking）
        if (instance == null) {
            synchronized (ReminderService.class) {
                if (instance == null) {
                    instance = new ReminderService();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Borrow> remind(int userId) {
        // 实现提醒的具体逻辑
        List<Borrow> borrowList = new ReminderMapperImpl().selectUnreturnedBooks(userId);
        Reminder decoratedReminder = this; // 创建 Reminder 的装饰版本，需要实现这个类

        for (Borrow borrow : borrowList) {
            BorrowState state = determineState(borrow); // 实现 determineState 方法来确定状态
            state.sendReminder(userId, decoratedReminder); // 使用状态发送提醒
        }
        return(new ReminderMapperImpl().selectUnreturnedBooks(userId));
    }

    private BorrowState determineState(Borrow borrow) {
        LocalDate returnDate = LocalDate.parse(borrow.getReturn_Time());
        LocalDate now = LocalDate.now();

        if (returnDate.isBefore(now)) {
            return new OverdueState();
        } else if (returnDate.minusDays(3).isAfter(now)) {
            return new ApproachingReturnDateState();
        } else {
            return new ApproachingReturnDateState();
        }
    }
}