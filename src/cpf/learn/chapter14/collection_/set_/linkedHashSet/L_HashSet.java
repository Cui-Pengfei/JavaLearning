package cpf.learn.chapter14.collection_.set_.linkedHashSet;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author CPF 创建于： 2021/6/24 22:04
 * 1. LinkedHashSet 是HashSet的直接子类，因此拥有HashSet的所有特性，一个表头数组，其后维持链表
 * 2. 不同的是，LinkedHashSet在此基础上，又维持了一个双向链表，该双向链表以加入元素的次序为顺序，有头尾指针
 * 3. 这样就实现了可以按照加入元素的顺序来取出元素
 * 4. 此数据存储结构，以牺牲部分空间为代价，获得了线性表、hash表各自的优点
 */
@SuppressWarnings({"all"})
public class L_HashSet{
	public static void main(String[] args) throws NoSuchFieldException{
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		Collection coll = new LinkedHashSet();
		Collections.addAll(coll, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		linkedHashSet.addAll(coll);

		linkedHashSet.add("mary");
		linkedHashSet.add(new Double(1.23));
		linkedHashSet.add(1.0);
		linkedHashSet.add("别再挂到8后面了吧！");

		System.out.println(linkedHashSet);

		Iterator iterator = linkedHashSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}




	}
}
