package useCase;

public class WelcomePage {
    public void greed(){
        // Welcome Page
        System.out.println("========================================");
        System.out.println("   Welcome to the Library Management System   ");
        System.out.println("========================================");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Customer");
        System.out.println("3. Register as a New Customer");
        System.out.println("4. Exit");
        System.out.println("========================================");

        // About the project
        System.out.println("\n==============================================");
        System.out.println("           About This Project");
        System.out.println("==============================================");
        System.out.println("Project Name: Library Management System");
        System.out.println("Developed Using: Java, JDBC, MySQL");
        System.out.println("Key Features:");
        System.out.println("1. Admin Management (Add/Update/Remove Books).");
        System.out.println("2. Customer Features (Search/Issue/Return Books).");
        System.out.println("3. Authentication for Admin and Customers.");
        System.out.println("4. Fine Calculation for Late Returns.");
        System.out.println("Database Tables: Users, Books, IssuedBooks, PurchasedBooks.");
        System.out.println("==============================================");

        System.out.println("\n \n \n");
    }
}
