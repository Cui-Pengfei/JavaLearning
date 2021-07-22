package cpf.learn.chapter18.teacherCode;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 *
 */
public class StreamUtils {
	/**
	 * 功能：将输入流转换成byte[]， 即可以把文件的内容读入到byte[]
	 * @param in 输入流
	 * @return 返回数据的字节数组形式
	 * @throws Exception
	 */
	public static byte[] streamToByteArray(InputStream in) throws Exception{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
		byte[] b = new byte[1024];//字节数组
		int len;
		while((len=in.read(b))!=-1){//循环读取
			bos.write(b, 0, len);//把读取到的数据，写入bos	
		}
		byte[] array = bos.toByteArray();//然后将bos 转成字节数组
		bos.close();
		return array;
	}
	/**
	 * 功能：将InputStream转换成String
	 * @param in 输入字节流
	 * @return 转化为的字符串
	 * @throws Exception
	 */
	
	public static String streamToString(InputStream in) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder builder= new StringBuilder();
		String line;
		while((line=reader.readLine())!=null){
			builder.append(line+"\r\n");
		}
		return builder.toString();
		
	}

}
