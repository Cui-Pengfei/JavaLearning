package cpf.learn.chapter18.downloadMusic.server;

import cpf.learn.chapter18.downloadMusic.Tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 17:01
 * @version 1.0
 */
public class Server{
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("服务器端正在监听8888端口...");
		Socket socket = serverSocket.accept();

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String receive;

		//得到用户请求的音乐名字输入流
		bis = new BufferedInputStream(socket.getInputStream());
		receive = Tool.streamToString(bis);
		socket.shutdownInput();


		//从服务端磁盘读取音乐文件，并转化为字节数组
		File music = Tool.getMusicByName(receive);
		byte[] musicByte = Tool.getByteByMusic(music);

		//把音乐数据传给客户端
		bos = new BufferedOutputStream(socket.getOutputStream());
		bos.write(musicByte);
		socket.shutdownOutput();

		bis.close();
		bos.close();
		socket.close();
		serverSocket.close();




	}
}
