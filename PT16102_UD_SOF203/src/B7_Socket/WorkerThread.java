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
public class WorkerThread extends Thread {

    private Socket socket;

    public WorkerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Processing: " + socket);
        try {
            OutputStream os = socket.getOutputStream();
            //Read bytes
            InputStream is = socket.getInputStream();            
            while (true) {
                int ch = is.read(); // Receive data from client
                if (ch == -1) {
                    break;
                }
                os.write(ch); // Send the results to client
                System.out.print(Character.toString(ch) +" ");
            }
        } catch (IOException e) {
            System.err.println("Request Processing Error: " + e);
        }
        System.out.println("Complete processing: " + socket);
    }
}
