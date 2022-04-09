/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B7_Socket;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 *
 * @author Nguyen Anh Dung
 */
public class EchoChatMultiServer {

  public static final int NUM_OF_THREAD = 4;
  public final static int SERVER_PORT = 7;

  public static void main(String[] args) throws IOException {
    ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
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

          WorkerThread handler = new WorkerThread(socket);
          executor.execute(handler);
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
