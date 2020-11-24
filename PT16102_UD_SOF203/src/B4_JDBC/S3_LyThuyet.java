package B4_JDBC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nguyen Anh Dung
 */
public class S3_LyThuyet {

    /*
        1. JDBC là gì?JDBC (Java Database Connectivity) là một API chuẩn dùng để tương tác với
        các loại cơ sở dữ liệu quan hệ (database relationship). JDBC bao gồm một tập hợp các class 
        và các interface dùng cho ứng dụng Java có thể giao tiếp với các cơ sở dữ liệu (database) khác nhau.

        - JDBC có thể làm việc với bất kỳ cơ sở dữ liệu (MySQL, PostgreSQL, Oracle, SQL Server, …) 
        dựa vào một Driver được cung cấp.
        JDBC API bao gồm hai package chính:
        java.sql : là một phần của Java standard.
        javax.sql : là một phần của Java enterprise.
    
        2. Các thành phần của JDBC:
        - DriverManager : là một class quản lý danh sách các Driver (database drivers). 
        Các yêu cầu kết nối từ ứng dụng Java sẽ được class này tìm kiếm Driver phù hợp 
        đầu tiên để thiết lập kết nối với cơ sở dữ liệu.
        - Driver: là một interface dùng để xử lý các giao tiếp với cơ sở dữ liệu. 
        Thông thường ứng dụng Java sẽ không giao tiếp trực tiếp với class này mà thông qua DriverManager.
        - Connection : là một interface cung cấp tất cả các method cần thiết cho việc giao tiếp với database. 
        Interface này chứa nhiều phương thức đa dạng để tạo kết nối với một Database. 
        Tất cả các thông tin giao tiếp với cơ sở dữ liệu chỉ có thể thông qua đối tượng Connection. 
        Một Connection đại diện cho một phiên (session) làm việc với cơ sở dữ liệu.
        - Statement : là một interface cho phép gửi các câu lệnh SQL tới Database. 
        Ngoài ra, một số Interface kết thừa từ nó cung thêm các tham số để thực
        thi các thủ tục đã được lưu trữ (stored procedure).
        - ResultSet : đại diện cho tập hợp các bản ghi (record) có được sau khi thực hiện truy vấn (query).
        - SQLException : class này xử lý bất cứ lỗi nào xuất hiện trong khi làm việc với Database.
    
        3. Để làm việc với JDBC, bạn cần cài đặt Java và một cơ sở dữ liệu (database). 
        Bạn có thể sử dụng bất kỳ database nào, chẳng hạn MySQL.
    
        4. Các bước giao tiếp giữa JAVA và Database:
        - Load Driver.
        - Tạo kết nối (Open Connection).
        - Tạo câu lệnh truy vấn SQL (Statement).
        - Thực thi câu lệnh truy vấn SQL (Execute Query).
        - Đóng kết nối (Close Connection).
    
        5.Statement
        Các interface JDBCStatement, CallableStatement và PreparedStatement xác định các phương 
        thức cho phép gửi các lệnh SQL và nhận dữ liệu từ cơ sở dữ liệu.
        Statement st = con.createStatement();
    
        6. Đóng kết nối (Close Connection)
        - Cuối cùng, sau khi đã sử dụng chúng ta cần phải gọi phương thức close()
        để đóng kết nối (Connection) và giải phóng tài nguyên.
    
        - Bằng cách đóng kết nối, các đối tượng của Statement và ResultSet sẽ được đóng tự động. 
        - Tuy nhiên, chúng ta nên tập thói quen close() Statement sau khi sử dụng thay vì chờ đợi điều 
        đó xảy ra khi nó tự động bị đóng để giải phóng tài nguyên. Đặc biệt nếu chúng ta thực thi 
        Statement trong vòng lặp, thì có thể sẽ gặp vấn đề về thiếu tài nguyên 
        sử dụng nếu chờ đợi nó tự động đóng.
    
        - Khi Statement được close() thì ResultSet của Statement cũng được close.   
     */
    static final String hostName = "127.0.0.1";
    static final String dbName = "DungNA_ShopFPT";
    static final String userName = "dungna";
    static final String password = "12345678";
    static final String connectionURL
            = "jdbc:sqlserver://" + hostName
            + ":1433;databaseName=" + dbName;

    public static void main(String[] args) {
        try {
            // Bước 1: Load Driver           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Bước 2: Tạo kết nối - Open connection
            Connection conn = DriverManager.getConnection(connectionURL, userName, password);
            
            // Bước 3: Tạo Statement sau đó mới thực thi câu lệnh SQL
            Statement st = conn.createStatement();
            
            // Bước 4: Excute Query - Tạo ra câu lệnh SQL ở JAVA 
            String sqlQuery = "SELECT * FROM CHUCVU";//Toàn bộ bên trong chuỗi này là 1 câu lệnh SQL
            //Test câu SQL ở trên hệ quản trị cơ sở dữ liệu trước rồi copy vào trong JAVA.
            ResultSet rs = st.executeQuery(sqlQuery);
            //tiếp tục thực hiện các hành như gán dữ liệu từ câu truy vấn về vào các đối tượng
            st.close();
            
            // Bước 5: Đóng kết nối - Close Connection
            conn.close();
            System.out.println("Đã kết nối thành công");
        } catch (Exception ex) {
              System.out.println("Đã kết nối thất bại");
            Logger.getLogger(S3_LyThuyet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
