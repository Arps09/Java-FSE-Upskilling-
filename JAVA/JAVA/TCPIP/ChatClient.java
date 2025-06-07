import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String serverMsg, clientMsg;
        while (true) {
            System.out.print("You: ");
            clientMsg = console.readLine();
            output.println(clientMsg);

            serverMsg = input.readLine();
            if (serverMsg == null) break;
            System.out.println("Server: " + serverMsg);
        }

        socket.close();
    }
}
