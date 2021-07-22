package cpf.learn.chapter18.tcpSocket.tcpSocketBuffered;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/20 23:46
 * @version 1.0
 */
public class MyClient{
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(InetAddress.getLocalHost(), 10002);
		System.out.println("客户端：连接服务器成功!");

		//发送给服务器端数据
		/*如果此处的发送没有人接听，那么程序就会一直卡在这里，所以代码的顺序很重要
		* 不过之后的多并发编程就没有这个问题了，一个线程只管一条数据链路就可以了*/
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()));
		bw.write("hello,Server!");
		bw.newLine();//这起到结束的标志 跟socket.shutdownOutput同样效果
		bw.flush();//////////////////////////////////////////////////////用字符时请记住一定刷新一下！
		System.out.println("服务器端：发送数据完毕！");


		//接收服务器端信息
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		//通过readLine()读取时，发送者的newLine()就是发送结束也是读取结束的标志
		String receive = br.readLine();
		/*因此此处不需要 socket.shutdownInput*/
		System.out.println("服务器端：接收到信息 " + receive);

		//必须集中关闭，关闭任何一个流都会引起socket的关闭
		br.close();
		bw.close();

		socket.close();//固定流程，以防万一

	}
}
