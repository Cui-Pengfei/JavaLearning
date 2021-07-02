package cpf.learn.chapter14.collection_.list_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author CPF 创建于： 2021/6/21 19:45
 */
@SuppressWarnings({"all"})
public class Exercise01{
	public static void main(String[] args){
		List list = new ArrayList();
		Collections.addAll(list, "hello", "cpf", '男', 25, 176, 67,
				"本科学士", "武汉", "杭州", "深圳", "java工程师", "15k/month");
		System.out.println("list = " + list);
		list.add(2, "韩顺平教育");
		System.out.println(list.get(5 - 1));
		list.remove(6 - 1);
		list.set(7 - 1, "我被修改了");

		System.out.println("最后list = " + list);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next.getClass());
		}


	}//end main
}
