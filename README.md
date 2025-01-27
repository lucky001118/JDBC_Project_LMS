# Library Management System

This project is a **Library Management System** built using Java and JDBC (Java Database Connectivity). It allows users to manage a library's books, members, and transactions. The system is designed for small to medium-sized libraries and ensures efficient tracking of books and borrowing activities.

---
## Flow Digram of Library Management System

![image alt](https://github.com/lucky001118/JDBC_Project_LMS/blob/main/LMS.drawio.png?raw=true)
---

## Features

- **Book Management**: Add, update, delete, and search for books.
- **Member Management**: Register new members, update member details, and view member information.
- **Borrow and Return Books**: Manage the borrowing and returning process with automated due date calculations.
- **Transaction History**: View and log all borrowing and returning activities.
- **Search Functionality**: Search for books and members using various filters (e.g., title, author, ID).
- **Database Integration**: Uses MySQL as the backend database for secure and efficient data storage.

---

## ER Diagram

The following diagram represents the **Entity-Relationship (ER) Model** for the Library Management System. It shows the structure of the database, including entities, attributes, and their relationships.
![image alt](https://github.com/lucky001118/JDBC_Project_LMS/blob/bdddd8370196671c526a4f0856840bd68e8d92b4/Screenshot%20(241).png)

---

## Technologies Used

- **Java**: Core application logic.
- **JDBC**: For database connectivity and query execution.
- **MySQL**: Backend database for storing library data.
- **IDE**: Developed using IntelliJ IDEA/Eclipse.

---

## Prerequisites

Before running the project, ensure you have the following installed on your system:

- **Java Development Kit (JDK)** (version 8 or higher)
- **MySQL Database**
- **JDBC Driver for MySQL** (e.g., `mysql-connector-java`)

---

## Installation and Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
   ```

2. **Set Up the Database**
   - Create a MySQL database named `library_management`.
   - Execute the SQL script provided in the `database` directory to create tables and populate initial data.

3. **Configure Database Connection**
   - Update the `DBConnection.java` file with your MySQL credentials:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/library_management";
     private static final String USER = "your-username";
     private static final String PASSWORD = "your-password";
     ```

4. **Run the Application**
   - Compile and run the main class:
     ```bash
     javac Main.java
     java Main
     ```
     
---

## Project Structure

```
library-management-system/
├── src/
│   ├── model/            # Data models for Books, Members, etc.
│   ├── service/          # Business logic and services
│   ├── dao/              # Data Access Objects for database operations
│   ├── util/             # Utility classes (e.g., DBConnection)
│   └── Main.java         # Entry point of the application
├── database/
│   ├── library_management.sql # SQL script for database setup
├── README.md             # Documentation
└── LICENSE               # License file
```

---

## Usage

1. **Adding Books**: Add new books to the library collection.
2. **Registering Members**: Register new library members with their details.
3. **Borrowing and Returning**: Handle borrowing and returning books with automated fine calculation (if any).
4. **View Reports**: Generate and view transaction history and reports.

---

## Contributing

Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request.

---

## Acknowledgments

- Thanks to the open-source community for tools and resources.
- Inspired by the need to digitize library operations efficiently.

---

## Contact

For any queries or issues, please feel free to contact:
- **Name**: Lucky Manikpur
- **Email**: [manikpurilucky218@gmail.com]
```
