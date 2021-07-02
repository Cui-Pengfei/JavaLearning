package cpf.learn.chapter14.map_.properties;


import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author CPF 创建于： 2021/6/27 6:36
 * 1. Properties类继承了Hashtable类，所以基本用法几乎与HashTable一致，只是有一些扩展的特性
 * 2. Properties还可以从xxx.properties文件中，加载数据到Properties类对象，并进行读取和修改
 * 3. 工作时，通常把xxx.properties文件作为配置文件，这一点在IO流中会详细讲解
 */
public class PropertiesIntro{
	public static void main(String[] args){
		Properties properties = new Properties();
		properties.put(1,"mary");
		properties.put(2,"jack");
		properties.put(3,"smith");

		Set<Map.Entry<Object, Object>> entries = properties.entrySet();
		Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
		while(iterator.hasNext()){
			Map.Entry<Object, Object> next = iterator.next();
			System.out.println(next);
		}
	}//end main
}
