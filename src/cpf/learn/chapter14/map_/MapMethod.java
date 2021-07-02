package cpf.learn.chapter14.map_;

import java.util.*;

/**
 * @author CPF 创建于： 2021/6/25 21:42
 * 讲解接口的方法，只能是用他的实现类来讲解，此处选择 HashMap
 * 1. 在HashMap中，<K,V>的两个值是封装在HashMap$Node内的，
 */
@SuppressWarnings({"all"})
public class MapMethod{
	public static void main(String[] args){
		Map map = new HashMap();
		map.put(1, "jack");
		System.out.println("map = " + map);

		map.put(new Person(), new Dog());
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println("iterator.next()的运行类型是：" + iterator.next().getClass());
			Map.Entry entry = (Map.Entry)iterator.next();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
			System.out.println("entry的运行类型："+entry.getClass());
		}

		System.out.println("\nmap.keySet()的运行类型：" + map.keySet().getClass().getSuperclass());
		System.out.println("map.values()的运行类型性：" + map.values().getClass().getSuperclass());


	}//end main
}
class Person{
	@Override
	public String toString(){
		return "Person@" + this.hashCode();
	}
}
class Dog{
	@Override
	public String toString(){
		return "Dog@" + this.hashCode();
	}
}