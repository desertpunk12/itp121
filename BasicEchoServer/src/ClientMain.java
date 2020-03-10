import java.io.*;
import java.net.Socket;

public class ClientMain {

  final static String address = "localhost";
  final static int port = 9876;
  public static void main(String[] args) {
    try {
      Socket soc = new Socket(address, port);
      PrintWriter pw = new PrintWriter(soc.getOutputStream());
      String msg = "Hello World of Network";
      pw.println(msg);
      pw.flush();
      System.out.println("Message Sent! it was:" + msg);
      BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
      System.out.println(br.readLine());
      pw.close();
      br.close();
      soc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }


}
