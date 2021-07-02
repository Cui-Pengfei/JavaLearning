package cpf.learn.chapter14.map_.properties;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author CPF 创建于： 2021/6/27 10:50
 */
public class PropertiesMethod{
	public static void main(String[] args){
		Properties properties = new Properties();
		//增
		properties.put(1, "mary");
		properties.put(2, "jack");
		properties.put(3, "smith");
		//删
		properties.remove(1);
		System.out.println(properties);
		//改
		properties.put(2, "JACK");//方式一
		System.out.println(properties);
		properties.replace(3,"SMITH");//方式二
		System.out.println(properties);
		//查
		System.out.println(properties.contains("SMITH"));//特例查找
		Set<Map.Entry<Object, Object>> entries = properties.entrySet();
		Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
		while(iterator.hasNext()){
			Map.Entry<Object, Object> entry = iterator.next();
			System.out.println(entry);
		}


	}//end main
}
