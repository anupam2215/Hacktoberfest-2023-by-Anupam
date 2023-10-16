import java.io.*;
import java.net.*;

public class SocketServerExample {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server listening on port 12345...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, client!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Client said: " + message);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
