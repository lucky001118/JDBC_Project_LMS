package daoImpl;

import dao.IssuedBookDao;
import exceptions.BookIssueException;
import model.IssuedBooks;
import query.IssuedBookQuery;
import utility.ConnectionClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssuedBookDaoImpl implements IssuedBookDao {

    private IssuedBookQuery issuedBookQuery = new IssuedBookQuery();
    @Override
    public List<IssuedBooks> getAllIssuedBooks() throws BookIssueException {
        List<IssuedBooks> issuedBooks = new ArrayList<>();
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(issuedBookQuery.GET_ALL_ISSUEDBOOK());

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (rs.next()!=false){
                // Print rows of data
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-30s", rs.getString(i)); // Format data
                    }
                    System.out.println();
                }
            }else {
                throw new BookIssueException("The no record is available in issuedBook table");
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return issuedBooks;
    }

    @Override
    public IssuedBooks getTheIssuedBookByID(Integer issuedBookId) throws BookIssueException {
        IssuedBooks issuedBooksInfo = new IssuedBooks();

        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(issuedBookQuery.GET_ISSUED_BOOK_BY_ID());
            ps.setInt(1,issuedBookId);

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            // Print rows of data
            if(rs.next()!=false){
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-30s", rs.getString(i)); // Format data

                        issuedBooksInfo.setIssueID(rs.getInt(1));
                        issuedBooksInfo.setIssueDate(rs.getString(4));
                        issuedBooksInfo.setDueDate(rs.getString(5));
                    }
                    System.out.println();
            }else{
                throw  new BookIssueException("There is no books found with this issued bookId");
            }

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return issuedBooksInfo;
    }

    @Override
    public String issueBook(IssuedBooks issuedBooks) throws BookIssueException {

        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(issuedBookQuery.ISSUE_BOOK());
            ps.setInt(1,issuedBooks.bookID());
            ps.setInt(2,issuedBooks.userId());
            ps.setString(3, issuedBooks.issueDate());
            ps.setString(4, issuedBooks.dueDate());

            //Executing the query
            int rs = ps.executeUpdate();
            System.out.println("***********************************************");
            System.out.println("Book registered successfully Done!");
            System.out.println("***********************************************");

            //if prepare statement have any istance the we have to close those connections
            if (ps != null)
                ps.close();
            if (connection != null)
                connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return "Book Issued successfully!";
    }

    @Override
    public String updateIssuedBookInformation(IssuedBooks updatedInfo) throws BookIssueException {
        return null;
    }

    @Override
    public void removeIssuedBook(Integer issuedBookId) throws BookIssueException {
        try {
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(issuedBookQuery.DELETE_ISSUED_BOOK_BY_ID());
            ps.setInt(1, issuedBookId);

            //execute the query
            ps.executeUpdate();
            System.out.println("***********************************************");
            System.out.println("Data deleted Successfully");
            System.out.println("***********************************************");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void returnBook(IssuedBooks issuedBooks) throws BookIssueException {
        try {
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(issuedBookQuery.RETURN_ISSUED_BOOK());
            ps.setDouble(1, issuedBooks.fineAmount());
            ps.setBoolean(2,issuedBooks.isReturned());
            ps.setBoolean(3,issuedBooks.isFinePaid());
            ps.setString(4,issuedBooks.returnDate());
            ps.setInt(5,issuedBooks.issueID());

            //execute the query
            ps.executeUpdate();
            System.out.println("***********************************************");
            System.out.println("Book Returned Successfully");
            System.out.println("***********************************************");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
