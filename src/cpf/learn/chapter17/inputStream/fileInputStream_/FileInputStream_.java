package cpf.learn.chapter17.inputStream.fileInputStream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/9 15:49
 * @version 1.0
 * 文件字节流读取文件内容并打印：
 * 1.一个换行是两个字节；
 * 2.读取方法read()返回的是读到的实际字节长度；
 */
public class FileInputStream_{
	public static void main(String[] args){
	}

	/**
	 * 读取磁盘文件的内容并打印在屏幕上.
	 */
	@Test
	public void readAndShow() throws IOException{
		String path = "src/cpf/learn/chapter17/inputStream/fileInputStream_/hello.txt";

		FileInputStream fileInputStream = null;
		String readData = "";
		int one;
		try{
			fileInputStream = new FileInputStream(path);
			while((one = fileInputStream.read()) != -1){
				readData += (char)one;
			}
		}catch(IOException e){
			System.out.println("");
		}finally{
			if(fileInputStream != null)
				fileInputStream.close();
		}

		System.out.println("读取到的内容如下：");
		System.out.println(readData);
	}

	@Test
	public void readMore() throws IOException{
		String path = "src/cpf/learn/chapter17/inputStream/fileInputStream_/hello.txt";

		FileInputStream fileInputStream = null;
		int readLen;
		byte more[] = new byte[200];//10个字节一读
		try{
			fileInputStream = new FileInputStream(path);
			while((readLen = fileInputStream.read(more)) != -1){
				System.out.println("\n读取了" + readLen + "个字节：");
				System.out.print(new String(more,0,readLen));
			}
		}catch(IOException e){
			System.out.println("");
		}finally{
			if(fileInputStream != null)
				fileInputStream.close();
		}
	}

}
