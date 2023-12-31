package org.group11.Entity;

public class Borrow {
    private int book_Id;
    private int Id;
    private String borrow_Condition;
    private String borrow_Time;
    private String return_Time;
    public int getBook_Id() {
        return book_Id;
    }
    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getBorrow_Condition() {
        return borrow_Condition;
    }
    public void setBorrow_Condition(String borrow_Condition) {
        this.borrow_Condition = borrow_Condition;
    }
    public String getBorrow_Time() {
        return borrow_Time;
    }
    public void setBorrow_Time(String borrow_Time) {
        this.borrow_Time = borrow_Time;
    }
    public String getReturn_Time() {
        return return_Time;
    }
    public void setReturn_Time(String return_Time) {
        this.return_Time = return_Time;
    }
    @Override
    public String toString() {
        return "Borrow [Id=" + Id + ", book_Id=" + book_Id + ", borrow_Condition=" + borrow_Condition
                + ", borrow_Time=" + borrow_Time + ", return_Time=" + return_Time + "]";
    }
}
