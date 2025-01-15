package query;

public class BookQuery {
    private String SELECT_ALL_BOOK = "SELECT * FROM Books";
    private String SELECT_BOOK_BY_ID = "SELECT * FROM Books WHERE BookID = ? ";
    private String SELECT_BOOK_BY_AUTHOR_NAME = "SELECT * FROM Books WHERE Author = ? ";
    private String SELECT_BOOK_BY_BOOK_NAME = "SELECT * FROM Books WHERE Title = ? ";
    private String REGISTER_NEW_BOOK = "INSERT INTO Books(Title,Author,Genre,Quantity,Price,AddedDate) VALUES (?,?,?,?,?,?) ";    //insert query
    private String UPDATE_BOOK_INFORMATION = "UPDATE Books SET Title=?, Author=?, Genre=?, Quantity=?, Price=? WHERE BookID=? "; //update query
    private String DELETE_BOOK_BY_BOOKID = "DELETE FROM Books WHERE BookID = ?"; //delete query

    public String SELECT_ALL_BOOK() {
        return SELECT_ALL_BOOK;
    }

    public BookQuery setSELECT_ALL_BOOK(String SELECT_ALL_BOOK) {
        this.SELECT_ALL_BOOK = SELECT_ALL_BOOK;
        return this;
    }

    public String SELECT_BOOK_BY_ID() {
        return SELECT_BOOK_BY_ID;
    }

    public BookQuery setSELECT_BOOK_BY_ID(String SELECT_BOOK_BY_ID) {
        this.SELECT_BOOK_BY_ID = SELECT_BOOK_BY_ID;
        return this;
    }

    public String SELECT_BOOK_BY_AUTHOR_NAME() {
        return SELECT_BOOK_BY_AUTHOR_NAME;
    }

    public BookQuery setSELECT_BOOK_BY_AUTHOR_NAME(String SELECT_BOOK_BY_AUTHOR_NAME) {
        this.SELECT_BOOK_BY_AUTHOR_NAME = SELECT_BOOK_BY_AUTHOR_NAME;
        return this;
    }

    public String SELECT_BOOK_BY_BOOK_NAME() {
        return SELECT_BOOK_BY_BOOK_NAME;
    }

    public BookQuery setSELECT_BOOK_BY_BOOK_NAME(String SELECT_BOOK_BY_BOOK_NAME) {
        this.SELECT_BOOK_BY_BOOK_NAME = SELECT_BOOK_BY_BOOK_NAME;
        return this;
    }

    public String REGISTER_NEW_BOOK() {
        return REGISTER_NEW_BOOK;
    }

    public BookQuery setREGISTER_NEW_BOOK(String REGISTER_NEW_BOOK) {
        this.REGISTER_NEW_BOOK = REGISTER_NEW_BOOK;
        return this;
    }

    public String UPDATE_BOOK_INFORMATION() {
        return UPDATE_BOOK_INFORMATION;
    }

    public BookQuery setUPDATE_BOOK_INFORMATION(String UPDATE_BOOK_INFORMATION) {
        this.UPDATE_BOOK_INFORMATION = UPDATE_BOOK_INFORMATION;
        return this;
    }

    public String DELETE_BOOK_BY_BOOKID() {
        return DELETE_BOOK_BY_BOOKID;
    }

    public BookQuery setDELETE_BOOK_BY_BOOKID(String DELETE_BOOK_BY_BOOKID) {
        this.DELETE_BOOK_BY_BOOKID = DELETE_BOOK_BY_BOOKID;
        return this;
    }

    public BookQuery(String SELECT_ALL_BOOK, String SELECT_BOOK_BY_ID, String SELECT_BOOK_BY_AUTHOR_NAME, String SELECT_BOOK_BY_BOOK_NAME, String REGISTER_NEW_BOOK, String UPDATE_BOOK_INFORMATION, String DELETE_BOOK_BY_BOOKID) {
        this.SELECT_ALL_BOOK = SELECT_ALL_BOOK;
        this.SELECT_BOOK_BY_ID = SELECT_BOOK_BY_ID;
        this.SELECT_BOOK_BY_AUTHOR_NAME = SELECT_BOOK_BY_AUTHOR_NAME;
        this.SELECT_BOOK_BY_BOOK_NAME = SELECT_BOOK_BY_BOOK_NAME;
        this.REGISTER_NEW_BOOK = REGISTER_NEW_BOOK;
        this.UPDATE_BOOK_INFORMATION = UPDATE_BOOK_INFORMATION;
        this.DELETE_BOOK_BY_BOOKID = DELETE_BOOK_BY_BOOKID;
    }

    public BookQuery(){

    }
}
