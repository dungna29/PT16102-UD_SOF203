/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B8_Chat;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Nguyen Anh Dung
 */
public class ChatSocket {

    private Socket socket;//Khai báo tên đối tượng socket hay thông tin socket truyền vào
    private JTextArea txtHisotryMess;//Khai báo Control hiển thị text khi chat giữa 2 bên
    private PrintWriter out;//Đối tượng cho phép gửi dữ liệu đi
    private BufferedReader reader;//Cho phép nhận dữ liệu thông qua socket

    //Xây dựng contructor truyền  2 thông tin socket và control
    public ChatSocket(Socket socket, JTextArea txtHisotryMess) throws IOException {
        this.socket = socket;
        this.txtHisotryMess = txtHisotryMess;
        //Khi sử dụng input và output cần sử dụng Trycatch hoặc throws
        out = new PrintWriter(socket.getOutputStream());//Dùng để gửi dữ liệu
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        receive();//Khởi Tạo ra quá trình nhận từ phía socket
    }

    //Phương thức cho phép nhận dữ liệu vào thông qua luồng đọc reader
    private void receive() {
        Thread th = new Thread(){
            @Override
            public void run() {
                while (true) {//Lặp lại liên tục và tiến hành đọc dữ liệu từ Reader                    
                    try {
                        String line = reader.readLine();//Đọc 1 dòng
                        if (line!= null) {//Nếu line đọc được != null thì sẽ bổ sung thêm text vào cho control
                            txtHisotryMess.setText(txtHisotryMess.getText() +"\n Nhận:" + line);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();//In ra lỗi
                    }
                }
            }            
        };
        th.start();//Bắt đầu Thread
    }
    
    //Phương thức gửi dữ liệu sử dụng truyền String để gửi
    public void send(String msg){
        String current = txtHisotryMess.getText();//Lấy lịch sử nội dung hiện tại lưu vào 1 biến String    
        txtHisotryMess.setText(current + "\n Gửi: " + msg);//Lấy nội dung hiện tại + chuỗi với msg muốn gửi.
        out.println(msg);//Cho phép gửi dữ liệu thông qua luồng ghi       
        out.flush();//Dữ liệu sẽ được đẩy từ bộ đệm sang bên cần gửi
        //Nếu ko dùng phương thức này thì sẽ dữ liệu sẽ vẫn nằm ở bên của phía người gửi.
    }
    //Đóng các luồng ghi đọc và socket
    public void close(){
        try {
            out.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
