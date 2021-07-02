package cpf.learn.chapter14.collection_.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CPF 创建于： 2021/6/23 8:03
 * 集合Set的初步学习：
 * 1. Set中元素是无序的（添加、取出顺序不一致），自然也是没有维护索引
 * 2. Set中元素不允许重复，最多只能包含一个null值，这才是正儿八经数学中集合的定义
 * 3. 如果添加了重复的元素，集合中只会保留一个该元素
 * 4. 虽然取出和添加的顺序不同，但是多次取出的顺序是一致的,即使中途添加了新的数据，老数据的
 *     相对取出顺序也不变,只是新元素的位置不确定而已，是由底层算法确定的,
 *     数字按照从小到大的相对顺序取出
 * 5.
 *
 */
@SuppressWarnings({"all"})
public class SetIntro{
	public static void main(String[] args){
		//添加元素
		Set set = new HashSet();
		set.add("jack");
		set.add("lucy");
		set.add("mary");
		set.add(null);//hash(key)中，如果key=null永远返回的是0，因此null永远在第一位
		set.add("jack");
		System.out.println("set = " + set);
		set.add("cpf");
		System.out.println("set = " +set);
		set.add("tom");
		System.out.println("set = " + set);
		set.add(1);
		set.add(2);
		set.add(6);
		System.out.println("set = " + set);

		//遍历集合
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			System.out.print(obj + " ");
		}
		System.out.println();
		for(Object obj : set){
			System.out.print(obj + " ");
		}

		System.out.println()    ;
		set.remove("jack");
		System.out.println(set);
	}//end main
}
