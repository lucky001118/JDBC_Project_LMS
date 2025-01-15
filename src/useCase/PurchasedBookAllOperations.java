package useCase;

import exceptions.PurchasedBookException;
import model.IssuedBooks;
import model.PurchasedBooks;
import service.PurchasedBookService;
import serviceImpl.PurchasedBookServiceImpl;

import java.util.Scanner;

public class PurchasedBookAllOperations {

    private PurchasedBookService purchasedBookService = new PurchasedBookServiceImpl();

    public void purchasedBookAllOperations() throws PurchasedBookException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n *****************************************************************\n");
        System.out.println("All the related operation you can perform here..");
        System.out.print("Click 1 for Get all purchased Books Information \n" +
                "Click 2 for Get Specific purchased book information \n" +
                "Click 3 for Register new purchased book \n" +
                "Click 4 for delete the purchased book \n" +
                "Click 5 for update the purchased book's information ");

        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                System.out.println("You wants to see all the purchased books information");
                purchasedBookService.getAllPurchasedBooks();
                break;
            case 2:
                System.out.println("You wants to see specific the purchased books information");
                System.out.print("Enter the purchased book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int purchasedBookId = scanner.nextInt();
                purchasedBookService.getPurchasedBookById(purchasedBookId);
                break;
            case 3:
                //UserID,BookID,PurchaseDate,Quantity,TotalPrice
                System.out.println("You wants to register one more purchased book");
                PurchasedBooks purchasedBooks = new PurchasedBooks();
                scanner.nextLine(); // Consume the newline character after nextInt()

                System.out.print("Enter the id of the book: ");
                int id = scanner.nextInt();
                purchasedBooks.setBookId(id);
                System.out.print("Enter the user id that book is purchased to the persion: ");
                int userId = scanner.nextInt();
                purchasedBooks.setUserId(userId);
                System.out.print("Enter the quantity of book that going to purchase: ");
                int quantity = scanner.nextInt();
                purchasedBooks.setQuantity(quantity);
                System.out.print("Enter the total price of the purchasable books: ");
                double price = scanner.nextDouble();
                purchasedBooks.setTotalPrice(price);

                //register the issued book
                purchasedBookService.registerPurchasedBook(purchasedBooks);
                break;
            case 4:
                System.out.println("You wants to delete the purchased book's information");
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the purchased book Id: ");
                int purchasedBookIdd = scanner.nextInt();

                purchasedBookService.deletePurchasedBook(purchasedBookIdd);
                break;
            case 5:
                //SET UserID = ?, BookID = ?, PurchaseDate=?, Quantity=?, TotalPrice=? WHERE PurchaseID = ?
                System.out.println("You wants to update the purchased book's information");
                PurchasedBooks updatedPurchasedBooks = new PurchasedBooks();

                System.out.print("Enter the purchased book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int updatedPurchasedBookId = scanner.nextInt();
                updatedPurchasedBooks.setPurchaseId(updatedPurchasedBookId);
                System.out.print("Enter the book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int updatedBookId = scanner.nextInt();
                updatedPurchasedBooks.setBookId(updatedBookId);
                System.out.print("Enter the user id: ");
                int updatedUserId = scanner.nextInt();
                updatedPurchasedBooks.setUserId(updatedUserId);

                System.out.print("Enter the quantity of purchased book: ");
                int updatedPurchasedBookQuantity = scanner.nextInt();
                updatedPurchasedBooks.setQuantity(updatedPurchasedBookQuantity);

                System.out.print("Enter the total price of the purchased book: ");
                double updateFineAmount = scanner.nextDouble();
                updatedPurchasedBooks.setTotalPrice(updateFineAmount);

                //update
                purchasedBookService.updatePurchaseBookDetails(updatedPurchasedBooks);
                break;
            default:
                System.out.println("You have choose invalid option please re-try..");
                break;
        }

        System.out.println("\n *****************************************************************\n");
    }
}
