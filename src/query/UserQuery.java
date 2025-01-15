package query;

public class UserQuery {
    private String GET_ALL_USERS = "SELECT * FROM Users";
    private String GET_USERS_BY_USERID = "SELECT * from Users WHERE UserId = ?";
    private String REGISTERED_USER = "INSERT INTO Users (Email, Password, Name, Role, RegistrationDate, MembershipStartDate, MembershipEndDate, Address, Phone, Active, TotalBooksIssued, TotalBooksReturned, PendingFine, RoleID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String DELETE_USER = "DELETE FROM Users WHERE UserId=?";
    private String UPDATE_USER_BASIC_DETAIL = "UPDATE Users SET Email=?, Name=?, Address=?, Phone=? WHERE UserId=?";
    private String UPDATE_USER_MEMBERSHIP = "UPDATE Users SET MembershipStartDate = ?, MembershipEndDate = ? WHERE UserId=?";
    private String UPDATE_USER_FINE = "UPDATE Users SET PendingFine = ? WHERE UserId=? ";
    private String UPDATE_TOTAL_BOOKS = "UPDATE Users SET TotalBooksIssued = ? , TotalBooksReturned = ? WHERE UserId=? ";

    public String GET_ALL_USERS() {
        return GET_ALL_USERS;
    }

    public UserQuery setGET_ALL_USERS(String GET_ALL_USERS) {
        this.GET_ALL_USERS = GET_ALL_USERS;
        return this;
    }

    public String GET_USERS_BY_USERID() {
        return GET_USERS_BY_USERID;
    }

    public UserQuery setGET_USERS_BY_USERID(String GET_USERS_BY_USERID) {
        this.GET_USERS_BY_USERID = GET_USERS_BY_USERID;
        return this;
    }

    public String REGISTERED_USER() {
        return REGISTERED_USER;
    }

    public UserQuery setREGISTERED_USER(String REGISTERED_USER) {
        this.REGISTERED_USER = REGISTERED_USER;
        return this;
    }

    public String DELETE_USER() {
        return DELETE_USER;
    }

    public UserQuery setDELETE_USER(String DELETE_USER) {
        this.DELETE_USER = DELETE_USER;
        return this;
    }

    public String UPDATE_USER_BASIC_DETAIL() {
        return UPDATE_USER_BASIC_DETAIL;
    }

    public UserQuery setUPDATE_USER_BASIC_DETAIL(String UPDATE_USER_BASIC_DETAIL) {
        this.UPDATE_USER_BASIC_DETAIL = UPDATE_USER_BASIC_DETAIL;
        return this;
    }

    public String UPDATE_USER_MEMBERSHIP() {
        return UPDATE_USER_MEMBERSHIP;
    }

    public UserQuery setUPDATE_USER_MEMBERSHIP(String UPDATE_USER_MEMBERSHIP) {
        this.UPDATE_USER_MEMBERSHIP = UPDATE_USER_MEMBERSHIP;
        return this;
    }

    public String UPDATE_USER_FINE() {
        return UPDATE_USER_FINE;
    }

    public UserQuery setUPDATE_USER_FINE(String UPDATE_USER_FINE) {
        this.UPDATE_USER_FINE = UPDATE_USER_FINE;
        return this;
    }

    public String UPDATE_TOTAL_BOOKS() {
        return UPDATE_TOTAL_BOOKS;
    }

    public UserQuery setUPDATE_TOTAL_BOOKS(String UPDATE_TOTAL_BOOKS) {
        this.UPDATE_TOTAL_BOOKS = UPDATE_TOTAL_BOOKS;
        return this;
    }

    public UserQuery(String GET_ALL_USERS, String GET_USERS_BY_USERID, String REGISTERED_USER, String DELETE_USER, String UPDATE_USER_BASIC_DETAIL) {
        this.GET_ALL_USERS = GET_ALL_USERS;
        this.GET_USERS_BY_USERID = GET_USERS_BY_USERID;
        this.REGISTERED_USER = REGISTERED_USER;
        this.DELETE_USER = DELETE_USER;
        this.UPDATE_USER_BASIC_DETAIL = UPDATE_USER_BASIC_DETAIL;
    }

    public UserQuery(String UPDATE_USER_MEMBERSHIP) {
        this.UPDATE_USER_MEMBERSHIP = UPDATE_USER_MEMBERSHIP;
    }

    public UserQuery(){

    }
}
