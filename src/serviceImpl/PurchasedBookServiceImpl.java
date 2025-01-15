package serviceImpl;

import dao.PurchasedBooksDao;
import daoImpl.PurchasedBookDaoImpl;
import exceptions.PurchasedBookException;
import model.PurchasedBooks;
import service.PurchasedBookService;

import java.util.List;

public class PurchasedBookServiceImpl implements PurchasedBookService {
    private PurchasedBooksDao purchasedBooksDao = new PurchasedBookDaoImpl();
    @Override
    public List<PurchasedBooks> getAllPurchasedBooks() throws PurchasedBookException {
        return purchasedBooksDao.getAllPurchasedBooks();
    }

    @Override
    public PurchasedBooks getPurchasedBookById(Integer purchaseBookID) throws PurchasedBookException {
        return purchasedBooksDao.getPurchasedBookById(purchaseBookID);
    }

    @Override
    public String registerPurchasedBook(PurchasedBooks purchasedBooks) throws PurchasedBookException {
        return purchasedBooksDao.registerPurchasedBook(purchasedBooks);
    }

    @Override
    public String updatePurchaseBookDetails(PurchasedBooks purchasedBooks) throws PurchasedBookException {
        return purchasedBooksDao.updatePurchaseBookDetails(purchasedBooks);
    }

    @Override
    public void deletePurchasedBook(Integer purchasedBookId) throws PurchasedBookException {
        purchasedBooksDao.deletePurchasedBook(purchasedBookId);
    }
}
