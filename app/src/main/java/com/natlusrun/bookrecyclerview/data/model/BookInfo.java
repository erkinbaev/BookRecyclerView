package com.natlusrun.bookrecyclerview.data.model;

public class BookInfo {

    private String book_name;
    private String book_author;
    private String book_description;

    public BookInfo(String book_name, String book_author, String book_description) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_description = book_description;
    }

    public BookInfo() {
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }
}
