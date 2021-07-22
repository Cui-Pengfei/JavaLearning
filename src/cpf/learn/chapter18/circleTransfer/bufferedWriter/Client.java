package cpf.learn.chapter18.circleTransfer.bufferedWriter;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/22 13:28
 * @version 1.0
 * 规定：
 *      如果写出的是newLine()则表示本次写出结束，不必socket.shutdownOutput()
 *      如果读到了newLine则表示本次读入结束，不必socket.shutdownInput()
 *
 */
public class Client{
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(InetAddress.getByName("192.168.1.13"), 8888);
		System.out.println("客户端连接服务端8888端口成功！");

		int chatContent = 0;
		BufferedWriter bw = null;
		BufferedReader br = null;
		String receiveLine;

		do{
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("Client : " + (++chatContent));
			System.out.println("Client : " + chatContent);
			bw.newLine();
			bw.flush();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			receiveLine = br.readLine();
			System.out.println(receiveLine);
		}while(true);
	}
}
