package pe.upeu.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1Socket {

	public static void main(String[] args) throws IOException {
	String msg;
	String inFromServer;
	int puerto = 6789;
	String ip = "localhost";
	
	Socket clienteSocket = new Socket(ip, puerto);
	System.out.println("Connection...");
	
	Scanner inputFromUser = new Scanner(System.in);
	PrintWriter outputToServer = new PrintWriter(clienteSocket.getOutputStream(),true);
    Scanner inputFromServer = new Scanner(clienteSocket.getInputStream());
	while (true) {
		System.out.println("Asistente: ");
		msg = inputFromServer.nextLine();
		
		outputToServer.print(msg);
		if (msg.equals("**close**")) {
			break;
		}
		clienteSocket.close();
	}
}
}