/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1_AWT;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S1_DemoAWT extends Frame implements ActionListener {

   Button btnRed, btnYellow;// Khởi tạo 2 nút Yellow và Red
    Label label = new Label();//Khởi tạo 1 nhãn

    public S1_DemoAWT(String msg) {
        setTitle(msg);//Set tên form bằng setTile
        setLayout(new FlowLayout());//Set bố trí các nút khi hiển thị
        btnYellow = new Button("Yellow");//Đặt tên cho nút khi hiển thị
        btnRed = new Button("Red");//Đặt tên cho nút là đỏ khi hiển thị
        add(btnYellow);//Thêm các nút vào frame
        add(btnRed);
        add(label);
        btnYellow.addActionListener(this);//Tạo các sự kiện khi click vào các nút
        btnRed.addActionListener(this);
    }
    public static void main(String[] args) {
        S1_DemoAWT ab = new S1_DemoAWT("AWT FORM FPOLY");//Truyền vào tên của form
        ab.setSize(450, 300);//Chiều dài form là 450px và chiều rộng là 200px
        ab.show();//Phương thức show để hiển thị form lên màn hình
    }

   @Override
    public void actionPerformed(ActionEvent e) {
        //Gọi sự kiện xử lý tương ứng khi người dùng click vào 2 nút mầu sắc
        String str = e.getActionCommand();
        if (str.equals("Yellow")) {          
            label.setSize(200, 20);
            label.setText("Ban dang chon mau vang");
            this.setBackground(Color.yellow);
        }
        if (str.equals("Red")) {
            label.setSize(200, 20);
            label.setText("Ban dang chon mau do");
            this.setBackground(Color.red);
        }
    }

    

}
