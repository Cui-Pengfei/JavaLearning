package cpf.learn.chapter18.netstat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author CPF 创建于： 2021/7/21 3:42
 * @version 1.0
 * 为了通过netstat查看，客户端也会被主机随机分配一个端口来进行数据交换，
 * 此处故意阻塞，以期待有时间看到端口分配的情况.
 */
public class Client{
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(InetAddress.getLocalHost(), 11111);
		System.out.println("客户端连接服务器成功！");
		OutputStream os = socket.getOutputStream();
		os.write("hi,server".getBytes());
		//故意不结束输出

		//又去读服务器端
		InputStream is = socket.getInputStream();
		is.read(new byte[1024]);
	}
}
