package cpf.learn.chapter14.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author CPF 创建于： 2021/6/21 2:31
 * Collection的父接口Iterable(可迭代接口)：
 * 内置一个抽象方法 Iterator<T> iterator(); 确定了自己的可迭代特性
 */
@SuppressWarnings({"all"})
public class Iterable_{
	public static void main(String[] args){
		Collection coll = new ArrayList();
		coll.add("cpf");
		coll.add('男');
		coll.add(25);
		coll.add("本科学士");
		System.out.println(coll);

		//集合是链表，遍历集合需要游标，在java集合中的术语叫迭代器Iterator
		Iterator iterator = coll.iterator();
		//获得迭代器中的每个元素是一个固定句式，有快捷键itit
		//把code中的live Template调出来，快捷键是 ctrl + shift + alt + j
		while(iterator.hasNext()){
			Object next = iterator.next();
		}
		//结束之后，迭代器指向集合的最后一个元素，要想再次遍历，需要重置迭代器
		//iterator = coll.iterator();//重置

		//增强for循环，也可以遍历集合的元素，本质上是一个简单的iterator
		for(Object object : coll){
			System.out.println(object);
		}

		//也可以用Iterable来接收new ArrayList();但是Iterable没啥方法，转型为它没卵用
		Iterable iterable = new ArrayList();


	}//end main
}
