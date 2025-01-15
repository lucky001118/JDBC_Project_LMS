package useCase;

import model.Books;
import service.AllInfoService;
import serviceImpl.AllInfoServiceImpl;

import java.util.Scanner;

public class AllInfoAllOperations {
    private AllInfoService allInfoService = new AllInfoServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public void allInfoOperation(){
        System.out.println("\n *****************************************************************\n");
        System.out.println("All the related operation you can perform here..");
        System.out.print("Click 1 Get all the information about the specific user \n" +
                "Click 2 Get all the information about the specific book ");

        int choose = scanner.nextInt();
        switch (choose){
            case 1:
                scanner.nextLine();
                System.out.print("Enter the user name of the user that's info you want's to see: ");
                String userName = scanner.nextLine();
                allInfoService.AllInfoUsingUserName(userName);
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Enter the book name of the book, that info you want's to see: ");
                String bookName = scanner.nextLine();
                allInfoService.AllInfoUsingBookName(bookName);
                break;
            default:
                System.out.println("You have choose invalid option please re-try..");
                break;
        }

        System.out.println("\n *****************************************************************\n");
    }
}
