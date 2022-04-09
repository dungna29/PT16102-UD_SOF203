/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B8_Chat;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Anh Dung
 */
public class ChatServer extends javax.swing.JFrame {

    ChatSocket chatSocket;

    /**
     * Creates new form ChatServer
     */
    public ChatServer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Send = new javax.swing.JButton();
        txt_Chat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_AreaHistoryChat = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txt_Port = new javax.swing.JTextField();
        txt_ServerHost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Connect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Send.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn_Send.setText("Send");
        btn_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendActionPerformed(evt);
            }
        });

        txt_Chat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_AreaHistoryChat.setColumns(20);
        txt_AreaHistoryChat.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        txt_AreaHistoryChat.setRows(5);
        jScrollPane1.setViewportView(txt_AreaHistoryChat);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Poly Chat - Server");

        txt_Port.setText("1989");

        txt_ServerHost.setText("127.0.0.1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Port:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Server Host: ");

        btn_Connect.setText("Listen");
        btn_Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Chat)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btn_Connect)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ServerHost, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ServerHost, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btn_Connect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Send, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(txt_Chat))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConnectActionPerformed
        try {
            int port = Integer.parseInt(txt_Port.getText());//Lấy ra 
            ServerSocket serverSocket = new ServerSocket(port);            
            //Phương thức ở phía server sử dụng Thread
            //Nếu không sử dụng sẽ bị treo ở phía Server- tuy nhiên lắng nghe sẽ bị treo hết các hành động còn lại
            //Bởi vậy chúng ta phải sử dụng Thread để chuyển hành động lắng nghe của phía server vào trong 1 thread
            //Khi nào có 1 yêu cầu từ clien gửi tới thì sẽ tạo ra socket và không gây treo giao diện
            Thread th = new Thread() {
                public void run() {
                    try {
                        txt_AreaHistoryChat.setText(txt_AreaHistoryChat.getText() + "\n Listening...");
                        Socket socket = serverSocket.accept();//Lắng nghe yêu cầu phía client gửi tới để kết nối thì sẽ tạo ra đối tượng socket
                        txt_AreaHistoryChat.setText(txt_AreaHistoryChat.getText() + "\n Sinh viên Poly vừa tham gia chat rồi nè...");
                        chatSocket = new ChatSocket(socket, txt_AreaHistoryChat);
                    } catch (IOException ex) {
                        Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }
            };
            th.start();   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi rồi: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_ConnectActionPerformed

    private void btn_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendActionPerformed
        if (txt_Chat.getText().isEmpty() || txt_Chat.getText().isBlank()) {
            return;
        }
        chatSocket.send(txt_Chat.getText().toString());
    }//GEN-LAST:event_btn_SendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Connect;
    private javax.swing.JButton btn_Send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_AreaHistoryChat;
    private javax.swing.JTextField txt_Chat;
    private javax.swing.JTextField txt_Port;
    private javax.swing.JTextField txt_ServerHost;
    // End of variables declaration//GEN-END:variables
}
