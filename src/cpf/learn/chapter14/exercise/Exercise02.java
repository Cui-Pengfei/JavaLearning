package cpf.learn.chapter14.exercise;

import java.util.*;

/**
 * @author CPF 创建于： 2021/6/29 4:58
 */
@SuppressWarnings({"all"})
public class Exercise02{
	public static void main(String[] args){

		HashMap<String, Integer> m = new HashMap<String, Integer>();

		m.put("jack", 650);
		m.put("tom", 650);
		m.put("smith", 2900);
		System.out.println(m);

		m.replace("jack", 2600);
		System.out.println(m);

		//加工资 很多种方式
		Iterator<Map.Entry<String, Integer>> iterator = m.entrySet().iterator();
		while(iterator.hasNext()){//方式一，因为entry可以使用get set方法，最容易想到
			Map.Entry<String, Integer> entry = iterator.next();
			entry.setValue(entry.getValue() + 50);
		}

		Set<String> names = m.keySet();
		for(String name : names){//方式二，因为可以根据key来改变value的值，
			m.put(name, m.get(name) + 50);//replace也是可以的
		}
		System.out.println(m);

		System.out.println("========== 直接通过values遍历可以吗？ ==========");
		Collection<Integer> values = m.values();
		for(Integer salary : values){
			salary = salary + 100;
			//此处会建立一个新的Integer,如果可以在原来的Integer上修改数值，就没事
			//但是Integer的value是final的，这意味着此方法不可行
		}
		System.out.println(m);

		//遍历员工
		System.out.println("========== 遍历员工 ==========");
		Iterator<String> iterator1 = m.keySet().iterator();
		while(iterator1.hasNext()){
			String name = iterator1.next();
			System.out.println(name);
		}

		//遍历工资
		System.out.println("========== 遍历工资 ==========");
		Collection<Integer> values1 = m.values();
		for(Integer salary : values1){
			System.out.println(salary);
		}


	}//end main
}
