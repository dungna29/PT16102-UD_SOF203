/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B1_AWT;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dungna
 */
public class S3_TaoNutTuDong_SWING extends JFrame {

    public S3_TaoNutTuDong_SWING() {
        setTitle("My Flow Layout");
        setLocation(200, 200);
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p = new JPanel(); //Flow Layout
         //JPanel p= new JPanel(new GridLayout(3, 3));
        add(p);
        JButton buttons[] = new JButton[15];
        for (int i = 0; i < 15; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            p.add(buttons[i]);
        }
        setVisible(true);
    }
//    public S3_TaoNutTuDong() {
//        setTitle("My Flow Layout");
//        setLocation(200, 200);
//        setSize(400, 200);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        JPanel p = new JPanel(); //Flow Layout
//        //JPanel p = new JPanel(new GridLayout(3, 3));
//        add(p);
//        JLabel label[] = new JLabel[15];
//        for (int i = 0; i < 15; i++) {
//            label[i] = new JLabel("LABEL POLY " + (i + 1));
//            p.add(label[i]);
//        }
//        setVisible(true);
//    }

    public static void main(String[] args) {
        new S3_TaoNutTuDong_SWING();
    }

}
