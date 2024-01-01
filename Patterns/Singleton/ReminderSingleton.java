package org.group11.Patterns.Singleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.group11.Entity.Borrow;
import org.group11.Patterns.DAO.Impl.ReminderMapperImpl;
import org.group11.Patterns.State.ApproachingReturnDateState;
import org.group11.Patterns.State.BorrowState;
import org.group11.Patterns.State.NormalState;
import org.group11.Patterns.State.OverdueState;



public class ReminderSingleton implements Reminder {
    // 使用 volatile 关键字确保多线程环境下的可见性和有序性
    private static volatile ReminderSingleton instance;

    public ReminderSingleton() {
        
    }

    public static ReminderSingleton getInstance() {
        // 双重检查锁定（Double-Checked Locking）
        if (instance == null) {
            synchronized (ReminderSingleton.class) {
                if (instance == null) {
                    instance = new ReminderSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Borrow> remind(int userId) {
        // 实现提醒的具体逻辑
        List<Borrow> borrowList = new ReminderMapperImpl().selectUnreturnedBooks(userId);
        //Reminder decoratedReminder = this; // 创建 Reminder 的装饰版本，需要实现这个类

        for (Borrow borrow : borrowList) {
            BorrowState state = determineState(borrow); // 实现 determineState 方法来确定状态
            state.sendReminder(borrow); // 使用状态发送提醒
        }
        return(borrowList);
    }

    private BorrowState determineState(Borrow borrow) {
        //LocalDate returnDate = LocalDate.parse(borrow.getReturn_Time());
        
        String returnTimeStr = borrow.getReturn_Time();
        if (returnTimeStr == null || returnTimeStr.trim().isEmpty()) {
            return new NormalState(); // 如果日期为空，返回一个默认状态
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate returnDate;
        try {
            returnDate = LocalDate.parse(returnTimeStr, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing return date: " + returnTimeStr);
            return new NormalState(); // 解析错误时返回默认状态
        }

        LocalDate now = LocalDate.now();
        if (returnDate.isBefore(now)) {
            return new OverdueState();
        } else if (returnDate.minusDays(3).isAfter(now)) {
            return new ApproachingReturnDateState();
        } else {
            return new NormalState();
        }
    }
}