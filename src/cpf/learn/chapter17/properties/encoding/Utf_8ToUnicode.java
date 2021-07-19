package cpf.learn.chapter17.properties.encoding;

import java.io.*;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/7/14 11:40
 * @version 1.0
 */
public class Utf_8ToUnicode{
	public static void main(String[] args) throws IOException{
		File file = new File("src/cpf/learn/chapter17/" +
				"properties/encoding/UTF-8中文.txt");

		FileInputStream fileInputStream = new FileInputStream(file);

		int readLen;
		byte[] buffer = new byte[100];
		readLen = fileInputStream.read(buffer);

		String content = new String(buffer, 0, readLen);
		System.out.println(content);

		File file1 = new File("src/cpf/learn/chapter17/" +
				"properties/encoding/show.properties");

		Properties properties = new Properties();
		properties.setProperty("name", content);
		properties.store(new FileOutputStream(file1),null);
		System.out.println("配置完毕");
	}
}
