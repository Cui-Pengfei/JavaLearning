package cpf.learn.chapter18.tcpSocket.fileCopy.client;

import cpf.learn.chapter18.tcpSocket.fileCopy.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 1:14
 * @version 1.0
 */
public class MyClient{
	public static void main(String[] args) throws IOException{
		//1.找到图片文件
		File picture =
				new File("src/cpf/learn/chapter18/tcpSocket/fileCopy/client/girl.jpg");
		//基于健壮性来考虑，应该判断一下图片是否存在(之后在考虑)

		//2.由于图片都比较大，边读边传送应该更好
		Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(picture));
		StreamUtils.inAndOut(bis, bos);

		bos.flush();//如果使用OutputStream在Socket上传输，就不需要flush
		//图片读完应该就可以关闭与文件的交互流
		bis.close();//这个关闭应该不会影响网络传输


		System.out.println("文件读取结束，也传送结束了...");

		//3.传完之后，由于是字节流，需要shutdownInput一下，如果不关一下是不能继续读到信息的
		socket.shutdownOutput();


		//4.要等待服务端传送来“收到图片”的消息，来关闭流和socket
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		String confirm = reader.readLine();
		if(confirm.equals("收到图片")){
			bos.close();
			socket.close();
		}else{
			System.out.println("没有收到确认消息！");
		}
	}
}
