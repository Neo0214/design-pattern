package org.group11.Patterns.Mediator;

import org.group11.Patterns.DAO.UserPasswordMapper;
import org.group11.Patterns.abstractFactory.AbstractFactory;
import org.group11.Patterns.DAO.GiveBookMapper;
import org.group11.Patterns.DAO.Impl.UserPasswordImpl;
import org.group11.Patterns.Template.BookDonationTemplate;
import org.group11.Patterns.Template.UserBookDonation;
import org.group11.Tools.Input;

public class DonationMediator {
    private GiveBookMapper GiveBookMapper;

    public DonationMediator(AbstractFactory factory) {
        this.GiveBookMapper = factory.createGiveBookMapper();
    }

    public void handlePreDonation(int userId) {
        // 1. 验证用户
        System.out.println("请输入密码验证身份：");
        UserPasswordMapper UserPasswordMapper = new UserPasswordImpl();
        String password = Input.getInput();
       if (!UserPasswordMapper.checkPassword(userId,password)) {
            throw new IllegalArgumentException("密码错误");
        }
        // 2. 创建捐赠记录
        UserBookDonation BookDonation = new UserBookDonation();
        BookDonation.donateBook(userId);
        return;
    }
}
