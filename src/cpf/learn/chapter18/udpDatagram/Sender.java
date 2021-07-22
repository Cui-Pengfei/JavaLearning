package cpf.learn.chapter18.udpDatagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author CPF 创建于： 2021/7/21 9:48
 * @version 1.0
 */
public class Sender{
	public static void main(String[] args) throws IOException{
		//1.创建一个DatagramSocket对象，准备在9999端口发送、接收数据
		DatagramSocket socket = new DatagramSocket(9999);

		System.out.println("发送端准备在9999号端口发送数据...");
		//2.把要发送的数据包装成数据报的形式,要指明发送目的地及端口
		byte[] data = "hello,明天去吃火锅!".getBytes();
		DatagramPacket packet = new DatagramPacket(data,0,data.length,
									InetAddress.getByName("192.168.1.13"), 9998);

		//3.关联socket与数据报，同时委派发送方法

		/*发送方法不会阻塞，他只负责发就完事了，收不收得到发送方不关心*/
		socket.send(packet);

		System.out.println("发送数据完成！");

		socket.close();


	}
}
