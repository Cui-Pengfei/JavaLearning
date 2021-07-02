package cpf.learn.chapter14.collection_.set_.hashSet;

import cpf.learn.myTool.HashAbout;

import java.util.*;

/**
 * @author CPF 创建于： 2021/6/23 8:23
 * 1. HashSet实现了Set接口
 * 2. HashSet底层实际上是HashMap
 * 3. 可以存放一个null，也是元素不重复
 * 4. HashSet也是无序的
 * 5. 元素不重复，指的是两个元素equals的值不相同，底层就是用equals来判断的
 * 6. 对于数据最多的操作是查询，传统的数组，每次查询的时间复杂度都是o(n)，效率极低
 *    Hash存储就是为了解决这个难题，将元素本身的特性 与 元素所应该在的位置之间建立联系，
 *    这样，查询某个元素是否在数据库内时，就只需要将该元素按照联系的数学公式，计算出位置，
 *    再在此位置查询是否有该元素，就可以得出结论，这个时间复杂度是o(1)，空间可能牺牲了一些
 * 7.
 */
@SuppressWarnings({"all"})
public class HashSetIntro{
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{
		HashSet hashSet = new HashSet();
		System.out.println(hashSet.add("jack"));//T
		System.out.println(hashSet.add("jack"));//F
		System.out.println(hashSet.add(new String("jack")));//F
		System.out.println(hashSet);

		System.out.println(hashSet.add(new Dog("小黑")));//T
		System.out.println(hashSet.add(new Dog("小黑")));//F
		System.out.println(hashSet);

		Collection coll = new HashSet();
		Collections.addAll(coll, "mary", "tom", "henry", "hey", "no", 1, 2, 3, 4);
		hashSet.addAll(coll);
		System.out.println(hashSet);

		//此处我想在存入"cpf"之前，确定它的table下标
		System.out.println("hashTableIndex = " +
				HashAbout.hashSetTableIndex(hashSet, "cpf"));

		hashSet.add("cpf");
		System.out.println(hashSet);//yes,果然在第8个


	}//end main


}//end class

class Dog{
	private String name;

	public Dog(String name){
		this.name = name;
	}
	//如果此处重写equals方法为name值相等判断，上述第二个就会返回false


	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Dog dog = (Dog) o;
		return Objects.equals(name, dog.name);
	}

	@Override
	public int hashCode(){
		return Objects.hash(name);
		//所得索引并等于此hashCode,而是(h = key.hashCode()) ^ (h >>> 16)
	}

	@Override
	public String toString(){
		return "Dog{" +
				"name='" + name + '\'' +
				'}';
	}
}
