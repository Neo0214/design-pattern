package org.group11.Entity;

public class Book {
    //包括编号、书名、作者、出版时间
    private int bookId;
    private String bookName;
    private String author;
    public Book(int bookId,String bookName,String author,String publishDate){
        this.bookId=bookId;
        this.bookName=bookName;
        this.author=author;
        this.publishDate=publishDate;
    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    private String publishDate;
}
