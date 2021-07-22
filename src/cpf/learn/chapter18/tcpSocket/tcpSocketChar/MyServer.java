package cpf.learn.chapter18.tcpSocket.tcpSocketChar;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/20 22:49
 * @version 1.0
 * 这是用字符流来读取、传输数据
 * 流的关闭必须在最后统一关闭，事实证明，关闭任何一个单一流，socket就跟着关闭了
 */
public class MyServer{
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(10001);

		System.out.println("服务器端：监听端口10001连接中...");
		Socket socket = serverSocket.accept();

		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		char[] buffer = new char[100];
		int readLen;
		StringBuilder sb = new StringBuilder();
		while((readLen = reader.read(buffer)) != -1){
			sb.append(buffer, 0, readLen);
		}
		socket.shutdownInput();
		System.out.println("服务器端：接收信息 " + sb);
		System.out.println("服务器端：接收信息完毕！");

		OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
		writer.write("hello,Client!");
		writer.flush();//刷新数据
		System.out.println("服务器端：发送信息完毕！");
		socket.shutdownOutput();

		writer.close();
		reader.close();

		socket.close();
		serverSocket.close();


	}
}
