package dao;

import model.Books;

import java.util.List;

public interface BookDao {
    public List<Books> getAllBooks();
    public Books getBookByBookId(Integer bookId);
    public List<Books> getBookByBookAuthor(String AuthorName);
    public Books getBookByBookTitle(String BookTitle);
    public String registerNewBook(Books book);
    public String updateBookInformation(Books book);
    public void deleteBookByBookId(Integer bookID);
}
