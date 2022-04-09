/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B7_Socket;

/**
 *
 * @author Nguyen Anh Dung
 */
public class S1_LyThuyetCoBan {
    /*
    Lập trình mạng là tạo ra các ứng dụng làm việc với nhau thông qua môi trường mạng, 
    chẳng hạn như Web, Mail, Skype, Zalo, …
    Lập trình socket Java cung cấp cách thức để chia 
    sẻ dữ liệu giữa các thiết bị máy tính khác nhau.
    
    1. Socket là một giao diện lập trình ứng dụng (API-Application Programming Interface).
    Socket cho phép thiết 
    lập các kênh giao tiếp mà hai đầu kênh được đánh dấu bởi hai cổng (port).
    Thông qua các cổng này một quá trình có thể nhận và gởi dữ liệu với các quá trình khác.
    
    2. Port Number: Để có thể thực hiện các cuộc giao tiếp, một trong hai quá 
    trình phải công bố số hiệu cổng (port number).
    
    Server() (Port) ----TCP or UDP---- Client
    
    TCP (Transmission Control Protocol)	
    - Giao thức hướng kết nối (connection-oriented protocol), tồn tại kênh giao tiếp ảo giữa hai bên giao tiếp.
    - Dữ liệu được gởi đi theo chế độ bảo đảm: có kiểm tra lỗi. 
      truyền lại gói tin lỗi hay mất, bảo đảm thứ tự đến của các gói tin . . .	
    - Dữ liệu chính xác, Tốc độ truyền chậm.	
    - Thích hợp cho các ứng dụng cần độ chính xác cao như: truyền file, thông tin điều khiển, …	
    
    UDP (User Datagram Protocol)
    - Giao thức không kết nối (connection-less protocol), không tồn tại kênh giao tiếp ảo giữa hai bên giao tiếp.
    - Dữ liệu được gởi đi theo chế độ không bảo đảm: Không kiểm tra lỗi, 
    không phát hiện không truyền lại gói tin bị lỗi hay mất, không bảo đảm thứ tự đến của các gói tin . . .
    - Dữ liệu có thể không chính xác, tốc độ truyền nhanh
    - Thích hợp cho các ứng dụng không yêu cần độ chính xác cao nhưng cần tốc độ nhanh như: 
    truyền âm thanh, hình ảnh, …
    */
}
