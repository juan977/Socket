package pe.upeu.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {
    public static void main(String[] args) throws IOException {
        String message, inFromServer;
        
        Socket clientSocket = new Socket("localhost", 6789);
        System.out.println("Connection....");
        
        Scanner inputFromUser = new Scanner(System.in);
        PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(),true);
        Scanner inputFromServer = new Scanner(clientSocket.getInputStream());
        while(true){
            System.out.print("Felipe: ");
            message = inputFromUser.nextLine();
            
            outputToServer.println(message);
            if(message.equals("**close**"))
                break;
            
            inFromServer = inputFromServer.nextLine();
            System.out.println("Server: "+inFromServer);
        }
        clientSocket.close();
    }
}
