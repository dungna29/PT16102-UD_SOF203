/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B7_Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dungna89
 */
public class S2_INetAddress {

  public static void main(String[] args) {
    try {
      // To get and print InetAddress of Local Host
      InetAddress address1 = InetAddress.getLocalHost();
      System.out.println("InetAddress of Local Host : "+ address1);

      // To get and print InetAddress of Named Host
      InetAddress address2= InetAddress.getByName("ap.poly.edu.vn");
      System.out.println("InetAddress of Named Host : "+ address2);

      // To get and print ALL InetAddresses of Named Host
      InetAddress address3[]= InetAddress.getAllByName("172.19.25.29");
      for (int i = 0; i < address3.length; i++) {
        System.out.println("ALL InetAddresses of Named Host : "+ address3[i]);
      }

      // To get and print InetAddresses of
      // Host with specified IP Address
      byte IPAddress[] = {125, 0, 0, 1}; 
      InetAddress address4 = InetAddress.getByAddress(IPAddress);
      System.out.println("InetAddresses of Host with specified IP Address : "+ address4);

      // To get and print InetAddresses of Host
      // with specified IP Address and hostname
      byte[] IPAddress2
              = {105, 22, (byte) 223, (byte) 186};
      InetAddress address5 = InetAddress.getByAddress("gfg.com", IPAddress2);
      System.out.println(
              "InetAddresses of Host with specified IP Address and hostname : "+ address5);
    } catch (UnknownHostException ex) {
      Logger.getLogger(S2_INetAddress.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
