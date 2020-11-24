/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B5_ThucHanhTrenSwing;

import B4_JDBC.S5_CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LegendNguyen
 */
public class DBConnection {

    static final String hostName = "127.0.0.1";
    static final String dbName = "DUNGNA_JAVA3";
    static final String userName = "dungna";
    static final String password = "12345678";
    static final String connectionURL
            = "jdbc:sqlserver://" + hostName
            + ":1433;databaseName=" + dbName;
    Connection conn;

    public DBConnection() {
    }

    Connection openConnectionDB() {
        try {
            //Bước 1:Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Bước 2: Tạo kết nối Open Connection
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    boolean closeConnectionDB() {
        try {
            conn.close();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
}
