package org.group11.Patterns.Specification;

import org.group11.Patterns.DAO.Impl.BorrowImpl;

public class UnreturnedBooksSpecification implements ISpecification {
    // 判断用户是否有未归还的书籍
    public boolean isSatisfiedBy(int userId) {
        return new BorrowImpl().hasUnreturned(userId);
    }
}
