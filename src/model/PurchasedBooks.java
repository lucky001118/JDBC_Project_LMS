package model;

import java.util.Date;

public class PurchasedBooks {

    /*
    CREATE TABLE PurchasedBooks (
    PurchaseID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    BookID INT NOT NULL,
    PurchaseDate DATE,
    Quantity INT NOT NULL,
    TotalPrice DECIMAL(10, 2),
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);
     */
    private int purchaseId;
    private int userId;
    private int bookId;
    private Date purchaseDate = new Date();
    private int quantity;
    private double totalPrice;

    public int purchaseId() {
        return purchaseId;
    }

    public PurchasedBooks setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
        return this;
    }

    public int userId() {
        return userId;
    }

    public PurchasedBooks setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int bookId() {
        return bookId;
    }

    public PurchasedBooks setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public Date purchaseDate() {
        return purchaseDate;
    }

    public PurchasedBooks setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public int quantity() {
        return quantity;
    }

    public PurchasedBooks setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double totalPrice() {
        return totalPrice;
    }

    public PurchasedBooks setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public PurchasedBooks(){

    }

    public PurchasedBooks(int purchaseId, int userId, int bookId, Date purchaseDate, int quantity, double totalPrice) {
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.bookId = bookId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
