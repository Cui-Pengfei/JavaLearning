package cpf.learn.chapter18.tcpSocket.fileCopy.server;

import cpf.learn.chapter18.tcpSocket.fileCopy.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 1:35
 * @version 1.0
 */
public class MyServer{
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("服务器端正在监听8888端口的连接请求...");
		Socket socket = serverSocket.accept();

		//边接收边把数据写入硬盘
		//图片文件存放路径
		File picture =
				new File("src/cpf/learn/chapter18/tcpSocket/fileCopy/server/girl.jpg");

		BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(picture));

		StreamUtils.inAndOut(bis, bos);

		//图片读完应该就可以关闭与文件的交互流
		bos.close();//这个关闭应该不会影响网络传输
		System.out.println("文件读取结束，也写入硬盘结束了...");

		//传完之后，由于是字节流，需要shutdownInput一下
		socket.shutdownInput();

		//发送收到图片的信息
		BufferedWriter writer = new BufferedWriter(
										new OutputStreamWriter(
												socket.getOutputStream()));
		writer.write("收到图片");
		writer.newLine();//发送结束的标志
		writer.flush();//////////////////////不用写结束，但一定要写刷新

		writer.close();
		bis.close();

		socket.close();
		serverSocket.close();


	}
}
