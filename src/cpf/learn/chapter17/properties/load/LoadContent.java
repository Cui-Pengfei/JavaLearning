package cpf.learn.chapter17.properties.load;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/7/13 22:41
 * @version 1.0
 * 把配置文件内容解析为键值对存入HashMap中
 *
 */
public class LoadContent{
	public static void main(String[] args) throws IOException{
		//1.创建Properties对象
		Properties properties = new Properties();
		//2.以默认utf-8字符流来加载配置文件
		properties.load(new FileReader("src/cpf/learn/chapter17/" +
				"properties/load/mysql.properties"));
		//3.显示键值对
		properties.list(System.out);
		//4.获得指定key的value值
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		System.out.println("用户名 = " + name);
		System.out.println("密码 = " + password);


	}

	@Test
	public void diffEncoding() throws IOException{
		File file = new File("src/cpf/learn/chapter17/properties/load/mysql.properties");
		//1.创建Properties对象
		Properties properties = new Properties();
		//2.以gbk字符流来加载配置文件,如果文件本身格式也为gbk才能保证没有乱码
		properties.load(new InputStreamReader(new FileInputStream(file),"gbk"));
		//3.显示键值对
		properties.list(System.out);
		System.out.close();
	}
}
