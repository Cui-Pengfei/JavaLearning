package cpf.learn.chapter18.tcpSocket.tcpSocketStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/20 17:55
 * @version 1.0
 *
 *   1.客户端监建立一个套接字用于连接相关的服务器端的相关接口
 *   2.利用此socket可以建立一个与服务器端的稳定连接，
 *     然后通过getInputStream读取数据；
 *     通过getOutputStream传送数据
 *   3.如果一次数据读取完毕、传输完毕，记得要关闭流，
 *     还要用socket.shutdownInput()来表示此次输入已经结束
 *     用socket.shutdownOutput()来表示此次输出已经结束
 */
public class MyClient{
	public static void main(String[] args) throws IOException{
		//1.连接服务端（ip,端口）
		/*由于此处服务器端监听的就是本机的端口，因此服务器端就是本机，如果远程的话，可以通过域名*/
		//连接本机的9999端口，如果连接成功，会返回一个socket对象
		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
		System.out.println("客户端 : socket连接成功！");

		//2.得到一个和socket关联的字节输出流对象，通过输出流对象的方法来传输数据
		OutputStream outputStream = socket.getOutputStream();//(注意此处一定是向上转型)
		System.out.println("此处outputStream的运行类型 = " + outputStream.getClass().getName());
		/*
		注意此处是一个向上转型，得到的与socket相关的字节输出流实现类是SocketOutputStream，
		是FileOutputStream的直接子类，说明与套接字相关联的网络传输流也是节点流，毕竟有固定的【客户端】、【服务端】
		 */
		outputStream.write("hello,server!".getBytes());
		//关闭流对象，socket不会帮助关闭、

		//此时必须表示你已经传输完了
		socket.shutdownOutput();
		System.out.println("客户端 : 传输完毕！");

		//3.还是通过这个socket套接字建立的管道，再接收来自服务端的数据

		InputStream inputStream = socket.getInputStream();
		byte[] buffer = new byte[1024];
		StringBuilder receive = new StringBuilder();
		int readLen;
		while((readLen = inputStream.read(buffer)) != -1){
			receive.append(new String(buffer, 0, readLen));
		}

		//此时必须表示接收完毕
		socket.shutdownInput();
		System.out.println("客户端 : 接收到信息 " + receive);
		System.out.println("客户端 : 接收数据完毕！");

		outputStream.close();
		inputStream.close();


		//4.关闭socket,socket数量有限，不关闭的话，后来的可能连接不上
		socket.close();


	}
}
