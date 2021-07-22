package cpf.learn.chapter18.netstat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 3:42
 * @version 1.0
 */
public class Server{
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(11111);
		System.out.println("服务器端正在监听11111号端口...");
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		byte[] buffer = new byte[1024];
		int readLen;
		StringBuilder sb = new StringBuilder();
		while((readLen = is.read(buffer)) != -1){
			sb.append(new String(buffer, 0, readLen));
		}
		//故意不结束读取
		//也故意不关闭socket

		//服务器端也读
		InputStream inputStream = socket.getInputStream();
		inputStream.read(new byte[1024]);


	}
}
