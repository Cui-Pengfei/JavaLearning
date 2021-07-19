package cpf.learn.chapter17.exercise;

import java.io.*;

/**
 * @author CPF 创建于： 2021/7/11 10:47
 * @version 1.0
 * 把F:\pictures\girl.jpg拷贝到e盘：
 * 1.拷贝内容一定要注意，如果使用缓冲数组来读取数据，在写入的时候一定要加上写入的字节长度，
 *      因为很有可能最后一次，没有读满数组，但是你却把数组尾部的数组的默认值也读进文件，
 *      如果是字符文件，极有可能导致乱码，如果是字节文件，后果可能稍微好点
 */
public class FileCopy{//成功了！

	public static void main(String[] args) throws IOException{
		File picture = new File("F:/pictures/girl.jpg");

		FileInputStream in = null;
		FileOutputStream out = null;
		byte[] buffer = new byte[1024];//1kb取一次

		int readLen;
		try{
			in = new FileInputStream(picture);
			out = new FileOutputStream("e:/girlCopy.jpg");

			while((readLen = in.read(buffer)) != -1){
				out.write(buffer, 0, readLen);
			}
		}catch(FileNotFoundException e){
			System.out.println("读入或写出文件路径异常：" + e);
		}finally{
			in.close();
			out.close();
		}

	}
}
