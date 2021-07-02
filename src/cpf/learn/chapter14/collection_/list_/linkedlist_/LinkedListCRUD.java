package cpf.learn.chapter14.collection_.list_.linkedlist_;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author CPF 创建于： 2021/6/23 7:02
 * 双向链表的增删改查：
 */
@SuppressWarnings({"all"})
public class LinkedListCRUD{
	public static void main(String[] args){
		//LinkedList的创建有两个构造函数
		Collection coll = new LinkedList();
		Collections.addAll(coll, 1, 2, 3);
		LinkedList linkedList = new LinkedList();
		LinkedList linkedList2 = new LinkedList(coll);

		//增
		linkedList.add("cpf");
		linkedList.add(1, '男');//自然是可以在屁股后面加元素
		System.out.println(linkedList);

		linkedList.addAll(coll);
		linkedList.addAll(0, coll);
		System.out.println(linkedList);

		//删
		linkedList.remove();//默认的删除是第一个元素
		System.out.println(linkedList);
		linkedList.remove(new Integer(2));//删除某个值的元素默认删除从头部开始的第一个该值元素
		System.out.println(linkedList);
		linkedList.removeFirst();//是默认删除会调用的方法
		System.out.println(linkedList);
		linkedList.remove(0);//指定删除的的位置，从0开始编号
		System.out.println(linkedList);
		linkedList.addAll(0, coll);//加两个coll，看一会儿删除一个还是两个
		System.out.println(linkedList);
		linkedList.removeAll(coll);//首尾两个coll都被删除了
		System.out.println(linkedList);

		//改
		linkedList.set(0, '女');
		System.out.println(linkedList);

		//查
		linkedList.addAll(coll);
		System.out.println(linkedList);
		System.out.println(linkedList.indexOf(2));
		Object o = linkedList.get(0);
		System.out.println(o);
		System.out.println(linkedList.getLast());
	}
}



















