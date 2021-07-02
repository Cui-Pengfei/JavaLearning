package cpf.learn.chapter14.map_.hashTable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CPF 创建于： 2021/6/27 9:43
 */
@SuppressWarnings({"all"})
public class HashtableMethod{
	public static void main(String[] args){
		//增
		Hashtable hashtable = new Hashtable();
		hashtable.put(1, "jack");
		hashtable.put(2, "mary");
		hashtable.put(3, "smith");
		hashtable.put(1, "JACK");
		System.out.println(hashtable);

		//删
		System.out.println(hashtable.remove(1, "jack"));//匹配错误就不会删除
		System.out.println(hashtable);
		System.out.println(hashtable.remove(1));
		System.out.println(hashtable);

		//改
		Object obj = hashtable.replace(2, "Mary");
		System.out.println(obj);//返回的是被替换掉的oldValue
		System.out.println(hashtable);

		//查
		System.out.println(hashtable.contains("smith"));
		Set entrySet = hashtable.entrySet();
		Iterator iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Object next = iterator.next();
			System.out.println(next);
		}


	}//end main
}
