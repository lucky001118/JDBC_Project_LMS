package model;

import java.util.Date;

public class IssuedBooks {
    /*
    CREATE TABLE IssuedBooks (
    IssueID INT AUTO_INCREMENT PRIMARY KEY,
    BookID INT NOT NULL,
    UserID INT NOT NULL, -- Links to the Users table
    IssueDate DATE,
    DueDate DATE NOT NULL,
    ReturnDate DATE,
    FineAmount DECIMAL(10, 2) DEFAULT 0.00, -- Fine for the specific issuance
    IsReturned BOOLEAN DEFAULT FALSE, -- Indicates if the book is returned
    IsFinePaid BOOLEAN DEFAULT FALSE, -- Indicates if the fine is paid
    FOREIGN KEY (BookID) REFERENCES Books(BookID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);
     */
    private int issueID;
    private int bookID;
    private int userId;  //Links to the Users table
    private String issueDate ;
    private String dueDate ;  //when it is access to the user
    private String returnDate;  //last date to return the book
    private double fineAmount;
    private boolean isReturned;  //Indicates if the book is returned
    private boolean isFinePaid;  //Indicates if the fine is paid

    public int issueID() {
        return issueID;
    }

    public IssuedBooks setIssueID(int issueID) {
        this.issueID = issueID;
        return this;
    }

    public int bookID() {
        return bookID;
    }

    public IssuedBooks setBookID(int bookID) {
        this.bookID = bookID;
        return this;
    }

    public int userId() {
        return userId;
    }

    public IssuedBooks setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String issueDate() {
        return issueDate;
    }

    public IssuedBooks setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public String dueDate() {
        return dueDate;
    }

    public IssuedBooks setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String returnDate() {
        return returnDate;
    }

    public IssuedBooks setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public double fineAmount() {
        return fineAmount;
    }

    public IssuedBooks setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
        return this;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public IssuedBooks setReturned(boolean returned) {
        isReturned = returned;
        return this;
    }

    public boolean isFinePaid() {
        return isFinePaid;
    }

    public IssuedBooks setFinePaid(boolean finePaid) {
        isFinePaid = finePaid;
        return this;
    }
    public IssuedBooks(){

    }

    public IssuedBooks(int issueID, int bookID, int userId, String issueDate, String dueDate, String returnDate, double fineAmount, boolean isReturned, boolean isFinePaid) {
        this.issueID = issueID;
        this.bookID = bookID;
        this.userId = userId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
        this.isReturned = isReturned;
        this.isFinePaid = isFinePaid;
    }
}
