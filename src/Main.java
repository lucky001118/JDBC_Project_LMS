import exceptions.BookIssueException;
import exceptions.PurchasedBookException;
import exceptions.UserException;
import useCase.AndinAndCustomerOperation;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UserException, BookIssueException, PurchasedBookException, IOException {

        AndinAndCustomerOperation andinAndCustomerOperation = new AndinAndCustomerOperation();
        andinAndCustomerOperation.AdminAndCustomerOperations();
    }
}