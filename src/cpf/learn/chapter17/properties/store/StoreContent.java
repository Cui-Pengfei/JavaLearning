package cpf.learn.chapter17.properties.store;

import java.io.*;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/7/14 8:48
 * @version 1.0
 * 保存键值对信息到某个文件
 */
public class StoreContent{
	public static void main(String[] args) throws IOException{
		Properties properties = new Properties();

		File file = new File("src/cpf/learn/chapter17/" +
				"properties/store/save.properties");

		properties.setProperty("name","崔鹏飞");
		properties.setProperty("age","25");
		properties.setProperty("gender","男");
		properties.setProperty("salary","25k");

		/*注释comments会以Unicode码值形式保存在文件中，且以#开始表示注释；
		以字符流写入文件的话（写入编码与文件编码一致），中文会以字符形式写入，注释是Unicode码值
		* */
		properties.store(new OutputStreamWriter(
				new FileOutputStream(file),"gbk"),"这是保存配置信息到文件");

		/*如果以字节流形式写入内容，那么键值对里的中文也会以Unicode码值存储*/
		//properties.store(new FileOutputStream(file),"这是保存配置信息到文件");
		System.out.println("保存配置信息完毕！");
	}


}
