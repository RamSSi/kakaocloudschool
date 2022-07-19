package lecture0718.exam03;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class CThread implements Runnable {
	ArrayList<Socket> socketList = new ArrayList<Socket>();
	
	@Override
	public void run() {
		Socket socket;
		BufferedReader br;
		PrintWriter pr;
		Exam03_Client c = new Exam03_Client("annonymous", socket, br, pr);
		socketList.add(socket);
		c.launch();
	}
}