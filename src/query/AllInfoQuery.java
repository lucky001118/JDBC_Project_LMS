package query;

public class AllInfoQuery {
    private String AllInfoUsingUserName = "SELECT" +
            "    u.UserID," +
            "    u.Name AS UserName," +
            "    u.Email," +
            "    u.Role," +
            "    u.RegistrationDate," +
            "    u.MembershipStartDate," +
            "    u.MembershipEndDate," +
            "    u.Address," +
            "    u.Phone," +
            "    u.TotalBooksIssued," +
            "    u.TotalBooksReturned," +
            "    u.PendingFine," +
            "    ib.IssueID," +
            "    ib.BookID AS IssuedBookID," +
            "    b1.Title AS IssuedBookTitle," +
            "    ib.IssueDate," +
            "    ib.DueDate," +
            "    ib.ReturnDate," +
            "    ib.FineAmount," +
            "    ib.IsReturned," +
            "    pb.PurchaseID," +
            "    pb.BookID AS PurchasedBookID," +
            "    b2.Title AS PurchasedBookTitle," +
            "    pb.PurchaseDate," +
            "    pb.Quantity AS PurchasedQuantity," +
            "    pb.TotalPrice" +
            " FROM " +
            "    users u" +
            " LEFT JOIN " +
            "    issuedbooks ib ON u.UserID = ib.UserID" +
            " LEFT JOIN " +
            "    books b1 ON ib.BookID = b1.BookID " +
            "LEFT JOIN " +
            "    purchasedbooks pb ON u.UserID = pb.UserID " +
            "LEFT JOIN " +
            "    books b2 ON pb.BookID = b2.BookID " +
            "WHERE " +
            "    u.Name = ? ";

    private String AllInfoUsingBookName = "     SELECT \n" +
            "    u.UserID,\n" +
            "    u.Name AS UserName,\n" +
            "    u.Email,\n" +
            "    u.Role,\n" +
            "    u.RegistrationDate,\n" +
            "    u.MembershipStartDate,\n" +
            "    u.MembershipEndDate,\n" +
            "    u.Address,\n" +
            "    u.Phone,\n" +
            "    u.TotalBooksIssued,\n" +
            "    u.TotalBooksReturned,\n" +
            "    u.PendingFine,\n" +
            "    \n" +
            "    -- Issued Book Information\n" +
            "    ib.IssueID AS IssuedBookID,\n" +
            "    b1.Title AS IssuedBookTitle,\n" +
            "    ib.IssueDate AS IssuedDate,\n" +
            "    ib.DueDate AS DueDate,\n" +
            "    ib.ReturnDate AS ReturnDate,\n" +
            "    ib.FineAmount AS FineAmount,\n" +
            "    ib.IsReturned AS BookReturned,\n" +
            "\n" +
            "    -- Purchased Book Information\n" +
            "    pb.PurchaseID AS PurchasedBookID,\n" +
            "    b2.Title AS PurchasedBookTitle,\n" +
            "    pb.PurchaseDate AS PurchaseDate,\n" +
            "    pb.Quantity AS PurchaseQuantity,\n" +
            "    pb.TotalPrice AS PurchaseTotalPrice\n" +
            "\n" +
            "FROM \n" +
            "    users u\n" +
            "\n" +
            "-- Join for issued books\n" +
            "LEFT JOIN \n" +
            "    issuedbooks ib ON u.UserID = ib.UserID\n" +
            "LEFT JOIN \n" +
            "    books b1 ON ib.BookID = b1.BookID\n" +
            "\n" +
            "-- Join for purchased books\n" +
            "LEFT JOIN \n" +
            "    purchasedbooks pb ON u.UserID = pb.UserID\n" +
            "LEFT JOIN \n" +
            "    books b2 ON pb.BookID = b2.BookID\n" +
            "\n" +
            "WHERE \n" +
            "    b1.Title = 'SpecificBookName' OR b2.Title = ? ";
    public String AllInfoUsingUserName() {
        return AllInfoUsingUserName;
    }

    public AllInfoQuery setAllInfoUsingUserName(String allInfoUsingUserName) {
        AllInfoUsingUserName = allInfoUsingUserName;
        return this;
    }

    public String AllInfoUsingBookName() {
        return AllInfoUsingBookName;
    }

    public AllInfoQuery setAllInfoUsingBookName(String allInfoUsingBookName) {
        AllInfoUsingBookName = allInfoUsingBookName;
        return this;
    }
}
