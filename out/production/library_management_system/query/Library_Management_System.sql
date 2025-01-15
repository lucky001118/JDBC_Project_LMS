use anudeep_library_management_system;

show tables;

-- create user table
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

-- create book table
CREATE TABLE Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    Genre VARCHAR(100),
    Quantity INT DEFAULT 1, -- Tracks books available in the library
    Price DECIMAL(10, 2), -- For customers purchasing books
    AddedDate DATE 
);

-- creste IssuedBooks table
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

-- Tracks books purchased by customers.
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

-- Keeps a detailed record of fines, if needed separately.
CREATE TABLE Fines (
    FineID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    FineAmount DECIMAL(10, 2) NOT NULL,
    FineDate DATE,
    Paid BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- If you want more flexibility in role management:
CREATE TABLE Roles (
    RoleID INT AUTO_INCREMENT PRIMARY KEY,
    RoleName VARCHAR(50) UNIQUE NOT NULL
);

ALTER TABLE Users ADD COLUMN RoleID INT, 
ADD FOREIGN KEY (RoleID) REFERENCES Roles(RoleID);

-- description of the user table
DESC users;

-- inserts the values for testing purpouse
INSERT INTO Users (email, name, password, role,RegistrationDate, MembershipStartDate, MembershipEndDate)
VALUES
('admin@example.com', 'Admin User', 'AdminUser@1234' ,'Admin','2025-01-01', '2025-01-01', '2026-01-01'),
('customer@example.com', 'Customer User', 'CustomerUser@1234', 'Customer','2025-01-01', '2025-01-01', '2026-01-01');


INSERT INTO Users (Email, Password, Name, Role, RegistrationDate, MembershipStartDate, MembershipEndDate, Address, Phone, Active, TotalBooksIssued, TotalBooksReturned, PendingFine, RoleID) VALUES
('john.doe01@gmail.com', 'John@12345', 'Customer One', 'Customer', '2025-01-01', '2025-01-02', '2026-01-01', '123 Main St, City A', '1234567890', 1, 10, 8, 2.50, 2),
('jane.smith02@yahoo.com', 'Jane@12345', 'Customer Two', 'Customer', '2025-01-03', '2025-01-04', '2026-01-03', '456 Elm St, City B', '1234567891', 1, 15, 15, 0.00, 2),
('alex.jones03@hotmail.com', 'Alex@12345', 'Customer Three', 'Customer', '2025-01-05', '2025-01-06', '2026-01-05', '789 Pine St, City C', '1234567892', 1, 8, 7, 1.25, 2),
('emily.brown04@gmail.com', 'Emily@12345', 'Customer Four', 'Customer', '2025-01-07', '2025-01-08', '2026-01-07', '101 Maple St, City D', '1234567893', 1, 12, 10, 3.00, 2),
('michael.johnson05@yahoo.com', 'Michael@12345', 'Customer Five', 'Customer', '2025-01-09', '2025-01-10', '2026-01-09', '202 Oak St, City E', '1234567894', 1, 5, 4, 0.75, 2),
('sarah.wilson06@hotmail.com', 'Sarah@12345', 'Customer Six', 'Customer', '2025-01-11', '2025-01-12', '2026-01-11', '303 Birch St, City F', '1234567895', 1, 9, 9, 0.00, 2),
('chris.taylor07@gmail.com', 'Chris@12345', 'Customer Seven', 'Customer', '2025-01-13', '2025-01-14', '2026-01-13', '404 Cedar St, City G', '1234567896', 1, 6, 5, 1.00, 2),
('laura.martin08@yahoo.com', 'Laura@12345', 'Customer Eight', 'Customer', '2025-01-15', '2025-01-16', '2026-01-15', '505 Walnut St, City H', '1234567897', 1, 3, 2, 1.50, 2),
('david.lee09@hotmail.com', 'David@12345', 'Customer Nine', 'Customer', '2025-01-17', '2025-01-18', '2026-01-17', '606 Chestnut St, City I', '1234567898', 1, 7, 6, 0.75, 2),
('olivia.moore10@gmail.com', 'Olivia@12345', 'Customer Ten', 'Customer', '2025-01-19', '2025-01-20', '2026-01-19', '707 Ash St, City J', '1234567899', 1, 14, 14, 0.00, 2),
('daniel.white11@yahoo.com', 'Daniel@12345', 'Customer Eleven', 'Customer', '2025-01-21', '2025-01-22', '2026-01-21', '808 Poplar St, City K', '9876543210', 1, 11, 10, 2.25, 2),
('emma.hall12@hotmail.com', 'Emma@12345', 'Customer Twelve', 'Customer', '2025-01-23', '2025-01-24', '2026-01-23', '909 Spruce St, City L', '9876543211', 1, 8, 7, 0.50, 2),
('logan.young13@gmail.com', 'Logan@12345', 'Customer Thirteen', 'Customer', '2025-01-25', '2025-01-26', '2026-01-25', '100 Pinecone St, City M', '9876543212', 1, 4, 4, 0.00, 2),
('sophia.king14@yahoo.com', 'Sophia@12345', 'Customer Fourteen', 'Customer', '2025-01-27', '2025-01-28', '2026-01-27', '200 Redwood St, City N', '9876543213', 1, 6, 6, 0.00, 2),
('ryan.clark15@hotmail.com', 'Ryan@12345', 'Customer Fifteen', 'Customer', '2025-01-29', '2025-01-30', '2026-01-29', '300 Fir St, City O', '9876543214', 1, 5, 4, 1.75, 2),
('mia.scott16@gmail.com', 'Mia@12345', 'Customer Sixteen', 'Customer', '2025-02-01', '2025-02-02', '2026-02-01', '400 Magnolia St, City P', '9876543215', 1, 13, 12, 0.50, 2),
('lucas.wright17@yahoo.com', 'Lucas@12345', 'Customer Seventeen', 'Customer', '2025-02-03', '2025-02-04', '2026-02-03', '500 Hickory St, City Q', '9876543216', 1, 10, 9, 0.00, 2),
('grace.green18@hotmail.com', 'Grace@12345', 'Customer Eighteen', 'Customer', '2025-02-05', '2025-02-06', '2026-02-05', '600 Willow St, City R', '9876543217', 1, 7, 6, 1.00, 2),
('ethan.harris19@gmail.com', 'Ethan@12345', 'Customer Nineteen', 'Customer', '2025-02-07', '2025-02-08', '2026-02-07', '700 Mapleleaf St, City S', '9876543218', 1, 15, 15, 0.00, 2),
('ava.adams20@yahoo.com', 'Ava@12345', 'Customer Twenty', 'Customer', '2025-02-09', '2025-02-10', '2026-02-09', '800 Oakleaf St, City T', '9876543219', 1, 9, 8, 1.25, 2);


-- select all info from users
SELECT * FROM USERS;
DESC users;

-- inserting the demo testing values int the book table
INSERT INTO Books (title, author, genre, AddedDate, price)
VALUES
('Java Programming', 'James Gosling', 'Programming', '2015-05-10', 499.99),
('Effective Java', 'Joshua Bloch', 'Programming', '2018-11-10', 599.99),
('Database Management Systems', 'Raghu Ramakrishnan', 'Database', '2017-03-25', 799.99),
('Data Structures and Algorithms', 'Mark Allen Weiss', 'Computer Science', '2016-07-22', 450.50);

INSERT INTO Books (Title, Author, Genre, Quantity, Price, AddedDate) VALUES
('The Great Adventure', 'John Doe', 'Fiction', 10, 15.99, '2025-01-01'),
('Advanced Python Programming', 'Jane Smith', 'Technology', 5, 29.99, '2025-01-02'),
('Gardening Basics', 'Emily Green', 'Lifestyle', 7, 12.50, '2025-01-03'),
('Mystery of the Night', 'Arthur King', 'Mystery', 4, 19.99, '2025-01-04'),
('Cooking Made Easy', 'Julia Baker', 'Cooking', 8, 10.00, '2025-01-05'),
('Space Exploration', 'Neil Star', 'Science', 3, 25.99, '2025-01-06'),
('Financial Freedom', 'Mark Trader', 'Finance', 12, 18.75, '2025-01-07'),
('History of the World', 'George History', 'History', 6, 22.99, '2025-01-08'),
('The Art of Painting', 'Mona Lisa', 'Art', 9, 16.45, '2025-01-09'),
('Coding for Beginners', 'Alan Turing', 'Education', 15, 14.99, '2025-01-10'),
('Tales from the Future', 'Isaac Asimov', 'Sci-Fi', 11, 20.50, '2025-01-11'),
('Yoga and You', 'Patanjali Wisdom', 'Health', 7, 9.99, '2025-01-12'),
('The Startup Guide', 'Elon Enterprise', 'Business', 6, 30.00, '2025-01-13'),
('Mindfulness Techniques', 'Zen Master', 'Self-Help', 8, 17.50, '2025-01-14'),
('Deep Sea Mysteries', 'Marina Ocean', 'Adventure', 5, 18.20, '2025-01-15'),
('Poetry for the Soul', 'William Wordsworth', 'Poetry', 13, 12.75, '2025-01-16'),
('The Ultimate Guide to AI', 'Sophia Machine', 'Technology', 9, 35.99, '2025-01-17'),
('Desert Survival', 'Sahara Explorer', 'Adventure', 4, 15.00, '2025-01-18'),
('Guitar for Everyone', 'Jimi Hendrix', 'Music', 10, 25.00, '2025-01-19'),
('The Art of Meditation', 'Buddha Serenity', 'Spirituality', 6, 20.00, '2025-01-20'),
('Wildlife Photography', 'Ansel Wildlife', 'Photography', 3, 28.99, '2025-01-21'),
('Running for Health', 'Speedy Runner', 'Fitness', 8, 13.45, '2025-01-22'),
('The Quantum Universe', 'Brian Physics', 'Science', 7, 32.50, '2025-01-23'),
('Music Theory Simplified', 'Ludwig Composer', 'Music', 12, 14.20, '2025-01-24'),
('Exploring the Cosmos', 'Carl Universe', 'Sci-Fi', 5, 27.99, '2025-01-25'),
('Building Web Apps', 'Dev Coder', 'Education', 15, 24.99, '2025-01-26'),
('Mythology Unveiled', 'Zeus Chronicles', 'Mythology', 8, 18.30, '2025-01-27'),
('Urban Sketching', 'Sketchy Artist', 'Art', 6, 20.75, '2025-01-28'),
('Survival Hacks', 'Scout Adventurer', 'Adventure', 7, 11.99, '2025-01-29'),
('Baking for Beginners', 'Sweet Tooth', 'Cooking', 10, 9.99, '2025-01-30');


-- select all value from the books table
SELECT * FROM BOOKS;

-- IssuedBook table dummy values
INSERT INTO IssuedBooks (UserID,BookID, IssueDate, ReturnDate, DueDate, FineAmount, IsReturned)
VALUES
( 2, 1, '2025-01-05', '2025-01-12', '2025-01-12', 0, true),
( 2, 2, '2025-01-01', '2025-01-15', '2025-01-15', 0, true);


INSERT INTO issuedBooks (BookID, UserID, IssueDate, DueDate, ReturnDate, FineAmount, IsReturned, IsFinePaid) VALUES
(1, 24, '2024-12-10', '2024-12-24', '2024-12-20', 0.00, 1, 1),
(2, 30, '2024-12-05', '2024-12-19', '2024-12-18', 0.00, 1, 1),
(3, 25, '2024-11-25', '2024-12-09', '2024-12-06', 0.00, 1, 1),
(4, 28, '2024-12-01', '2024-12-15', '2024-12-10', 0.00, 1, 1),
(5, 27, '2024-12-07', '2024-12-21', NULL, 0.00, 0, 0),
(6, 35, '2024-12-03', '2024-12-17', '2024-12-15', 0.00, 1, 1),
(7, 34, '2024-12-08', '2024-12-22', NULL, 0.00, 0, 0),
(8, 36, '2024-11-28', '2024-12-12', '2024-12-10', 0.00, 1, 1),
(9, 33, '2024-12-02', '2024-12-16', '2024-12-15', 0.00, 1, 1),
(10, 38, '2024-12-04', '2024-12-18', NULL, 0.00, 0, 0),
(11, 33, '2024-11-29', '2024-12-13', '2024-12-12', 0.00, 1, 1),
(12, 32, '2024-12-06', '2024-12-20', NULL, 0.00, 0, 0),
(13, 37, '2024-12-09', '2024-12-23', '2024-12-20', 0.00, 1, 1),
(14, 29, '2024-11-30', '2024-12-14', '2024-12-12', 0.00, 1, 1),
(15, 31, '2024-12-03', '2024-12-17', '2024-12-16', 0.00, 1, 1),
(16, 36, '2024-12-02', '2024-12-16', NULL, 0.00, 0, 0),
(17, 24, '2024-11-25', '2024-12-09', NULL, 0.00, 0, 0),
(18, 35, '2024-12-01', '2024-12-15', NULL, 0.00, 0, 0),
(19, 37, '2024-11-29', '2024-12-13', '2024-12-10', 0.00, 1, 1),
(20, 33, '2024-12-02', '2024-12-16', NULL, 0.00, 0, 0);



-- select
	SELECT * FROM IssuedBooks;
    
desc purchasedbooks;

-- adding the dummy into the purched table
-- Inserting Dummy Data into Purchase Table
INSERT INTO purchasedbooks (UserID, BookID, PurchaseDate, Quantity, TotalPrice)
VALUES
(2, 1, '2025-01-10', 2, 999.98),
(2, 2, '2025-01-11', 1, 599.99),
(2, 3, '2025-01-12', 3, 2399.97),
(2, 4, '2025-01-13', 1, 450.50),
(2, 1, '2025-01-14', 1, 499.99),
(2, 3, '2025-01-15', 2, 1599.98);


INSERT INTO purchasedBooks (UserID, BookID, PurchaseDate, Quantity, TotalPrice) VALUES
(24, 1, '2025-01-01', 1, 499.99),
(25, 2, '2025-01-02', 1, 599.99),
(27, 3, '2025-01-03', 1, 799.99),
(28, 4, '2025-01-04', 2, 901.00),
(30, 5, '2025-01-05', 1, 15.99),
(32, 6, '2025-01-06', 3, 89.97),
(33, 7, '2025-01-07', 2, 25.00),
(34, 8, '2025-01-08', 1, 19.99),
(35, 9, '2025-01-09', 4, 40.00),
(36, 10, '2025-01-10', 2, 51.98),
(37, 11, '2025-01-11', 1, 18.75),
(38, 12, '2025-01-12', 1, 22.99),
(24, 13, '2025-01-13', 1, 16.45),
(25, 14, '2025-01-14', 3, 44.97),
(27, 15, '2025-01-15', 2, 41.00),
(28, 16, '2025-01-16', 1, 9.99),
(30, 17, '2025-01-17', 1, 30.00),
(32, 18, '2025-01-18', 2, 35.00),
(33, 19, '2025-01-19', 1, 18.20),
(34, 20, '2025-01-20', 2, 25.50),
(35, 21, '2025-01-21', 1, 35.99),
(36, 22, '2025-01-22', 3, 45.00),
(37, 23, '2025-01-23', 1, 25.00),
(38, 24, '2025-01-24', 2, 40.00),
(24, 25, '2025-01-25', 1, 28.99),
(25, 26, '2025-01-26', 1, 13.45),
(27, 27, '2025-01-27', 1, 32.50),
(28, 28, '2025-01-28', 2, 28.40),
(30, 29, '2025-01-29', 1, 27.99),
(32, 30, '2025-01-30', 3, 74.97);


-- select op for it
SELECT * FROM purchasedbooks;

SELECT * from Users WHERE Email='admin@example.com';

SELECT * from Users WHERE UserID=1;

INSERT INTO Roles (RoleID, RoleName) VALUES
(1, 'Admin'),
(2, 'Customer');

INSERT INTO fines (UserID, FineAmount, FineDate, Paid) VALUES
(30, 9.39, '2024-03-07', 0),
(36, 2.99, '2024-02-08', 0),
(24, 5.06, '2024-06-14', 1),
(25, 6.10, '2024-04-11', 0),
(39, 7.32, '2024-07-01', 1),
(27, 8.67, '2024-05-10', 1),
(33, 0.88, '2024-12-29', 0),
(35, 4.90, '2024-06-10', 1),
(41, 6.45, '2025-01-10', 1),
(37, 6.83, '2024-08-09', 0),
(23, 6.44, '2024-07-19', 1),
(34, 4.04, '2024-10-12', 0),
(28, 8.72, '2024-03-04', 0),
(38, 7.96, '2025-01-09', 0),
(24, 4.35, '2024-02-01', 0),
(33, 9.94, '2024-02-07', 0),
(35, 7.55, '2024-09-19', 0),
(38, 5.64, '2024-07-08', 1),
(36, 8.35, '2024-02-04', 0),
(30, 5.54, '2024-01-30', 0),
(28, 1.92, '2024-11-19', 1),
(25, 6.14, '2024-08-15', 1),
(32, 4.99, '2024-02-15', 1),
(29, 3.98, '2024-12-02', 0),
(33, 4.62, '2024-06-17', 1);

SELECT 
    u.UserID,
    u.Name AS UserName,
    u.Email,
    u.Role,
    u.RegistrationDate,
    u.MembershipStartDate,
    u.MembershipEndDate,
    u.Address,
    u.Phone,
    u.TotalBooksIssued,
    u.TotalBooksReturned,
    u.PendingFine,
    ib.IssueID,
    ib.BookID AS IssuedBookID,
    b1.Title AS IssuedBookTitle,
    ib.IssueDate,
    ib.DueDate,
    ib.ReturnDate,
    ib.FineAmount,
    ib.IsReturned,
    pb.PurchaseID,
    pb.BookID AS PurchasedBookID,
    b2.Title AS PurchasedBookTitle,
    pb.PurchaseDate,
    pb.Quantity AS PurchasedQuantity,
    pb.TotalPrice
FROM 
    users u
LEFT JOIN 
    issuedbooks ib ON u.UserID = ib.UserID
LEFT JOIN 
    books b1 ON ib.BookID = b1.BookID
LEFT JOIN 
    purchasedbooks pb ON u.UserID = pb.UserID
LEFT JOIN 
    books b2 ON pb.BookID = b2.BookID
WHERE 
    u.Name = 'Customer Five';

