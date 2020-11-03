/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1_AWT;
import javax.swing.JFrame;

public class S2_MyFramePOLY_SWING extends JFrame {

    public S2_MyFramePOLY_SWING() {
        setTitle("POLY 2: My new Frame");
        setLocationRelativeTo(null); //ra giữa màn hình
        setDefaultCloseOperation(EXIT_ON_CLOSE);//tự động đóng khi thoát form khi người dùng click vào nút close
        setSize(300, 200);
        setResizable(false); //không cho thay đổi kích thước màn hình
        setVisible(true);//Hiển thị Jframe trên màn hình khi cần gọi hiển thị
       
    }
    public static void main(String[] args) {
        new S2_MyFramePOLY_SWING();
    }
}
