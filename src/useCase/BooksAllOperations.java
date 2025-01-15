package useCase;

import model.Books;
import model.Users;
import service.BooksService;
import serviceImpl.BooksServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class BooksAllOperations {

    private BooksService booksService = new BooksServiceImpl();

    public void bookAllOperations(){
        Scanner scanner = new Scanner(System.in);
        // Create a BufferedReader instance
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n *****************************************************************\n");
        System.out.println("All the related operation you can perform here..");
        System.out.print("Click 1 for Get all Books Information \n" +
                "Click 2 for Get Specific book information \n" +
                "Click 3 for Register new book \n" +
                "Click 4 for delete the book \n" +
                "Click 5 for update the book's information \n"+
                "Click 6 for Get the book's information by Title \n"+
                "Click 7 for Get the book's information by Author name \n");

        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                System.out.println("You wants to see all the books information");
                booksService.getAllBooks();
                break;
            case 2:
                System.out.println("You wants to see specific the books information");
                System.out.print("Enter the book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int bookId = scanner.nextInt();
                booksService.getBookByBookId(bookId);
                break;
            case 3:
                //Title,Author,Genre,Quantity,Price,AddedDate
                System.out.println("You wants to register one more book");
                Books books = new Books();
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the Title of the book: ");
                String title = scanner.nextLine();
                books.setTitle(title);
                System.out.print("Enter the Author name of the book: ");
                String authorName = scanner.nextLine();
                books.setAuthor(authorName);
                System.out.print("Enter the Genre of the book: ");
                String genre = scanner.nextLine();
                books.setGenre(genre);
                System.out.print("Enter the quantity of the book: ");
                int quantity = scanner.nextInt();
                books.setQuantity(quantity);
                System.out.print("Enter the price of the book: ");
                double price = scanner.nextDouble();
                books.setPrice(price);
                //register the user
                booksService.registerNewBook(books);
                break;
            case 4:
//                SET Title=?, Author=?, Genre=?, Quantity=?, Price=? WHERE BookID=?
                System.out.println("You wants to delete the users information");
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the book Id: ");
                int id = scanner.nextInt();

                booksService.deleteBookByBookId(id);
                break;
            case 5:
                System.out.println("You wants to see update the book's information");
                Books updatedBook = new Books();
                System.out.print("Enter the book id: ");
                scanner.nextLine(); // Consume the newline character after nextInt()
                int updatedBookId = scanner.nextInt();
                updatedBook.setBookId(updatedBookId);
                System.out.print("Enter the Title of the book: ");
                String updatedTitle = scanner.nextLine();
                updatedBook.setTitle(updatedTitle);
                System.out.print("Enter the Author name of the book: ");
                String updatedAuthorName = scanner.nextLine();
                updatedBook.setAuthor(updatedAuthorName);
                System.out.print("Enter the Genre of the book: ");
                String updatedGenre = scanner.nextLine();
                updatedBook.setGenre(updatedGenre);
                System.out.print("Enter the quantity of the book: ");
                int updatedQuantity = scanner.nextInt();
                updatedBook.setQuantity(updatedQuantity);
                System.out.print("Enter the price of the book: ");
                double updatedPrice = scanner.nextDouble();
                updatedBook.setPrice(updatedPrice);

                //update
                booksService.updateBookInformation(updatedBook);
                break;
            case 6:
                System.out.println("You wants to see books information using the Title");
                System.out.print("Enter the book Title: ");
                String titlee = scanner.nextLine();
                booksService.getBookByBookTitle(titlee);
                break;
            case 7:
                System.out.println("You wants to see books information using Author name");
                System.out.print("Enter the book's Author name: ");
                String author = scanner.nextLine();
                booksService.getBookByBookAuthor(author);
                break;
            default:
                System.out.println("You have choose invalid option please re-try..");
                break;
        }

        System.out.println("\n *****************************************************************\n");

    }
}
