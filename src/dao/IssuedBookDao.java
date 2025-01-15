package dao;

import exceptions.BookIssueException;
import model.IssuedBooks;

import java.util.List;

public interface IssuedBookDao {
    public List<IssuedBooks> getAllIssuedBooks() throws BookIssueException;  //get all
    public IssuedBooks getTheIssuedBookByID(Integer issuedBookId) throws BookIssueException;  //get by id
    public String issueBook(IssuedBooks issuedBooks) throws BookIssueException;  //regidter

    public String updateIssuedBookInformation(IssuedBooks updatedInfo) throws BookIssueException;
    public void removeIssuedBook(Integer issuedBookId) throws BookIssueException;

}
