package cpf.learn.chapter14.collection_.list_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author CPF 创建于： 2021/6/21 6:59
 * Collection的直接子接口List的学习：
 * 0. 牢记：List仍然是一个接口
 * 1. List继承了Collection的抽象方法，并且有许多自己的特性
 * 2. List表示的是有序的集合，放入、取出的顺序是一致的
 * 3. List中的元素可以重复（在数学定义里，集合是不能重复的）
 * 4. List集合中，每个元素都对应一个索引，即支持索引
 * 5. ArrayList存储说到底还是数组，插入元素的时候还是调用的System.arraycopy()函数
 * 6. List的索引从0开始
 */
@SuppressWarnings({"all"})
public class ListIntro{
	public static void main(String[] args){
/*1. 增 add() 由于List是有序的集合，因此比Collection更多了按照索引index添加元素的方法
		*/
		List list = new ArrayList();
		list.add("cpf");
		List otherList = new ArrayList();
		Collections.addAll(otherList, 1, 2, 3, 4, 5);
		list.addAll(otherList);
		System.out.println(list);

		//按照索引添加元素,对add\addAll都适用
		list.add(1,'男');
		System.out.println(list);
		System.out.println(list.size());
		list.add(list.size(), 25);//允许插入的index最大为list.size(),再大会报错
		System.out.println(list);
		list.addAll(0, otherList);//addAll()也遵循上述原则
		System.out.println(list);

/*2. 删 remove()
		*/
		System.out.println("=========== 2.remove[All]() ==========");
		list.remove(new Integer(25));
		/*
		由于remove(object) remove(int)两个重载的方法，在删除整数时，要用包装类主动装箱，
		以免歧义；毕竟，在加入List时候，其实也有一个自动装箱
		 */
		System.out.println(list);
		list.remove(6);//删除'男'
		System.out.println(list);
		list.removeAll(otherList);//将会把符合otherList的组合全部删除（从左往右组合）
		System.out.println(list);

/*3. 改 set() 置值的地方必须是有定义的，不同于add(int object)还可以后移一位*/
		System.out.println("=========== 3.set() ====================");
		System.out.println("now list = " + list);
		list.set(list.size() - 1, "lsp");
		System.out.println(list);
		list.set(list.size() - 1, "cpf");//复原

/*4. 查 indexOf(object) get(index)*/
		System.out.println("=========== 4.indexOf() get() ==========");
		System.out.println(list.indexOf("cpf"));
		list.addAll(otherList);
		list.add("cpf");
		System.out.println("now list = " +list);
		System.out.println(list.lastIndexOf("cpf"));
		Object object = list.get(list.size() - 1);//这一点很想数组长度
		System.out.println(object);

/*5. subList(fromIndex, toIndex) 得到一段子集合*/
		System.out.println("=========== 5.subList() ==========");
		System.out.println("now list = " + list);
		List sublist = list.subList(1, list.size() - 1);//必须保证下标在范围内,且前闭后开
		System.out.println(sublist);

/*6. 遍历List元素：
		由于List内元素支持索引，这意味着可以按照索引来遍历，多出这一种便利方法
		*/
		for(int index = 0; index < list.size(); index++){
			Object obj = list.get(index);
			System.out.print(obj + "\t");
		}
	}//end main
}
