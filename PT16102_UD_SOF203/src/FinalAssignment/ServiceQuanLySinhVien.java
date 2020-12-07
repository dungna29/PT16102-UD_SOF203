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
public class ServiceQuanLySinhVien {

    DBConnection dBConnection = new DBConnection();//Đây là 1 class dùng để kết nối vào DB
    Statement st = null;
    ResultSet rs = null;
    SinhVien _sinhVien;
    List<SinhVien> _lstSinhVien;
    List<NganhHoc> _lstNganhHoc;
    ServiceQuanLyNganhHoc _serviceNganhHoc;

    public ServiceQuanLySinhVien() {
        _serviceNganhHoc = new ServiceQuanLyNganhHoc();
        _lstNganhHoc = _serviceNganhHoc.getLstNganhHoc();
        _lstSinhVien = getListSinhVienDB();
    }

    List<SinhVien> getListSinhVien() {
        return _lstSinhVien;
    }

    private List<SinhVien> getListSinhVienDB() {
       
        try {
            List<SinhVien> lst = new ArrayList<>();
            String sqlSelectSinhVien = "SELECT * FROM SINHVIEN";
            st = dBConnection.openConnectionDB().createStatement();
            rs = st.executeQuery(sqlSelectSinhVien);//Thực thi câu lệnh Select đổ dữ liệu ra ResultSet
            while (rs.next()) {
                _sinhVien = new SinhVien(rs.getInt(1), rs.getInt(2), getTenNganhhoc(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                lst.add(_sinhVien);//Thêm đối tượng được đọc từ bản ghi trong DB vào List của JAVA
            }
            st.close();
            return lst;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceQuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

       
    }

    private String getTenNganhhoc(int PKNganhHoc) {
        for (var x : _lstNganhHoc) {
            if (x.getId() == PKNganhHoc) {
                return x.getTenNganh();
            }
        }
        return null;
    }
}
