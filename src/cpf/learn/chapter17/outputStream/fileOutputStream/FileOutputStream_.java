package cpf.learn.chapter17.outputStream.fileOutputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/10 22:41
 * @version 1.0
 * 把指定内容写入指定节点文件中：
 * 1.由于内容多为字符串，于是string.getBytes()就非常常用了
 * 2.创建文件字节流对象时，可往构造器内传入一个boolean，true表示续写内容，false表示覆盖内容
 *   注意：是否续写是针对流关闭后再次打开，在流的一次读写过程中，时钟都是续写的！
 * 3.写入文件时，字符串内容中的\r可以导致文件内容换行，但是\n却不可以，记得不同操作系统有不同的换行规范
 * 4.写入文件有三种方式：
	 * 4.1 write(int b) 写入一个字节，会把这个int值转为byte值，但由于精度缺失，只会转最低位一个字节
	 * 4.2 write(byte[] b)
	 * 4.3 write(byte[] b, int off, int len) 从下标为off开始，把len个字节写入文件
 *
 */
public class FileOutputStream_{

	@Test
	public void writeIntIntoFile() throws IOException{
		String path = "src/cpf/learn/chapter17/" +
				"outputStream/fileOutputStream/receive.txt";

		File file = new File(path);
		FileOutputStream fileOutputStream = null;

		int b = 0X00010101;
		System.out.println(b);
		byte bb = (byte)b;
		System.out.println(bb);

		try{
			fileOutputStream = new FileOutputStream(file, true);
			fileOutputStream.write(97);
		}catch(FileNotFoundException e){
			System.out.println("写入文件异常：" + e);
		}finally{
			fileOutputStream.close();
		}
	}

	@Test
	public void writeStringIntoFile() throws IOException{
		String path = "E:/IDEA_2020_2_4/IdeaProjects/hsp/src/cpf/learn/chapter17/" +
				"outputStream/fileOutputStream/receive.txt";

		File file = new File(path);
		FileOutputStream fileOutputStream = null;
		String content = "我是应该被写入文件的内容，请问我写入了吗？\r";
		//String content1 = "hello,world!";


		try{
			fileOutputStream = new FileOutputStream(file, true);
			byte[] bytes = content.getBytes();
			fileOutputStream.write(bytes);
		}catch(FileNotFoundException e){
			System.out.println("写入文件异常：" + e);
		}finally{
			fileOutputStream.close();
		}
	}
}
