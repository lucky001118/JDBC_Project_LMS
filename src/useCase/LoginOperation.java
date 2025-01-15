package useCase;

import exceptions.UserException;
import model.LoginPage;
import utility.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginOperation {

    public LoginOperation(){

    }

    public LoginPage doLogin(String email,String password) throws UserException {

        LoginPage loginPage = new LoginPage();

        try {
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();
            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement("SELECT * from Users WHERE Email=? AND Password=? ");
            ps.setString(1, email);
            ps.setString(2,password);
//                ps.setString(2, password);

            //Executing the query
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String Remail = rs.getString(2);
                loginPage.setResponseEmail(Remail) ;
                loginPage.setResponsePassword(rs.getString(3))  ;
                loginPage.setResponseName(rs.getString(4));
                loginPage.setResponseRole(rs.getString(5));

                System.out.println("\n**************************************");
                System.out.println("Login Success!");
                System.out.println("************************************** \n");
                loginPage.setLogin(true);

            }else {
                System.out.println("\n**************************************");
                System.out.println("Login Failed!, please enter currect email and password and countinue again..");
                System.out.println("************************************** \n");
                loginPage.setLogin(false);
                throw new UserException("Invalid credentials");
            }

            if (loginPage.ResponseRole().equals("Admin")){
                System.out.println("Welcome "+loginPage.ResponseName());
                System.out.println("All the Admins operations here");
            }else {
                System.out.println("Welcome "+loginPage.ResponseName());
                System.out.println("All the customers operations here");
            }


        } catch (SQLException e) {
//                throw new RuntimeException(e);
                throw  new UserException("Invalid email or password!, Login Failed!, please enter currect email and password and countinue again..");
        }

        return loginPage;
    }
}
