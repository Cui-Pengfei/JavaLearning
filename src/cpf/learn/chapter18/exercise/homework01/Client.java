package cpf.learn.chapter18.exercise.homework01;

import cpf.learn.chapter18.tcpSocket.tcpSocketBuffered.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 15:08
 * @version 1.0
 */
public class Client{
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		System.out.println("客户端连接9999端口成功！");
		String send;
		String receive;

		BufferedWriter bw = null;
		BufferedReader br = null;

		for(int i = 0; i < 3; i++){
			//先传递一个消息，目的是提一个问题
			send = getSendContent(i);
			System.out.println("我提问题 : " + send);
			bw = StreamUtils.sendByBuffered(socket.getOutputStream(), send);

			//再获得一个答案
			System.out.println("等待服务端回答问题中....");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			receive = br.readLine();
			System.out.println("对方回答 : " + receive);

		}

		bw.close();
		br.close();
		socket.close();
	}

	public static String getSendContent(int num){
		String send;
		switch(num){
			case 0:
				send = "name";
				break;
			case 1:
				send = "hobby";
				break;
			case 2:
				send = "gender";
				break;
			default:
				send = "戏耍你呢！";
		}
		return send;
	}
}
