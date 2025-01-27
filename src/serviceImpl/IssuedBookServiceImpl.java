package serviceImpl;

import dao.IssuedBookDao;
import daoImpl.IssuedBookDaoImpl;
import exceptions.BookIssueException;
import model.IssuedBooks;
import service.IssuedBookService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
        // Get the current date
        LocalDate date = LocalDate.now();
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the date to string
        String currentDate = date.format(formatter);

        issuedBooks.setIssueDate(currentDate);

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

    @Override
    public void returnBook(IssuedBooks issuedBooks) throws BookIssueException {

        // Get the current date
        LocalDate date = LocalDate.now();
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Format the date to string
        String currentDate = date.format(formatter);
        issuedBooks.setReturnDate(currentDate);

        IssuedBooks issuedBooksforDate = issuedBookDao.getTheIssuedBookByID(issuedBooks.issueID());

        //calculate the fine Amount

            LocalDate dueDate = LocalDate.parse(issuedBooksforDate.dueDate(), formatter);
            LocalDate returnDate = LocalDate.parse(currentDate, formatter);

            // Fine rate per day
        int finePerDay = 10;

            // Calculate the difference in days
            long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);

            Double totalFine = (double) 0;

        if (overdueDays > 0) {
            totalFine = (double) (overdueDays * finePerDay);
            System.out.println("The item is overdue by " + overdueDays + " days.");
            System.out.println("The fine amount is: ₹" + totalFine);
        } else {
            System.out.println("The item was returned on time. No fine is applied.");
            totalFine = 0.0;
        }

        issuedBooks.setFineAmount(totalFine);

        issuedBookDao.returnBook(issuedBooks);
    }
}
