package cpf.learn.chapter18.udpDatagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author CPF 创建于： 2021/7/21 11:41
 * @version 1.0
 */
public class Mary{
	public static void main(String[] args) throws IOException{
		DatagramSocket socket = new DatagramSocket(22222);
		System.out.println("mary在22222端口监听数据...");


		//mary收消息
		System.out.println("收件：");
		byte[] buffer = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		socket.receive(receivePacket);

		byte[] data1 = receivePacket.getData();
		int length = receivePacket.getLength();
		String receive = new String(data1, 0, length);
		System.out.println(receive);

		//mary发消息
		System.out.println("发件：\n ok, tom, 明天一起去吃火锅！");
		byte[] data =
				("邮件:" + "\n" +
						"ok, tom, 明天一起去吃火锅！\n" +
						"\t\t\t--- by mary").getBytes();
		DatagramPacket sendPacket = new DatagramPacket(data, data.length,
				InetAddress.getByName("192.168.1.13"), 11111);
		socket.send(sendPacket);

		socket.close();
	}
}
