package serviceImpl;

import dao.BookDao;
import daoImpl.BooksDaoImpl;
import model.Books;
import service.BooksService;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    private BookDao bookDao = new BooksDaoImpl();
    @Override
    public List<Books> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Books getBookByBookId(Integer bookId) {
        return bookDao.getBookByBookId(bookId);
    }

    @Override
    public List<Books> getBookByBookAuthor(String AuthorName) {
        return bookDao.getBookByBookAuthor(AuthorName);
    }

    @Override
    public Books getBookByBookTitle(String BookTitle) {
        return bookDao.getBookByBookTitle(BookTitle);
    }

    @Override
    public String registerNewBook(Books book) {
        return bookDao.registerNewBook(book);
    }

    @Override
    public String updateBookInformation(Books book) {
        return bookDao.updateBookInformation(book);
    }

    @Override
    public void deleteBookByBookId(Integer bookID) {
        bookDao.deleteBookByBookId(bookID);
    }
}
