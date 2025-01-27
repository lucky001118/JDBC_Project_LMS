package daoImpl;

import dao.UserDao;
import exceptions.UserException;
import model.Users;
import query.UserQuery;
import utility.ConnectionClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //making the userQuery class object for accessing the query related to users
    private UserQuery userQuery = new UserQuery();
    @Override
    public List<Users> getAllUsers() throws UserException {
        List<Users> users = new ArrayList<>();
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(userQuery.GET_ALL_USERS());
            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-29s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (rs.next()!=false){
                // Print rows of data
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-29s", rs.getString(i)); // Format data
                    }
                    System.out.println();
                }
            }else{
                throw new UserException("There is no user in the User Table");
            }

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//            while (rs.next()){
//                System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3)+ " "+rs.getString(4)+" "+rs.getString(5)
//                        +" "+rs.getDate(6)+" "+rs.getDate(7)+" " +rs.getDate(8)+" "+rs.getString(9)+" "
//                +rs.getString(10)+" "+rs.getInt(11)+" "+rs.getInt(12)+" "+rs.getInt(13)+" "+rs.getDouble(14)
//                +" "+rs.getInt(15));
//            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Users getUserByUserID(Integer userID) throws UserException {
        Users users = new Users();

        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(userQuery.GET_USERS_BY_USERID());
            ps.setInt(1,userID);
            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-29s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (rs.next()!=false){
                // Print rows of data
                    System.out.println(rs.getInt(1));
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-29s", rs.getString(i)); // Format data
                    }
                    System.out.println();
            }else {
                throw new UserException("User is not found with this user Id");
            }

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public String registerUser(Users users) throws UserException {
        try {
            //Email, Password, Name, Role, RegistrationDate, MembershipStartDate, MembershipEndDate, Address, Phone, Active, TotalBooksIssued, TotalBooksReturned, PendingFine, RoleID
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(userQuery.REGISTERED_USER());
            ps.setString(1,users.email());
            ps.setString(2,users.password());
            ps.setString(3,users.name());
            ps.setString(4, String.valueOf(users.role()));
            ps.setString(5, users.registrationDate());
            ps.setString(6,users.membershipStartDate());
            ps.setString(7,users.membershipEndDate());
            ps.setString(8,users.address());
            ps.setString(9,users.phone());
            ps.setBoolean(10,users.active());
            ps.setInt(11,users.totalBooksIssued());
            ps.setInt(12,users.totalBooksReturned());
            ps.setDouble(13,users.pendingFine());
            ps.setInt(14, users.role().ordinal());

            //execute the query
            ps.executeUpdate();

            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUser(Integer userId) throws UserException {
        try {
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(userQuery.DELETE_USER());
            ps.setInt(1, userId);

            //execute the query
            ps.executeUpdate();

            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String updateUser(Users users) throws UserException {
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(userQuery.UPDATE_USER_BASIC_DETAIL());
            ps.setString(1,users.email());
            ps.setString(2,users.name());
            ps.setString(3,users.address());
            ps.setString(4,users.phone());
            ps.setInt(5,users.userID());

            //Executing the query
            int rs = ps.executeUpdate();

            System.out.println("Update successfully Done!");

            //if prepare statement have any istance the we have to close those connections
            if (ps != null)
                ps.close();
            if (connection != null)
                connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return "Update successfully Done!";
    }
}
