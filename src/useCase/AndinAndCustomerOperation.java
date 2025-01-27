package useCase;

import exceptions.BookException;
import exceptions.BookIssueException;
import exceptions.PurchasedBookException;
import exceptions.UserException;
import model.LoginPage;
import service.AllInfoService;
import service.UserService;
import serviceImpl.AllInfoServiceImpl;
import serviceImpl.UserServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class AndinAndCustomerOperation {

    private LoginOperation loginOperation;
    private AllInfoService allInfoService = new AllInfoServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void AdminAndCustomerOperations() throws UserException, IOException, BookIssueException, PurchasedBookException, BookException {

        //welcome us
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.greed();


        loginOperation = new LoginOperation();
        System.out.println("************************************************************************************");
        System.out.println("Login Process! please enter your credentials");
        System.out.println("************************************************************************************ \n");
        System.out.print("Enter your Email Id: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password Id: ");
        String password = scanner.nextLine();
        LoginPage login = loginOperation.doLogin(email,password);

        //login process done here...

        //start loop here
        while(true){

        if (login.ResponseRole().equals("Admin")){
            System.out.println("\n*****************************************************************\n");
            System.out.print("Click 1 for Get Information related to users \n" +
                    "Click 2 for Get information related to Book records \n" +
                    "Click 3 for Get  information related to issued books \n" +
                    "Click 4 for Get information related to purchased books records \n"+
                    "Click 5 for Get information related to Extra information ");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("You wants to see user's related records");
                    UsersAllOperation usersAllOperation = new UsersAllOperation();
                    usersAllOperation.userAllOperations();
                    break;
                case 2:
                    System.out.println("You wants to see Book's related records");
                    BooksAllOperations booksAllOperations = new BooksAllOperations();
                    booksAllOperations.bookAllOperations();
                    break;
                case 3:
                    System.out.println("You wants to see issued book's related recode");
                    IssuedBookAllOperations issuedBookAllOperations = new IssuedBookAllOperations();
                    issuedBookAllOperations.issuedBookAllOperation();
                    break;
                case 4:
                    System.out.println("You wants to see purchased book's related records");
                    PurchasedBookAllOperations purchasedBookAllOperations = new PurchasedBookAllOperations();
                    purchasedBookAllOperations.purchasedBookAllOperations();
                    break;
                case 5:
                    System.out.println("You wants to see extra info related records");
                    AllInfoAllOperations allInfoAllOperations = new AllInfoAllOperations();
                    allInfoAllOperations.allInfoOperation();
                    break;
                default:
                    System.out.println("You have choose invalid option please re-try..");
                    break;
            }

            System.out.println("\n*****************************************************************\n");

        }else {
            UserService userService = new UserServiceImpl();
            System.out.println("\n*****************************************************************\n");
            System.out.print("Click 1 for Get Your Information \n" +
                    "Click 2 for Get Book records \n" +
                    "Click 3 for Get yor issued books recode \n" +
                    "Click 4 for Get your purchased books records \n" +
                    "Click 5 to see your all the records in one table ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("You wants to your Information");
                    System.out.print("Enter the user's id: ");
                    int userId = scanner.nextInt();
                    userService.getUserByUserID(userId);
                    break;
                case 2:
                    System.out.println("You wants to see your Book records");
                    break;
                case 3:
                    System.out.println("You wants to see yor issued books recode");
                    break;
                case 4:
                    System.out.println("You wants to see your purchased books records");
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("You wants to see your all records");
                    allInfoService.AllInfoUsingUserName(login.ResponseName());
                    break;
                default:
                    System.out.println("You have choose invalid option please re-try..");
                    break;
            }


        }
            System.out.println("\n*****************************************************************\n");


            //condition for loop
            scanner.nextLine();

            System.out.println("-----------------------------------------------------------");
            System.out.print("Exit or Menu: ");
            String list = scanner.nextLine();
            System.out.println("-----------------------------------------------------------");
            System.out.println();

            if (list.equalsIgnoreCase("exit")){
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println("Thanks for using the LMS, have a nice day!");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                break;
            } else if (list.equalsIgnoreCase("menu")) {
                continue;
            } else {
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println("Unknown Command please reEnter!");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println();
                list = scanner.nextLine();
            }

            //end loop here
        }
    }
}
