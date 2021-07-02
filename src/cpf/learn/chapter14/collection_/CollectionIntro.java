package cpf.learn.chapter14.collection_;

import java.util.*;

/**
 * @author CPF 创建于： 2021/6/20 22:01
 * 1. Collection继承自Iterable接口 iterable(可迭代的)
 * 2. Collection实现子类，可以存放多个元素，每个元素都是对象
 * 3. Collection的实现子类中，有些是有序的（如List,存放取出顺序一致），有些无序（Set）
 * 4. Collection接口没有直接实现子类，都是通过它的子接口List Set来实现的，
 * 但是Collection是可以被直接实现的，只是我们没必要这样做。
 */
@SuppressWarnings({"all"})
public class CollectionIntro{
	public static void main(String[] args){
		/*1. 以Collection子接口List的实现子类ArrayList为例，来探讨Collection接口中的抽象方法 */
		//添加元素：add的都是对象，添加基本数据类型都会有一个自动装箱的过程.
		Collection collection = new ArrayList();
		collection.add("cpf");
		collection.add(25);
		collection.add('男');
		collection.add(true);
		System.out.println("collection = " + collection);


		//删除元素 remove(object):boolean   remove(index):object
		System.out.println("============== 2.remove() ===============");
		System.out.println(collection.remove("cpf"));
		System.out.println("按对象删除后 = " + collection);
		//Collection只有按对象删除的方法，List里面才有按索引删除的方法

		//查找元素 contains()
		System.out.println("============== 3.contains() ===============");
		System.out.println("now collection = " + collection);
		System.out.println("collection有元素25吗？" + collection.contains(25));
		ArrayList arrayList = new ArrayList();
		arrayList.add('男');
		arrayList.add(25);
		System.out.println("arrayList = " + arrayList);
		System.out.println("arrayList是conlection的子集吗？" + collection.containsAll(arrayList));

		//集合大小 size
		System.out.println("============== 4.size() isEmpty() clear() ===============");
		System.out.println("now collection = " + collection);
		System.out.println("size = " + collection.size());
		System.out.println("collection为空吗？" + collection.isEmpty());
		//collection.clear();
		System.out.println("clear();后，collection为空吗？" + collection.isEmpty());


		//清空指定的元素 removeAll(Collection)
		System.out.println("============== 5.removeAll() ===============");
		System.out.println("now collection = " + collection);
		System.out.println("now arrayList = " +arrayList);
		System.out.println(collection.removeAll(arrayList));
		System.out.println("移除arrayList后，collection = " + collection);
	}
}
