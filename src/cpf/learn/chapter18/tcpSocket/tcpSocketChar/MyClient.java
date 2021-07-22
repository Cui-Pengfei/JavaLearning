package cpf.learn.chapter18.tcpSocket.tcpSocketChar;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/20 23:00
 * @version 1.0
 * 注意细节：
 * 流的关闭必须在最后统一关闭，事实证明，关闭任何一个单一流，socket就跟着关闭了
 */
public class MyClient{
	public static void main(String[] args) throws IOException{

		Socket socket = new Socket(InetAddress.getLocalHost(), 10001);
		System.out.println("客户端 : socket连接成功!");

		OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
		writer.write("hello,server!");
		writer.flush();//如果使用字符流，必须手动刷新一下，不然数据不会自动写入通道
		socket.shutdownOutput();
		System.out.println("客户端 : 传送完毕！");


		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		char[] buffer = new char[100];
		int readLen;
		StringBuilder sb = new StringBuilder();
		while((readLen = reader.read(buffer)) != -1){
			sb.append(buffer, 0, readLen);
		}

		socket.shutdownInput();
		System.out.println("客户端 : 接收信息 " + sb);
		System.out.println("客户端 : 接受信息完毕！");

		writer.close();
		reader.close();


		socket.close();


	}
}
