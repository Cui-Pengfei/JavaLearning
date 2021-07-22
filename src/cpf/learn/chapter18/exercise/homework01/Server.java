package cpf.learn.chapter18.exercise.homework01;

import cpf.learn.chapter18.tcpSocket.tcpSocketBuffered.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 15:05
 * @version 1.0
 */
public class Server{
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("服务器端正在9999端口监听...");
		Socket socket = serverSocket.accept();

		String receive;
		String answer;

		BufferedWriter bw = null;
		BufferedReader br = null;

		for(int i = 0; i < 3; i++){

			System.out.println("等待客户端提问中...");
			//先得到一个问题
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			receive = br.readLine();//直接读才对
			System.out.println("得到问题 : " + receive);

			//先传递一个消息，目的是提一个问题
			answer = getAnswer(receive.toString());
			System.out.println("我回答 : " + answer);
			bw = StreamUtils.sendByBuffered(socket.getOutputStream(), answer);
		}

		bw.close();
		br.close();
		socket.close();
		serverSocket.close();
	}

	public static String getAnswer(String question){
		if(question.equals("name")) return "我是nova";
		if(question.equals("hobby")) return "编写java程序";
		return "你说啥呢？";
	}
}
