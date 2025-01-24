package model;

import java.time.LocalDate;
import java.util.Date;

public class Users {
    /*
    CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL, -- Store hashed passwords for security
    Name VARCHAR(255) NOT NULL,
    Role ENUM('Admin', 'Customer') NOT NULL,
    RegistrationDate DATE,
    MembershipStartDate DATE,
    MembershipEndDate DATE,
    Address TEXT,
    Phone VARCHAR(15),
    Active BOOLEAN DEFAULT TRUE, -- Indicates whether the user account is active
    TotalBooksIssued INT DEFAULT 0, -- Total books issued by the user
    TotalBooksReturned INT DEFAULT 0, -- Total books returned by the user
    PendingFine DECIMAL(10, 2) DEFAULT 0.00 -- Total pending fine for the user
);
     */
    private int userID;
    private String email;
    private String password;
    private String name;
    private Role role = Role.Customer;
    private String registrationDate ;
    private String membershipStartDate ;
    private String membershipEndDate ;
    private String address;
    private String phone;
    private boolean active;
    private int totalBooksIssued;
    private int totalBooksReturned;
    private double pendingFine;

    public int userID() {
        return userID;
    }

    public Users setUserID(int userID) {
        this.userID = userID;
        return this;
    }

    public String email() {
        return email;
    }

    public Users setEmail(String email) {
        this.email = email;
        return this;
    }

    public String password() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public String name() {
        return name;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
    }

    public Role role() {
        return role;
    }

    public Users setRole(Role role) {
        this.role = role;
        return this;
    }

    public String registrationDate() {
        return registrationDate;
    }

    public Users setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String membershipStartDate() {
        return membershipStartDate;
    }

    public Users setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
        return this;
    }

    public String membershipEndDate() {
        return membershipEndDate;
    }

    public Users setMembershipEndDate(String membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
        return this;
    }

    public String address() {
        return address;
    }

    public Users setAddress(String address) {
        this.address = address;
        return this;
    }

    public String phone() {
        return phone;
    }

    public Users setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public boolean active() {
        return active;
    }

    public Users setActive(boolean active) {
        this.active = active;
        return this;
    }

    public int totalBooksIssued() {
        return totalBooksIssued;
    }

    public Users setTotalBooksIssued(int totalBooksIssued) {
        this.totalBooksIssued = totalBooksIssued;
        return this;
    }

    public int totalBooksReturned() {
        return totalBooksReturned;
    }

    public Users setTotalBooksReturned(int totalBooksReturned) {
        this.totalBooksReturned = totalBooksReturned;
        return this;
    }

    public double pendingFine() {
        return pendingFine;
    }

    public Users setPendingFine(double pendingFine) {
        this.pendingFine = pendingFine;
        return this;
    }

    public Users(int userID, String email, String password, String name, Role role, String registrationDate, String membershipStartDate, String membershipEndDate, String address, String phone, boolean active, int totalBooksIssued, int totalBooksReturned, double pendingFine) {
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.registrationDate = registrationDate;
        this.membershipStartDate = membershipStartDate;
        this.membershipEndDate = membershipEndDate;
        this.address = address;
        this.phone = phone;
        this.active = active;
        this.totalBooksIssued = totalBooksIssued;
        this.totalBooksReturned = totalBooksReturned;
        this.pendingFine = pendingFine;
    }
    public Users(){

    }
}
