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
public class S4_Statement_CauLenhThucThi {
    /*
        [Statement]  
        Statement interface trong java cung cấp các phương thức để thực thi các câu lệnh truy vấn với cơ sở dữ liệu SQL.
        Statement cung cấp phương thức để tạo ra đối tượng ResultSet.
    
        Thực thi câu lệnh truy vấn SQL (Execute Query)       
        Như chúng ta biết, có thể có nhiều loại truy vấn. Một trong số đó là:
            - Truy vấn để cập nhật (update) / chèn (insert)/ xóa (delete) trong cơ sở dữ liệu.
            - Truy vấn để lấy dữ liệu (select).
    
        Statement cung cấp một số phương thức để thực thi truy vấn SQL tương ứng với các loại trên:
            - Phương thức executeQuery() : được sử dụng để thực hiện các truy vấn truy xuất giá trị từ cơ sở dữ liệu (select). 
            Phương thức này trả về đối tượng ResultSet có thể được sử dụng để lấy tất cả các dữ liệu (record) của bảng.
            - Phương thức executeUpdate() : được sử dụng để thực hiện các truy vấn insert/ update/ delete.
            - Phương thức execute() : có thể thực thi cả 2 trường hợp trên. Nếu phương thức statement.getUpdateCount() trả về số lượng record bị affect.
            - Nếu giá trị > 0, có nghĩa là thực thi các câu lệnh insert/ update/ delete.
            - Nếu giá trị = 0, có nghĩa là thực thi các câu lệnh insert/ update/ delete không có dòng nào bị ảnh hưởng hoặc thực thi 
            câu lệnh cập nhật data structure.
            - Nếu giá trị = -1, có nghĩa là thực thi câu lệnh select. Khi đó, có thể gọi tiếp lệnh statement.getResultSet() để lấy ResultSet.
        [ResultSet]
    */
   
   
}
