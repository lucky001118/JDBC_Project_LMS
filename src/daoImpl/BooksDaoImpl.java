package daoImpl;

import dao.BookDao;
import model.Books;
import query.BookQuery;
import utility.ConnectionClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDaoImpl implements BookDao {

    //making the object of the booksQuery class where all the Books table related query are written
    private BookQuery bookQuery = new BookQuery();
    @Override
    public List<Books> getAllBooks() {
        List<Books> allBooks = new ArrayList<>();
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.SELECT_ALL_BOOK());

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            // Print rows of data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-30s", rs.getString(i)); // Format data
                }
                System.out.println();
            }

            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allBooks;
    }

    @Override
    public Books getBookByBookId(Integer bookId) {
        Books books = new Books();
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.SELECT_BOOK_BY_ID());
            ps.setInt(1,bookId);

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            // Print rows of data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-30s", rs.getString(i)); // Format data
                }
                System.out.println();
            }

            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Books> getBookByBookAuthor(String AuthorName) {
        List<Books> books = new ArrayList<>();
        try{
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.SELECT_BOOK_BY_AUTHOR_NAME());
            ps.setString(1,AuthorName);

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            // Print rows of data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-30s", rs.getString(i)); // Format data
                }
                System.out.println();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Books getBookByBookTitle(String BookTitle) {
        try{
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.SELECT_BOOK_BY_BOOK_NAME());
            ps.setString(1,BookTitle);

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            // Print rows of data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-30s", rs.getString(i)); // Format data
                }
                System.out.println();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String registerNewBook(Books book) {
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.UPDATE_BOOK_INFORMATION());
            ps.setString(1,book.title());
            ps.setString(2,book.author());
            ps.setString(3,book.genre());
            ps.setInt(4,book.quantity());
            ps.setDouble(5,book.price());
            ps.setDate(6, (Date) book.addedDate());

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

        return "Update successfully Done!";
    }

    @Override
    public String updateBookInformation(Books book) {
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.UPDATE_BOOK_INFORMATION());
            ps.setString(1,book.title());
            ps.setString(2,book.author());
            ps.setString(3,book.genre());
            ps.setInt(4,book.quantity());
            ps.setDouble(5,book.price());
            ps.setInt(6, book.bookId());

            //Executing the query
            int rs = ps.executeUpdate();
            System.out.println("***********************************************");
            System.out.println("Update successfully Done!");
            System.out.println("***********************************************");

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

    @Override
    public void deleteBookByBookId(Integer bookID) {
        try {
            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(bookQuery.DELETE_BOOK_BY_BOOKID());
            ps.setInt(1, bookID);

            //execute the query
            ps.executeUpdate();

            System.out.println("Data deleted Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
