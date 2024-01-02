package org.group11.Patterns.Template;

import org.group11.Patterns.DAO.Impl.GiveBookImpl;
import org.group11.Tools.Input;
import org.group11.Entity.Book;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserBookDonation extends BookDonationTemplate {
    @Override
    protected Book createBook() {
        System.out.println("请输入书籍信息");
        System.out.println("书名：");
        String BookName = Input.getInput();
        System.out.println("作者：");
        String Author = Input.getInput();
        System.out.println("出版日期(yyyy-mm-dd)：");
        String PublishDate = Input.getInput();
        int BookId = new GiveBookImpl().AddBook(BookName, Author, PublishDate);
        Book book = new Book(BookId, BookName, Author, PublishDate);
        return book;
    }
    @Override
    protected  void createDonationRecord(int id, int BookId) {
        new  GiveBookImpl().GiveBookRecord(BookId,id);
        return;
    }
    @Override
    protected void updateBookBelongings(int BookId) {
        //提醒用户输入书架
        System.out.println("请选择书架（1-8）：");
        int BookShelfId = Integer.parseInt(Input.getInput());
        new GiveBookImpl().PutBook( BookId, BookShelfId);
        System.out.println("捐赠成功！");
        return;

    }
}
