/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B4_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LegendNguyen
 */
public class S2_DBConnection {

    public static void main(String[] args) {  
        try {
            S2_DBConnection bConnection = new S2_DBConnection();
            Connection conn = bConnection.getConnectionDB();
            Statement st = null;//Sql
            ResultSet rs = null;//Tập hợp các bản ghi sau khi sử câu lệnh sql truy vấn
            String sqlQuery = "SELECT * FROM [NGANHHOC]";
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(S2_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Connection getConnectionDB() {
        try {
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DUNGNA_JAVA3";
            String user = "dungna";
            String pass = "12345678";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Ket noi thanh cong");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(S2_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ket noi that bai");
        return null;
    }
}
