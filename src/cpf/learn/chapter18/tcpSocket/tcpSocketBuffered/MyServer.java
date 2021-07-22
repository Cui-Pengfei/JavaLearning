package cpf.learn.chapter18.tcpSocket.tcpSocketBuffered;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/20 23:36
 * @version 1.0
 * 这是使用BufferedWriter BufferedReader来进行数据交换，
 * 效率很高，且有一些特殊的规则需要记住：
 * 1.当输出数据的时候，一定要flush一下，才可以把数据写入管道，这既针对字符流，也针对缓冲流
 * （实质上，字符流是一种小型的缓冲流）
 * 2.写入数据后，如果想结束，可以不必用socket.shutdownOutput，可以写入一个newLine(),规定一个newLine()就表示输出结束
 * 3.同样，读入的时候，可以不使用socket.shutdownInput()，因为读到newLine()的时候自然知道这是结束了！
 *
 */
public class MyServer{
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(10002);
		System.out.println("服务器端：监听10002端口的连接...");
		Socket socket = serverSocket.accept();

		//接收客户端信息
		BufferedReader br = new BufferedReader(
								new InputStreamReader(
										socket.getInputStream()));
		//通过readLine()读取时，发送者的newLine()就是发送结束也是读取结束的标志
		String receive = br.readLine();
		/*因此此处不需要 socket.shutdownInput*/
		System.out.println("服务器端：接收到信息 " + receive);

		//发送给客户端数据
		BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(
									socket.getOutputStream()));
		bw.write("hello,Client!");
		bw.newLine();//这起到结束的标志 跟socket.shutdownOutput同样效果
		bw.flush();///////////////////////////////////////////////////////记住一定刷新一下
		System.out.println("服务器端：发送数据完毕！");

		//必须集中关闭，关闭任何一个流都会引起socket的关闭
		br.close();
		bw.close();

		socket.close();//固定流程，以防万一
		serverSocket.close();

	}
}
