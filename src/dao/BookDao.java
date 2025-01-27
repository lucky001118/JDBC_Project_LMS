package dao;

import exceptions.BookException;
import model.Books;

import java.util.List;

public interface BookDao {
    public List<Books> getAllBooks() throws BookException;
    public Books getBookByBookId(Integer bookId) throws BookException;
    public List<Books> getBookByBookAuthor(String AuthorName);
    public Books getBookByBookTitle(String BookTitle);
    public String registerNewBook(Books book);
    public String updateBookInformation(Books book);
    public void deleteBookByBookId(Integer bookID);
}
