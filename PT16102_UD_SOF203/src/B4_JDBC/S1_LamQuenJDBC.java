/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B4_JDBC;

/**
 *
 * @author LegendNguyen
 */
public class S1_LamQuenJDBC {
    /*     
    JDBC là 1 API giúp giao tiếp được với cơ sở dữ liệu và nó tập hợp các Class và Interface  
    1. DriverManager : là một class quản lý danh sách các Driver (database drivers).
        Các yêu cầu kết nối từ ứng dụng Java sẽ được class này tìm kiếm Driver phù hợp đầu tiên để thiết 
        lập kết nối với cơ sở dữ liệu.
    2. Driver: là một interface dùng để xử lý các giao tiếp với cơ sở dữ liệu. 
       Thông thường ứng dụng Java sẽ không giao tiếp trực tiếp với class này mà thông qua DriverManager.
    3. Connection : là một interface cung cấp tất cả các method cần thiết cho việc giao tiếp với database. 
        Interface này chứa nhiều phương thức đa dạng để tạo kết nối với một Database. 
        Tất cả các thông tin giao tiếp với cơ sở dữ liệu chỉ có thể thông qua đối tượng Connection.
        Một Connection đại diện cho một phiên (session) làm việc với cơ sở dữ liệu.
    4. Statement : là một interface cho phép gửi các câu lệnh SQL tới Database. 
        Ngoài ra, một số Interface kết thừa từ nó cung thêm các tham số để thực thi các thủ tục
        đã được lưu trữ (stored procedure).
    5. ResultSet : đại diện cho tập hợp các bản ghi (record) có được sau khi thực hiện truy vấn (query).
    6. SQLException : class này xử lý bất cứ lỗi nào xuất hiện trong khi làm việc với Database.    
    
    Để kết nối với database, chúng ta cần load driver và register nó với ứng dụng. 
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    */
    
}
