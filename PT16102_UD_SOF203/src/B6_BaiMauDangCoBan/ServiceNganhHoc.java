/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B6_BaiMauDangCoBan;

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
public class ServiceNganhHoc {//Toàn bộ chức năng được đặt vào trong này   

    /*
    Phần 1 
    - Khai báo các biến toàn cục lên đầu
    - Khai báo các biến toàn cục để tái sử dụng trên các hàm
     */
    List<NganhHoc> _lstNganhHoc;
    DBConnection dBConnection = new DBConnection();//Đây là 1 class dùng để kết nối vào DB
    Statement st = null;
    ResultSet rs = null;
    NganhHoc nganhHoc = null;

    /*
    Phần 2
    - Khai báo 1 contructor trên đầu
   
     */
    public ServiceNganhHoc() {
        _lstNganhHoc = getListNganhHocDB();
    }

    /*
    Phần 3
    - Triển khai các chức năng ở dưới
   
     */
    
    
    //Hàm lấy danh sách ngành học và danh sách này đã có dữ liệu vì được gán trên contructor
    List<NganhHoc> getLstNganhHoc() {
        return _lstNganhHoc;
    }

    //Chức năng thêm ngành học vào List danh sách toàn cục ở trên
    boolean addNganhHoc(NganhHoc nganhHoc) {
        if (nganhHoc == null) {
            return false;
        }
        _lstNganhHoc.add(nganhHoc);
        return true;

    }

    //Lưu nhiều phần tử vào trong database sử dụng hàm insertNganhHocToDB
    boolean saveNganhHoc() {
        insertNganhHocToDB(_lstNganhHoc);
        _lstNganhHoc = new ArrayList<>();//Clear danh sách sau khi insert thành công vào DB
        return true;
    }

    /*
    Phần 4
    Triển khai toàn bộ các câu lệnh liên quan đến Database ở dưới phần này
    */
    //Lấy danh sách ngành học từ trong Database gán vào List<NganhHoc> trên JAVA
    List<NganhHoc> getListNganhHocDB() {

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
        } catch (Exception ex) {
            Logger.getLogger(ServiceNganhHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Hàm này dùng để insert 1 List danh sách Ngành Học vào trong cơ sở dữ liệu sử dụng kiến thức JAVA 1
    boolean insertNganhHocToDB(List<NganhHoc> lstNganhHoc) {
        try {
            st = dBConnection.openConnectionDB().createStatement();
            for (NganhHoc x : lstNganhHoc) {
                if (x.getId() == -1) {//Nó có thể là trừ bao nhiêu cũng được vì cái này được gán ở trên phần giao diện khi thêm ngành học mới
                    // -1 dùng để lọc các bản đối tượng nào là đối tượng mới được thêm
                    //Câu lệnh Insert không cần insert khóa chính là vì trong DB đã để mã tự tăng
                    String sqlInsert = "INSERT INTO [NGANHHOC]([MANGANH],[TENNGANH])"
                            + " VALUES('" + x.getMaNganh() + "','" + x.getTenNganh() + "');";
                    //Câu lệnh sqlInsert này chỉ là cộng chuỗi trong java và viết đúng với câu lệnh INSERT TRONG SQL
                    st.executeUpdate(sqlInsert);//Thực thi câu lệnh Insert SQL
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNganhHoc.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
