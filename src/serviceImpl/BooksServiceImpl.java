package serviceImpl;

import dao.BookDao;
import daoImpl.BooksDaoImpl;
import model.Books;
import service.BooksService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public String registerNewBook(Books book)
    {
        // Get the current date
        LocalDate date = LocalDate.now();

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the date to string
        String formattedDate = date.format(formatter);

        bookDao.registerNewBook(book.setAddedDate(String.valueOf(java.sql.Date.valueOf(formattedDate))));
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
