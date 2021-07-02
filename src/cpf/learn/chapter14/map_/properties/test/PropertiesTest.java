package cpf.learn.chapter14.map_.properties.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/6/27 10:35
 * 测试一下，从xxx.properties文件中读取修改内容
 */
public class PropertiesTest{
	public static void main(String[] args) throws IOException{
		Properties properties = new Properties();
		BufferedInputStream in = null;

		try{
			in = new BufferedInputStream(new FileInputStream("test.properties"));
			properties.load(in);
			Iterator<String> iterator = properties.stringPropertyNames().iterator();
			while(iterator.hasNext()){
				String key = iterator.next();
				System.out.println(key + " = " + properties.getProperty(key));
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			in.close();
		}

	}
}
