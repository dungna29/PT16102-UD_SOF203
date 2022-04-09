/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B7_Socket;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Nguyen Anh Dung
 */
public class EchoChatClient {

    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7;

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            for (int i = '0'; i <= '9'; i++) {
                os.write(i); // Send each number to the server
                int ch = is.read(); // Waiting for results from server
                System.out.print((char) ch + " "); // Display the results received from the server
                Thread.sleep(200);
            }
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
