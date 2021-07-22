package cpf.learn.chapter18.tcpSocket.tcpSocketStream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/20 17:17
 * @version 1.0
 * 1.服务器端监听一个端口 new ServerSocket(portNum)
 * 2.通过serverSocket.accept()来等待请求接入，如果有请求连接的话，返回一个socket对象
 * 3.利用此socket可以建立一个与客户端的稳定连接，
 *   然后通过getInputStream读取数据；
 *   通过getOutputStream传送数据
*  4.如果一次数据读取完毕、传输完毕，记得要关闭流，
 *   还要用socket.shutdownInput()来表示此次输入已经结束
 *   用socket.shutdownOutput()来表示此次输出已经结束
 *
 *
 *
 */
public class MyServer{
	public static void main(String[] args) throws IOException{

		//1.设置监听本机服务器端口，如果此端口已被监听，是要报异常的
		ServerSocket serverSocket = new ServerSocket(9999);
		/*
		ServerSocket可以得到多个socket，服务器可以服务多个客户端嘛，
		对应于多并发编程【多个客户端连接服务器】
		 */


		System.out.println("服务端 : 正在9999端口监听...");

		//2.通过accept()方法来监听是否有对应端口的连接请求，程序会一直阻塞在这里
		Socket socket = serverSocket.accept();
		/*当有连接进来时，阻塞解除，返回一个socket对象*/
		System.out.println("服务端 : 监听到服务请求，得到socket...");

		//3.得到一个和服务端socket关联的字节输入流对象
		InputStream inputStream = socket.getInputStream();
		System.out.println("此处inputStream的运行类型 = " + inputStream.getClass().getName());
		/*
		注意此处是一个向上转型，得到的与socket相关的字节输入流实现类是SocketInputStream，
		是FileInputStream的直接子类
		 */

		byte[] buffer = new byte[1024];//1KB一读
		int readLen;
		StringBuilder receive = new StringBuilder();
		while((readLen = inputStream.read(buffer)) != -1){
			receive.append(new String(buffer, 0, readLen));
		}


		socket.shutdownInput();
		System.out.println("服务端 : 接收到信息：" + receive);

		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("hello,client!".getBytes());

		socket.shutdownOutput();

		//4.关闭输入流，
		outputStream.close();
		inputStream.close();

		//关闭socket
		socket.close();
		serverSocket.close();




	}

	@Test
	public void testSamePort() throws IOException{
		//如果是9999端口的话，就会发生端口地址被占用的异常
		//两个监听阻塞程序可以同时运行监听！
		ServerSocket serverSocket = new ServerSocket(9998);

		System.out.println("企图挤占已被监听的端口！");

		Socket accept = serverSocket.accept();
	}
}
