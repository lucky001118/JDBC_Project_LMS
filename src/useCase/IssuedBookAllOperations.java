package useCase;

import exceptions.BookIssueException;
import model.IssuedBooks;
import service.IssuedBookService;
import serviceImpl.IssuedBookServiceImpl;

import java.util.Scanner;

public class IssuedBookAllOperations {

    private IssuedBookService issuedBookService = new IssuedBookServiceImpl();
    public void issuedBookAllOperation() throws BookIssueException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n *****************************************************************\n");
        System.out.println("All the related operation you can perform here..");
        System.out.print("Click 1 for Get all issued Books Information \n" +
                "Click 2 for Get Specific issued book information \n" +
                "Click 3 for Register new issued book \n" +
                "Click 4 for delete the issued book \n" +
                "Click 5 for update the issued book's information ");

        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                System.out.println("You wants to see all the books information");
                issuedBookService.getAllIssuedBooks();
                break;
            case 2:
                System.out.println("You wants to see specific the issued books information");
                System.out.print("Enter the book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int issuedBookId = scanner.nextInt();
                issuedBookService.getTheIssuedBookByID(issuedBookId);
                break;
            case 3:
                //BookID,UserID,IssueDate,DueDate,ReturnDate
                System.out.println("You wants to register one more issued book");
                IssuedBooks issuedBooks = new IssuedBooks();
                scanner.nextLine(); // Consume the newline character after nextInt()

                System.out.print("Enter the id of the book: ");
                int id = scanner.nextInt();
                issuedBooks.setBookID(id);
                System.out.print("Enter the user id that book is given to the persion: ");
                int userId = scanner.nextInt();
                issuedBooks.setUserId(userId);

                //register the issued book
                issuedBookService.issueBook(issuedBooks);
                break;
            case 4:
                System.out.println("You wants to delete the issued book's information");
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the issued book Id: ");
                int bookId = scanner.nextInt();

                issuedBookService.removeIssuedBook(bookId);
                break;
            case 5:
                //SET BookID = ?, UserID=?, IssueDate=?, DueDate=?, ReturnDate=?, FineAmount=?, IsReturned=?, IsFinePaid=? WHERE  IssueID=?
                System.out.println("You wants to update the issued book's information");
                IssuedBooks updateIssuedBooks = new IssuedBooks();

                System.out.print("Enter the book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int updatedIssuedBookId = scanner.nextInt();
                updateIssuedBooks.setIssueID(updatedIssuedBookId);
                System.out.print("Enter the id of the book: ");
                int updatedBookId = scanner.nextInt();
                updateIssuedBooks.setBookID(updatedBookId);
                System.out.print("Enter the id of the user: ");
                int updatedUserId = scanner.nextInt();
                updateIssuedBooks.setUserId(updatedUserId);

                System.out.print("Enter the fine amount in the book for late submission: ");
                double updateFineAount = scanner.nextDouble();
                updateIssuedBooks.setFineAmount(updateFineAount);
                System.out.print("Enter the 'true' if book is returened else 'false': ");
                boolean updatedIsReturned = scanner.nextBoolean();
                updateIssuedBooks.setReturned(updatedIsReturned);
                System.out.print("Enter the 'true' if fine is paid else 'false': ");
                boolean updateIsPaid = scanner.nextBoolean();
                updateIssuedBooks.setFinePaid(updateIsPaid);

                //update
                issuedBookService.updateIssuedBookInformation(updateIssuedBooks);
                break;
            default:
                System.out.println("You have choose invalid option please re-try..");
                break;
        }

        System.out.println("\n *****************************************************************\n");
    }
}
