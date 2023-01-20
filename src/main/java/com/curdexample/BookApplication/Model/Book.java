package com.curdexample.BookApplication.Model;

public class Book {
    private long isbnNo;
    private String  bookName;
    private String authorName;

    private int authorId;
    private int yearOfPublication;

    //Getter and setter
    public long getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(long isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Book(long isbnNo, String bookName, String authorName, int authorId, int yearOfPublication) {
        this.isbnNo = isbnNo;
        this.bookName = bookName;
        this.authorName = authorName;
        this.authorId = authorId;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNo=" + isbnNo +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorId=" + authorId +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }

    public  Book()
    {

    }
}
