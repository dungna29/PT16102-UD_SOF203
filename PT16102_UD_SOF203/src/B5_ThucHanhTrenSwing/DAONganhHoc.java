/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B5_ThucHanhTrenSwing;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LegendNguyen
 */
public class DAONganhHoc {
    //Viết toàn bộ các câu lệnh SQL Select/Insert/Delete/Update
    DBConnection dBConnection = new DBConnection();
    Statement st = null;
    ResultSet rs = null;
    NganhHoc nganhHoc = null;
    
    public DAONganhHoc() {
    }
  
   List<NganhHoc> getListNganhHocDB(){
        try {
            List<NganhHoc> lst = new ArrayList<>();
            String sqlSelectNganhHoc ="SELECT * FROM NGANHHOC";
            st = dBConnection.openConnectionDB().createStatement();
            rs = st.executeQuery(sqlSelectNganhHoc);
            while (rs.next()) { 
                 nganhHoc = new NganhHoc(rs.getInt(1), rs.getString(2), rs.getString(3));
                 lst.add(nganhHoc);
            }
            st.close();
            //dBConnection.closeConnectionDB();
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(DAONganhHoc.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
   }
  
   
}
