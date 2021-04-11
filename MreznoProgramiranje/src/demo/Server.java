package demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		int port = 9000;
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
			System.out.println("Server osluskuje...");
			
			while(true) {
				Socket sock = ss.accept();

				ServerThread thread = new ServerThread(sock);
				thread.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
	}

}
