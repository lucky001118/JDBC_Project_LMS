package model;

import java.util.Date;

public class Fines {
    /*
    CREATE TABLE Fines (
    FineID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    FineAmount DECIMAL(10, 2) NOT NULL,
    FineDate DATE,
    Paid BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);
     */
    private int fineId;
    private int userId;
    private double fineAmount;
    private Date fineDate;
    private boolean paid;
}
