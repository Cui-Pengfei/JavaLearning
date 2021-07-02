package cpf.learn.chapter14.collection_.set_.hashSet;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author CPF 创建于： 2021/6/24 21:29
 */
public class Exercise01{
	public static void main(String[] args){
		Employee employee1 = new Employee("jack", 23);
		Employee employee2 = new Employee("jack", 25);
		Employee employee3 = new Employee("tom", 25);
		Employee employee4 = new Employee("jack", 23);

		HashSet<Employee> hashSet = new HashSet<Employee>();

		System.out.println(hashSet.add(employee1));
		System.out.println(hashSet.add(employee2));
		System.out.println(hashSet.add(employee3));
		System.out.println(hashSet.add(employee4));

		System.out.println(hashSet);
	}//end main
}

class Employee{
	private String name;
	private int age;

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return age == employee.age &&
				Objects.equals(name, employee.name);
	}

	@Override
	public int hashCode(){
		return Objects.hash(name, age);
	}

	@Override
	public String toString(){
		return "{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	//below is constructor and getters or setters
	public Employee(){
	}

	public Employee(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}
}
