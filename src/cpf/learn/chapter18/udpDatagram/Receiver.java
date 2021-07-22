package cpf.learn.chapter18.udpDatagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author CPF 创建于： 2021/7/21 9:49
 * @version 1.0
 */
public class Receiver{
	public static void main(String[] args) throws IOException{
		//1.创建一个DatagramSocket对象，准备在9999端口发送、接收数据
		DatagramSocket socket = new DatagramSocket(9998);
		System.out.println("在9998号端口监听...");

		//2.数据以数据报的形式发送和接收，因此必须新建一个DatagramPacket对象
		byte[] buffer = new byte[1024];//这是最保险的，因为数据报最大就是64KB(此处不需要那么大)
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

		//3.关联DatagramSocket和DatagramPacket
		System.out.println("接收端：正在接收信息...");

		/*如果没有数据传进来，这里回阻塞一直等待...*/
		socket.receive(packet);

		//4.将接收到的数据报解包
		byte[] data = packet.getData();
		/*解包出来的数组就是之前封装DatagramPacket对象时的自己设定的大小*/
		System.out.println("解包出来的字节数组长度：" + data.length);

		/*获得发送方发送来的数据实际字节长度*/
		int length = packet.getLength();
		System.out.println("实际数据长度：" + length);

		String receive = new String(data, 0, length);

		System.out.println("接收端：收到数据是 " + receive);

		socket.close();


	}
}
