package cpf.learn.chapter18.tcpSocket.tcpSocketBuffered;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/21 16:13
 * @version 1.0
 * 工具类，也可以说是模板类
 */
public class StreamUtils{

	/**
	 * 传递一个字符串消息到指定流中，把套接字流转化为缓存流再传递.
	 * @param out socket流.
	 * @param message 传递的消息.
	 * @return 返回缓存流，因为使用者需要慎重考虑关闭流的时机.
	 * @throws IOException 异常抛给使用者.
	 */
	public static BufferedWriter sendByBuffered(OutputStream out, String message)
																	throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		bw.write(message);
		bw.newLine();
		bw.flush();
		return bw;
	}

}
