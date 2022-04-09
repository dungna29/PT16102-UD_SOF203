/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B7_Socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Nguyen Anh Dung
 */
public class EchoChatSingleServer {
      public final static int SERVER_PORT = 7;
 
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
 
                    OutputStream os = socket.getOutputStream();
                    InputStream is = socket.getInputStream();
                    int ch = 0;
                    while (true) {
                        ch = is.read(); // Receive data from client
                      
                        if (ch == -1) {
                            break;
                        }
                        os.write(ch); // Send the results to client
                        System.out.print(Character.toString(ch) +" ");
                    }
                    socket.close();
                } catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
