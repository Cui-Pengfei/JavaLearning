package cpf.learn.chapter14.collection_.list_;

import java.util.*;

/**
 * @author CPF 创建于： 2021/6/20 23:37
 * 一个数组如何加入一个集合中？
 * 把数组转化为一个集合，再把这个新的集合加到后面.
 * 问题的核心是：如何把一个数组转化为一个集合？
 */
@SuppressWarnings({"all"})
public class ArrayAddToList{
	public static void main(String[] args){
		int arrays[] = {1, 2, 3, 4, 5, 6, 7};
		Collection collection = new ArrayList();

		//最原始的就是把数组内的元素一个个add到集合中，显然我们不喜欢这样...

		//方式一：collection.addAll(Collection) 需要首先把数组转化为CollectionList或实现类
		//首先，得把数组先转化为集合
		List intsList = new ArrayList(Arrays.asList(arrays));
		System.out.println(intsList);
		Iterator iterator = intsList.iterator();
		Object obj = null;
		while(iterator.hasNext()){
			obj = iterator.next();
		}
		int[] backArray = (int[])obj;
		System.out.println(backArray.length);
		System.out.println(Arrays.toString(backArray));


		//方式二：Collections.addAll(Collection, T...)


	}//end main
}
