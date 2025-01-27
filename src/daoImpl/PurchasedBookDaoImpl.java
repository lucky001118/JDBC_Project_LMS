package daoImpl;

import dao.PurchasedBooksDao;
import exceptions.PurchasedBookException;
import model.PurchasedBooks;
import query.PurchasedBookQuery;
import utility.ConnectionClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchasedBookDaoImpl implements PurchasedBooksDao {

    private PurchasedBookQuery purchasedBookQuery = new PurchasedBookQuery();
    @Override
    public List<PurchasedBooks> getAllPurchasedBooks() throws PurchasedBookException {
        List<PurchasedBooks> purchasedBooksAll = new ArrayList<>();
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(purchasedBookQuery.GET_ALL_PURCHASED_BOOK());

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (rs.next()!=false){
                // Print rows of data
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-30s", rs.getString(i)); // Format data
                    }
                    System.out.println();
                }
            }else {
                throw  new PurchasedBookException("The Purchased book table is empty");
            }

            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return purchasedBooksAll;
    }

    @Override
    public PurchasedBooks getPurchasedBookById(Integer purchaseBookID) throws PurchasedBookException {
        PurchasedBooks purchasedBooks = new PurchasedBooks();
        try{

            //building the connection with jdbc
            Connection connection = ConnectionClass.getInstance().getConnection();

            //prepareStatement for rebuilding the connection and query
            PreparedStatement ps = connection.prepareStatement(purchasedBookQuery.GET_PURCHASED_BOOK_BY_ID());
            ps.setInt(1,purchaseBookID);

            //Executing the query
            ResultSet rs = ps.executeQuery();

            // Fetch metadata to get column details
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-30s", metaData.getColumnName(i)); // Format column names
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");

            if (rs.next()!=false){
                // Print rows of data
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-30s", rs.getString(i)); // Format data
                    }
                    System.out.println();
                }
            }else {
                throw new PurchasedBookException("The purchased book was not found with this given id");
            }

            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return purchasedBooks;
    }

    @Override
    public String registerPurchasedBook(PurchasedBooks purchasedBooks) throws PurchasedBookException {
        return null;
    }

    @Override
    public String updatePurchaseBookDetails(PurchasedBooks purchasedBooks) throws PurchasedBookException {
        return null;
    }

    @Override
    public void deletePurchasedBook(Integer purchasedBookId) throws PurchasedBookException {

    }
}
