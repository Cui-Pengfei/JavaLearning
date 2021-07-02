package cpf.learn.chapter14.map_.treemap;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author CPF 创建于： 2021/6/27 11:36
 * 1. TreeMap就是一个有序的二叉树，这意味着，插入其中的元素在某一维度必须是可比较的，
 *    代码中 Comparable<? super K> k = (Comparable<? super K>) key; 保证了这一点，
 *    一旦key未继承Comparable接口就会抛出异常
 * 2. 默认情况下，也就是使用空构造器实例化TreeMap的时候，会调用Key对应类型自身的commpareTo()方法来比较；
 *    这意味着，默认情况下，必须是相同类型的数据才可以，不然就会抛出异常，毕竟compareTo限定了必须是相同的类型进行比较:
 *    public interface Comparable<T> {    public int compareTo(T o);    }
 * 3. 我们用新定义的一个Comparator来构造TreeMap时，就可以自定义自己的CompareTo方法了，此处的Comparator是一个匿名内部类;
 *    因为Comparator是一个比较器接口，接口是不能实例化的
 * 4. 其他地方与HashMap大同小异，只是遍历出来的都是按照特定元素的、特定规则的升序或者降序来排列的，
 *    这是通过二叉树的中序遍历实现的 核心函数：successor(Entry<K,V> t)
 */
@SuppressWarnings({"all"})
public class TreeMapIntro{
	public static void main(String[] args){
		//TreeMap treeMap = new TreeMap();

		TreeMap treeMap = new TreeMap(new Comparator(){
			@Override
			public int compare(Object o1, Object o2){
				return 0;
			}
		});

		treeMap.put("jack", "杰克");
		treeMap.put("jack", "杰克杰克");
		System.out.println(treeMap);



	}//end main
}
