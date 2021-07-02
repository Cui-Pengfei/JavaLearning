package cpf.learn.chapter14.exercise;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author CPF 创建于： 2021/6/29 10:18
 */
@SuppressWarnings({"all"})
public class HomeWork{
	public static void main(String[] args){
		HashSet hashSet = new HashSet();

		Person p1 = new Person(1001, "AA");
		Person p2 = new Person(1002, "BB");

		hashSet.add(p1);//i = (n - 1) & hash = (16 - 1) & 34072 = 8

		hashSet.add(p2);

		p1.name = "CC";//直接黑虎掏心，不经过hashSet，通过其他链接直接改变内部元素的值，不会造成该元素的重定位

		System.out.println(hashSet.remove(p1));//false 但是删除的时候，改变了的元素是会重定位删除位置的
		System.out.println(hashSet);

		hashSet.add(p1);
		//i = (n - 1) & hash = (16 - 1) & 34136 = 8 这也太巧了 相同的值，但是hash值不一样，还挂到了后面
		//这只是一个巧合，改变一下name，就会破除这种巧合

		//此时再加入p1，这个p1会重定位到另一个位置，存起来，实现hashSet中存放重复元素
		System.out.println(hashSet);

	}//end main
}

class Person{
	private int id;
	public String name;

	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return id == person.id &&
				Objects.equals(name, person.name);
	}

	@Override
	public int hashCode(){
		return Objects.hash(id, name);
	}

	@Override
	public String toString(){
		return "{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
