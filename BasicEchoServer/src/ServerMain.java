import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

  final static int port = 9876;

  public static void main(String[] args) {
    try {
      ServerSocket servSoc = new ServerSocket(port);
      Socket clientSoc = servSoc.accept();
      System.out.println("Found a client");
      BufferedReader br = new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
      String msg = br.readLine();
      System.out.println("Message recieved:" + msg);
      System.out.println("Sending it back to client");
      PrintWriter pr = new PrintWriter(clientSoc.getOutputStream());
      pr.println("Hello from server, your message was recieved and it was: " + msg);
      br.close();
      pr.flush();
      pr.close();
      clientSoc.close();
      servSoc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
