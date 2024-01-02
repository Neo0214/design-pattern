package org.group11.Patterns.DAO;

public interface GiveBookMapper {
    //新增图书记录
    public int AddBook(String BookName,String Author,String PublishDate);
    public boolean GiveBookRecord(int bookId,int userId);
    public boolean PutBook(int bookId,int bookShelfId);
}
