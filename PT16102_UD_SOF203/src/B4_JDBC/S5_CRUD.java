/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B4_JDBC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Anh Dung
 */
public class S5_CRUD {
    static final String hostName = "127.0.0.1";
    static final String dbName = "DUNGNA_JAVA3";
    static final String userName = "dungna";
    static final String password = "12345678";
    static final String connectionURL
            = "jdbc:sqlserver://" + hostName
            + ":1433;databaseName=" + dbName;
    
    public static void main(String[] args) {
        try {
            //Bước 1:Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //Bước 2: Tạo kết nối Open Connection
            Connection conn = DriverManager.getConnection(connectionURL, userName, password);
            
           //Bước 3: Statment
           Statement st = conn.createStatement();
           
           //Bước 4: Tạo câu lệnh SQL
           // Insert dữ liệu vào 1 bảng trong SQL
           String sqlInsert = "INSERT INTO [NGANHHOC]([MANGANH],[TENNGANH])"
                   + " VALUES('UDPM2','Ung Dung Phan Mem2');";
           //st.executeUpdate(sqlInsert);
           int numberRowsAffected =st.executeUpdate(sqlInsert);            
           System.out.println("Thêm thành công");
           System.out.println("numberRowsAffected" + numberRowsAffected);
           st.close();
           conn.close();
        } catch (Exception ex) {
            Logger.getLogger(S5_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
             /* String sqlInsert = "INSERT INTO user(username, password, createdDAte) "
                    + " VALUE('user1', '123', now());";
            int numberRowsAffected = st.executeUpdate(sqlInsert);
            System.out.println("Affected rows after inserted: " + numberRowsAffected);
 
            // Update
            String sqlUpdate = "UPDATE user SET password='123456' WHERE id=1";
            numberRowsAffected = st.executeUpdate(sqlUpdate);
            System.out.println("Affected rows after updated: " + numberRowsAffected);
 
            // Delete
            String sqlDelte = "DELETE FROM user WHERE id=1";
            numberRowsAffected = st.executeUpdate(sqlDelte);
            System.out.println("Affected rows after deleted: " + numberRowsAffected);*/           
    
   
}
