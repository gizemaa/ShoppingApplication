package Database;

import java.sql.*;
import shop.Products.*;

/*
Singeleton Pattern
 */
public class DatabaseConnection {

    //Variables   
    private static DatabaseConnection instance;
    private static Connection connection;
    private String url = "jdbc:mysql://localhost:3306/e-commerce"
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//To fix time zone error
    private String username = "root";
    private String password = "root";

    //Connect to the database
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connection successful");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    //Get the only object
    public static DatabaseConnection getInstance() {
        try {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
            return instance;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }   

    //Return Connection type
    public static Connection getConnection() {
        return connection;
    }
}
