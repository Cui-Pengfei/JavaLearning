package cpf.learn.chapter18.circleTransfer.bufferedWriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/22 13:27
 * @version 1.0
 */
public class Server{
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("服务器端在8888端口监听...");
		Socket socket = serverSocket.accept();

		int chatContent = 0;
		BufferedWriter bw = null;
		BufferedReader br = null;
		String receiveLine;

		do{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			receiveLine = br.readLine();
			System.out.println(receiveLine);

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("Server : " + (++chatContent));
			System.out.println("Server : " + chatContent);
			bw.newLine();
			bw.flush();
		}while(true);
	}
}
