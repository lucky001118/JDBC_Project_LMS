package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singletone class for build the connection
public class ConnectionClass {
    String driverClassName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/anudeep_library_management_system";
    String dbUser = "root";
    String dbPwd = "Lucky@server2002";

    // making the connectionFactory object for the making the connection
    private static ConnectionClass connectionProvider = null;

    //loading the driver class with the help of the connectionFactory
    private ConnectionClass() {
        try {
            // loading the driver class of jdbc
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // making the connection with using the function
    public Connection getConnection() throws SQLException, SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static ConnectionClass getInstance() {
        if (connectionProvider == null) {
            connectionProvider = new ConnectionClass();
        }
        return connectionProvider;
    }

}
