package cpf.learn.chapter18.tcpSocket.fileCopy;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/21 1:57
 * @version 1.0
 * 这是工具类，有一些可复用性代码在这里处理非常好
 */
public class StreamUtils{

	/**
	 * 把一个输入缓存流的数据传入到输出缓存流中
	 *
	 * @param in  输入缓存流
	 * @param out 输出缓存刘
	 * @return 返回是否成功传输数据
	 */
	public
	static boolean inAndOut(InputStream in, OutputStream out){
		byte[] buffer = new byte[1024];
		int readLen;
		try{
			while((readLen = in.read(buffer)) != -1){
				out.write(buffer, 0, readLen);//边读边写
			}
		}catch(IOException e){
			System.out.println("读入或写出失败！" + e);
			return false;
		}
		return true;//如果异常就不会返回true
	}
}
