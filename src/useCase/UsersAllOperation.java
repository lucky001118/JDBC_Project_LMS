package useCase;

import exceptions.UserException;
import model.Users;
import service.UserService;
import serviceImpl.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UsersAllOperation {
    private UserService userService = new UserServiceImpl();
    public void userAllOperations() throws UserException, IOException {
        Scanner scanner = new Scanner(System.in);
        // Create a BufferedReader instance
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n *****************************************************************\n");
        System.out.println("All the related operation you can perform here..");
        System.out.print("Click 1 for Get all Users Information \n" +
                "Click 2 for Get Specific users information \n" +
                "Click 3 for Register new user \n" +
                "Click 4 for delete the user \n" +
                "Click 5 for update the user's information ");
        String input = br.readLine();

        // Convert the string input to an integer
        int choose = Integer.parseInt(input);

        switch (choose){
            case 1:
                System.out.println("You wants to see all the users information");
                userService.getAllUsers();
                break;
            case 2:
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.println("You wants to see specific the users information");
                System.out.print("Enter the user's id: ");
                int userId = scanner.nextInt();
                userService.getUserByUserID(userId);
                break;
            case 3:
                System.out.println("You wants to register one more user");
                Users users = new Users();
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the Email of the user: ");
                String email = scanner.nextLine();
                users.setEmail(email);
                System.out.print("Enter the Password of the user: ");
                String password = scanner.nextLine();
                users.setPassword(password);
                System.out.print("Enter the name of the user: ");
                String name = scanner.nextLine();
                users.setName(name);

                //register the user
                userService.registerUser(users);
                break;
            case 4:
                System.out.println("You wants to delete the users information");
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the user Id: ");
                int id = scanner.nextInt();

                userService.deleteUser(id);
                break;
            case 5:
                System.out.println("You wants to see update the users information");
                Users updateUsers = new Users();
                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the user Id: ");
                int updateIid = scanner.nextInt();
                updateUsers.setUserID(updateIid);

                scanner.nextLine(); // Consume the newline character after nextInt()
                System.out.print("Enter the user Email: ");
                String updatedEmail = scanner.nextLine();
                updateUsers.setEmail(updatedEmail);
                System.out.print("Enter the user Name: ");
                String updatedName = scanner.nextLine();
                updateUsers.setName(updatedName);
                System.out.print("Enter the user Address: ");
                String updatedAddress = scanner.nextLine();
                updateUsers.setAddress(updatedAddress);
                System.out.print("Enter the user Phone: ");
                String updatedPhone = scanner.nextLine();
                updateUsers.setPhone(updatedPhone);

                //update
                userService.updateUser(updateUsers);
                break;
            default:
                System.out.println("You have choose invalid option please re-try..");
                break;
        }

        System.out.println("\n *****************************************************************\n");

    }
}
