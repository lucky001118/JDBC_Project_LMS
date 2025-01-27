import exceptions.BookException;
import exceptions.BookIssueException;
import exceptions.PurchasedBookException;
import exceptions.UserException;
import useCase.AndinAndCustomerOperation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserException, BookIssueException, PurchasedBookException, IOException, BookException {

            AndinAndCustomerOperation andinAndCustomerOperation = new AndinAndCustomerOperation();
            andinAndCustomerOperation.AdminAndCustomerOperations();


    }
}