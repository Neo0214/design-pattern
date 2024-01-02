package org.group11.Entity;

import org.group11.Tools.Input;

public class BookInfo {
    /*按照上面的内容填充bookinfo
    String BookName ;
    String Author ;
    String PublishDate ;*/
    private int BookId;
    private String BookName ;
    private String Author ;
    private String PublishDate ;
    public BookInfo(int BookId,String BookName,String Author,String PublishDate){
        this.BookName=BookName;
        this.Author=Author;
        this.PublishDate=PublishDate;
    }
    public int getBookId(){
        return BookId;
    }
}
