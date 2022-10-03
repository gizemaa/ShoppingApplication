package Database;

import java.sql.*;
import shop.Products.*;

/*
Builder Pattern
 */
public class DatabaseSelect {

    //Variables
    private final String tableName, whereStatement;
    private final ResultSet result;

    //Constructor
    public DatabaseSelect(Builder builder) {
        this.tableName = builder.tableName;
        this.whereStatement = builder.whereStatement;
        this.result = builder.result;
    }

    //Getters
    public String getTableName() {
        return tableName;
    }

    public String getWhereStatement() {
        return whereStatement;
    }

    public ResultSet getResult() {
        return result;
    }

    //Builder class
    public static class Builder {

        //Variables
        private String tableName, whereStatement;
        private ResultSet result;
        private DatabaseConnection data;

        //Constructor
        public Builder() {
            //Database connection
            this.data = DatabaseConnection.getInstance();
        }

        //Build methods
        public Builder selectFromTable(String tableName) {
            this.tableName = tableName;
            this.selectTable();
            return this;
        }

        public Builder whereStatement(String whereStatement) {
            this.whereStatement = whereStatement;
            return this;
        }

        //Build method
        public DatabaseSelect build() {
            return new DatabaseSelect(this);
        }

        //Select the specified table by execute sql query
        private void selectTable() {
            try {
                Connection con = DatabaseConnection.getConnection();
                Statement st = con.createStatement();
                result = st.executeQuery("select * from " + tableName);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //Create table if not exist
        public Builder createTable(String tableName) {
            if (tableName.equalsIgnoreCase("PRODUCTS")) {
                //Query for creating products table
                String productTableQuery = "CREATE TABLE IF NOT EXISTS `products` (\n"
                        + "  `ID` int(11) NOT NULL AUTO_INCREMENT,\n"
                        + "  `ProductName` varchar(255) NOT NULL,\n"
                        + "  `ProductImage` varchar(255) DEFAULT NULL,\n"
                        + "  `Color` varchar(255) DEFAULT NULL,\n"
                        + "  `Price` double NOT NULL,\n"
                        + "  `CategoryID` int(11) NOT NULL,\n"
                        + "   PRIMARY KEY (ID)\n"
                        + ");";
                try {
                    //Execute the SQL query
                    Connection con = DatabaseConnection.getConnection();
                    Statement st = con.createStatement();
                    st.executeUpdate(productTableQuery);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            return this;
        }

        //Add products to the specified table
        public Builder addToTable(String tableName, Product product) {
            if (tableName.equalsIgnoreCase("PRODUCTS")) {
                //Print the product                
                product.getAttributes();
                //Query for adding products to the products table
                //Adding the same product is blocked by the following query
                String addProductQuey = "INSERT INTO `products` (`ID`, `ProductName`, `ProductImage`, `Color`, `Price`, `CategoryID`) "
                        + "SELECT * FROM(SELECT "
                        + "NULL, "
                        + "'" + product.getProductName() + "', "
                        + "'" + product.getProductImage() + "', "
                        + "'" + product.getColor() + "', "
                        + "'" + product.getPrice() + "', "
                        + "'" + product.getCategoryID() + "') AS tmp "
                        + "WHERE NOT EXISTS (SELECT ProductName,ProductImage,Color FROM products WHERE "
                        + "ProductName='" + product.getProductName() + "' AND "
                        + "ProductImage='" + product.getProductImage() + "' AND "
                        + "Color='" + product.getColor() + "') LIMIT 1;";

                try {
                    //Execute the SQL query
                    Connection con = DatabaseConnection.getConnection();
                    Statement st = con.createStatement();
                    st.executeUpdate(addProductQuey);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            return this;
        }
    }

}
