package serviceImpl;

import dao.IssuedBookDao;
import daoImpl.IssuedBookDaoImpl;
import exceptions.BookIssueException;
import model.IssuedBooks;
import service.IssuedBookService;

import java.util.List;

public class IssuedBookServiceImpl implements IssuedBookService {
    private IssuedBookDao issuedBookDao = new IssuedBookDaoImpl();
    @Override
    public List<IssuedBooks> getAllIssuedBooks() throws BookIssueException {
        return issuedBookDao.getAllIssuedBooks();
    }

    @Override
    public IssuedBooks getTheIssuedBookByID(Integer issuedBookId) throws BookIssueException {
        return issuedBookDao.getTheIssuedBookByID(issuedBookId);
    }

    @Override
    public String issueBook(IssuedBooks issuedBooks) throws BookIssueException {
        return issuedBookDao.issueBook(issuedBooks);
    }

    @Override
    public String updateIssuedBookInformation(IssuedBooks updatedInfo) throws BookIssueException {
        return issuedBookDao.updateIssuedBookInformation(updatedInfo);
    }

    @Override
    public void removeIssuedBook(Integer issuedBookId) throws BookIssueException {
        issuedBookDao.removeIssuedBook(issuedBookId);
    }
}
