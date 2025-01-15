package service;

import exceptions.PurchasedBookException;
import model.PurchasedBooks;

import java.util.List;

public interface PurchasedBookService {
    public List<PurchasedBooks> getAllPurchasedBooks() throws PurchasedBookException;  //get all
    public PurchasedBooks getPurchasedBookById(Integer purchaseBookID) throws PurchasedBookException;  // get by id
    public String registerPurchasedBook(PurchasedBooks purchasedBooks) throws PurchasedBookException;  //register
    public String updatePurchaseBookDetails(PurchasedBooks purchasedBooks) throws PurchasedBookException; //update
    public void deletePurchasedBook(Integer purchasedBookId) throws PurchasedBookException;  // delete
}
