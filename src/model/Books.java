package model;

import java.util.Date;

public class Books {
    /*
    CREATE TABLE Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    Genre VARCHAR(100),
    Quantity INT DEFAULT 1, -- Tracks books available in the library
    Price DECIMAL(10, 2), -- For customers purchasing books
    AddedDate DATE
);
     */
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private int quantity;
    private double price; //For customers purchasing books only
    private Date addedDate = new Date();  //book added into library date

    public int bookId() {
        return bookId;
    }

    public Books setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public String title() {
        return title;
    }

    public Books setTitle(String title) {
        this.title = title;
        return this;
    }

    public String author() {
        return author;
    }

    public Books setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String genre() {
        return genre;
    }

    public Books setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public int quantity() {
        return quantity;
    }

    public Books setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double price() {
        return price;
    }

    public Books setPrice(double price) {
        this.price = price;
        return this;
    }

    public Date addedDate() {
        return addedDate;
    }

    public Books setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
        return this;
    }

    public Books(int bookId, String title, String author, String genre, int quantity, double price, Date addedDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
        this.addedDate = addedDate;
    }

    public Books(){

    }

}
