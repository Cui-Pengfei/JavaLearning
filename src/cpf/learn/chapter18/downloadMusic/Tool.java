package cpf.learn.chapter18.downloadMusic;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/21 16:54
 * @version 1.0
 * 工具类
 */
public class Tool{

	/**
	 * 提供一个歌曲名字，返回对应的音乐文件，如果没有，提示并返回默认音乐文件.
	 *
	 * @param name 用户提供歌曲名字
	 * @return 返回音乐文件 .mp3
	 */
	public static File getMusicByName(String name){
		String root = "src/cpf/learn/chapter18/downloadMusic/server/";

		if(name.equals("buttercup.mp3") ||
				name.equals("天空之城.mp3") ||
				name.equals("小鳄鱼之歌.mp3")){
			return new File(root + name);
		}else{
			System.out.println("服务器端没有您想要的音乐，默认下载《小鳄鱼之歌》...");
			return new File(root + "小鳄鱼之歌.mp3");
		}
	}

	/**
	 * 把一个文件从磁盘读入内存，并转化为字节数组，方便使用.
	 *
	 * @param file 需要转化的文件
	 * @return 返回字节数组.
	 * @throws IOException 异常抛给使用者
	 */
	public static byte[] getByteByMusic(File file) throws Exception{
		FileInputStream in = new FileInputStream(file);
		return streamToByteArray(in);
	}

	/**
	 * 功能：将输入流转换成byte[]， 即可以把文件的内容读入到byte[]
	 *
	 * @param in 输入流
	 * @return 返回数据的字节数组形式
	 * @throws Exception
	 */
	public static byte[] streamToByteArray(InputStream in) throws Exception{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
		byte[] b = new byte[1024];//字节数组
		int len;
		while((len = in.read(b)) != -1){//循环读取
			bos.write(b, 0, len);//把读取到的数据，写入bos
		}
		byte[] array = bos.toByteArray();//然后将bos 转成字节数组
		bos.close();
		return array;
	}


	/**
	 * 把输入流的内容转化为字符串，仅适用于确定传过来的是字符串.
	 *
	 * @param in 输入流
	 * @return 字符串
	 * @throws Exception 异常抛出
	 */
	public static String streamToString(InputStream in) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder builder = new StringBuilder();
		char[] buffer = new char[100];
		int readLen;
		while((readLen = reader.read(buffer)) != -1){
			builder.append(buffer, 0, readLen);
		}
		return builder.toString();

	}


}//end class
