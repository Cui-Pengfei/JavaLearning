package cpf.learn.chapter14.collection_.set_.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author CPF 创建于： 2021/6/27 11:22
 * 1.在add()的时候，如果compare的结果相等，那么就不会加入该key值，这其中有很玄妙的返回值搭配技巧，可以学习
 * 2.compare(obj, obj)是我们可以自定义的
 * 3.必须实现了Comparable，可以比较的元素才能加进去，毕竟是要排序的
 * 4.如果按照默认的比较方式，必须保证两者比较类型是一致的，否则就会出错，
 *   或者自定义compare方法，才能避免不同类型比较报错ClassCastException
 */
@SuppressWarnings({"all"})
public class TreeSetIntro{
	public static void main(String[] args){
		TreeSet treeSet = new TreeSet();
/*		TreeSet treeSet = new TreeSet(new Comparator(){
			@Override
			public int compare(Object o1, Object o2){
				return ((String)o2).compareTo((String)o1);
			}
		});*/
		treeSet.add("jack");
		treeSet.add("mary");
		treeSet.add("smith");
		treeSet.add("tom");
		treeSet.add(1.22);
		//treeSet.add(new Dog("阿黄"));//必须实现了Comparable，可以比较的元素才能加进去
		System.out.println(treeSet);


	}//end main
}
class Dog {
	private String name;

	public Dog(String name){
		this.name = name;
	}
}
