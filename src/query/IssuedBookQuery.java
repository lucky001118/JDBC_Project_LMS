package query;

public class IssuedBookQuery {
    private String GET_ALL_ISSUEDBOOK = "SELECT * FROM IssuedBooks";
    private String GET_ISSUED_BOOK_BY_ID = "SELECT * FROM IssuedBooks WHERE IssueID = ?";
    private  String ISSUE_BOOK = "INSERT INTO IssuedBooks(BookID,UserID,IssueDate,DueDate,ReturnDate) VALUES (?,?,?,?,?) ";
    private String UPDATE_ISSUED_BOOK = "UPDATE IssuedBooks SET BookID = ?, UserID=?, IssueDate=?, DueDate=?, ReturnDate=?, FineAmount=?, IsReturned=?, IsFinePaid=? WHERE  IssueID=? ";
    private String DELETE_ISSUED_BOOK_BY_ID = "DELETE  FROM IssuedBooks WHERE IssueID = ?";

    public String GET_ALL_ISSUEDBOOK() {
        return GET_ALL_ISSUEDBOOK;
    }

    public IssuedBookQuery setGET_ALL_ISSUEDBOOK(String GET_ALL_ISSUEDBOOK) {
        this.GET_ALL_ISSUEDBOOK = GET_ALL_ISSUEDBOOK;
        return this;
    }

    public String GET_ISSUED_BOOK_BY_ID() {
        return GET_ISSUED_BOOK_BY_ID;
    }

    public IssuedBookQuery setGET_ISSUED_BOOK_BY_ID(String GET_ISSUED_BOOK_BY_ID) {
        this.GET_ISSUED_BOOK_BY_ID = GET_ISSUED_BOOK_BY_ID;
        return this;
    }

    public String ISSUE_BOOK() {
        return ISSUE_BOOK;
    }

    public IssuedBookQuery setISSUE_BOOK(String ISSUE_BOOK) {
        this.ISSUE_BOOK = ISSUE_BOOK;
        return this;
    }

    public String UPDATE_ISSUED_BOOK() {
        return UPDATE_ISSUED_BOOK;
    }

    public IssuedBookQuery setUPDATE_ISSUED_BOOK(String UPDATE_ISSUED_BOOK) {
        this.UPDATE_ISSUED_BOOK = UPDATE_ISSUED_BOOK;
        return this;
    }

    public String DELETE_ISSUED_BOOK_BY_ID() {
        return DELETE_ISSUED_BOOK_BY_ID;
    }

    public IssuedBookQuery setDELETE_ISSUED_BOOK_BY_ID(String DELETE_ISSUED_BOOK_BY_ID) {
        this.DELETE_ISSUED_BOOK_BY_ID = DELETE_ISSUED_BOOK_BY_ID;
        return this;
    }

    public IssuedBookQuery(){

    }

    public IssuedBookQuery(String GET_ALL_ISSUEDBOOK, String GET_ISSUED_BOOK_BY_ID, String ISSUE_BOOK, String UPDATE_ISSUED_BOOK, String DELETE_ISSUED_BOOK_BY_ID) {
        this.GET_ALL_ISSUEDBOOK = GET_ALL_ISSUEDBOOK;
        this.GET_ISSUED_BOOK_BY_ID = GET_ISSUED_BOOK_BY_ID;
        this.ISSUE_BOOK = ISSUE_BOOK;
        this.UPDATE_ISSUED_BOOK = UPDATE_ISSUED_BOOK;
        this.DELETE_ISSUED_BOOK_BY_ID = DELETE_ISSUED_BOOK_BY_ID;
    }
}
