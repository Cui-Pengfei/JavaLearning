package cpf.learn.chapter18.downloadMusic.client;

import cpf.learn.chapter18.downloadMusic.Tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/22 9:27
 * @version 1.0
 */
public class Client{
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket(InetAddress.getByName("192.168.1.13"),8888);
		System.out.println("客户端连接服务器8888端口成功！");

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String send;

		//传送歌曲名称
		send = "天空之城.mp3";
		bos = new BufferedOutputStream(socket.getOutputStream());
		bos.write(send.getBytes());
		bos.flush();
		socket.shutdownOutput();

		//接收服务端传过来的歌曲字节数组
		bis = new BufferedInputStream(socket.getInputStream());
		byte[] musicByte = Tool.streamToByteArray(bis);
		socket.shutdownInput();

		//把字节数组写入客户端磁盘

		String path = "src/cpf/learn/chapter18/downloadMusic/client/";
		FileOutputStream fs = new FileOutputStream(path + send);
		fs.write(musicByte);
		fs.close();

		bos.close();
		bis.close();
		socket.close();


	}
}
