package cpf.learn.chapter18.udpDatagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author CPF 创建于： 2021/7/21 11:28
 * @version 1.0
 */
public class Tom{
	public static void main(String[] args) throws IOException{
		DatagramSocket socket = new DatagramSocket(11111);
		System.out.println("tom在11111端口监听数据...");
		//tom发消息
		System.out.println("发件：\n hi, mary, 明天去吃火锅吗？");
		byte[] data =
				("邮件:" + "\n" +
				 "hi, mary, 明天去吃火锅吗？\n" +
						"\t\t\t--- by tom").getBytes();
		DatagramPacket sendPacket = new DatagramPacket(data, data.length,
										InetAddress.getByName("192.168.1.13"), 22222);
		socket.send(sendPacket);


		//tom受消息
		System.out.println("收件：");
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		socket.receive(receivePacket);

		byte[] data1 = receivePacket.getData();
		int length = receivePacket.getLength();
		String receive = new String(data1, 0, length);
		System.out.println(receive);

		socket.close();


	}
}
