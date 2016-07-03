package com.networksecurity;
import java.net.InetAddress;  

public class Main {

  public static void main(String[] argv) throws Exception {

    byte[] ipAddress = new byte[] { 127, 0, 0, 1 };
    //InetAddress address = InetAddress.getByAddress(ipAddress);
    String address =InetAddress.getLocalHost().getHostAddress();
    // hostnameCanonical = address.getCanonicalHostName();
    System.out.println(address);
    String hostName = InetAddress.getLocalHost().getHostName();
    System.out.println(hostName);
  }
}