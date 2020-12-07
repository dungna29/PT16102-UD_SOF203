/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalAssignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LegendNguyen
 */
public class ServiceQuanLyNganhHoc {

    DBConnection dBConnection = new DBConnection();//Đây là 1 class dùng để kết nối vào DB
    Statement st = null;
    ResultSet rs = null;
    NganhHoc nganhHoc = null;
    List<NganhHoc> _lstNganhHoc = new ArrayList<>();

    public ServiceQuanLyNganhHoc() {
        _lstNganhHoc = getListNganhHocDB();
    }

    public List<NganhHoc> getLstNganhHoc() {
        return _lstNganhHoc;
    }

    //Lấy danh sách từ DB ngành học
    private List<NganhHoc> getListNganhHocDB() {       
        try {
            List<NganhHoc> lst = new ArrayList<>();
            String sqlSelectNganhHoc = "SELECT * FROM NGANHHOC";
            st = dBConnection.openConnectionDB().createStatement();
            rs = st.executeQuery(sqlSelectNganhHoc);//Thực thi câu lệnh Select đổ dữ liệu ra ResultSet
            while (rs.next()) {
                nganhHoc = new NganhHoc(rs.getInt(1), rs.getString(2), rs.getString(3));
                lst.add(nganhHoc);//Thêm đối tượng được đọc từ bản ghi trong DB vào List của JAVA
            }
            st.close();
            return lst;          
          
        } catch (SQLException ex) {            
            Logger.getLogger(ServiceQuanLyNganhHoc.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }

}
