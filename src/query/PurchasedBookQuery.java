package query;

public class PurchasedBookQuery {
    private String GET_ALL_PURCHASED_BOOK = "SELECT * FROM PurchasedBooks";
    private  String GET_PURCHASED_BOOK_BY_ID = "SELECT * FROM PurchasedBooks WHERE PurchaseID = ?";
    private String PURCHASED_BOOK = "INSERT INO PurchasedBooks(UserID,BookID,PurchaseDate,Quantity,TotalPrice) VALUES (?,?,?,?,?)";
    private String UPDATE_PURCHASED_BOOK = "UPDATE PurchasedBooks SET UserID = ?, BookID = ?, PurchaseDate=?, Quantity=?, TotalPrice=? WHERE PurchaseID = ?";
    private String DELETE_PURCHASED_BOOK_INFO = "DELETE FROM PurchasedBooks WHERE PurchaseID = ?";

    public String GET_ALL_PURCHASED_BOOK() {
        return GET_ALL_PURCHASED_BOOK;
    }

    public PurchasedBookQuery setGET_ALL_PURCHASED_BOOK(String GET_ALL_PURCHASED_BOOK) {
        this.GET_ALL_PURCHASED_BOOK = GET_ALL_PURCHASED_BOOK;
        return this;
    }

    public String GET_PURCHASED_BOOK_BY_ID() {
        return GET_PURCHASED_BOOK_BY_ID;
    }

    public PurchasedBookQuery setGET_PURCHASED_BOOK_BY_ID(String GET_PURCHASED_BOOK_BY_ID) {
        this.GET_PURCHASED_BOOK_BY_ID = GET_PURCHASED_BOOK_BY_ID;
        return this;
    }

    public String PURCHASED_BOOK() {
        return PURCHASED_BOOK;
    }

    public PurchasedBookQuery setPURCHASED_BOOK(String PURCHASED_BOOK) {
        this.PURCHASED_BOOK = PURCHASED_BOOK;
        return this;
    }

    public String UPDATE_PURCHASED_BOOK() {
        return UPDATE_PURCHASED_BOOK;
    }

    public PurchasedBookQuery setUPDATE_PURCHASED_BOOK(String UPDATE_PURCHASED_BOOK) {
        this.UPDATE_PURCHASED_BOOK = UPDATE_PURCHASED_BOOK;
        return this;
    }

    public String DELETE_PURCHASED_BOOK_INFO() {
        return DELETE_PURCHASED_BOOK_INFO;
    }

    public PurchasedBookQuery setDELETE_PURCHASED_BOOK_INFO(String DELETE_PURCHASED_BOOK_INFO) {
        this.DELETE_PURCHASED_BOOK_INFO = DELETE_PURCHASED_BOOK_INFO;
        return this;
    }

    public PurchasedBookQuery(String GET_ALL_PURCHASED_BOOK, String GET_PURCHASED_BOOK_BY_ID, String PURCHASED_BOOK, String UPDATE_PURCHASED_BOOK, String DELETE_PURCHASED_BOOK_INFO) {
        this.GET_ALL_PURCHASED_BOOK = GET_ALL_PURCHASED_BOOK;
        this.GET_PURCHASED_BOOK_BY_ID = GET_PURCHASED_BOOK_BY_ID;
        this.PURCHASED_BOOK = PURCHASED_BOOK;
        this.UPDATE_PURCHASED_BOOK = UPDATE_PURCHASED_BOOK;
        this.DELETE_PURCHASED_BOOK_INFO = DELETE_PURCHASED_BOOK_INFO;
    }

    public PurchasedBookQuery(){

    }
}
