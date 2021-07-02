package cpf.learn.chapter15.exercise;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author CPF 创建于： 2021/6/29 23:44
 */
public class Exercise02{
	public static void main(String[] args){

		Employee jack = new Employee("jack", 11000, new MyDate(1994, 3, 6));
		Employee tom = new Employee("tom", 9000, new MyDate(1996, 5, 8));
		Employee mary = new Employee("mary", 30000, new MyDate(1990, 1, 1));
		Employee mary2 = new Employee("mary", 30000, new MyDate(1990, 3, 1));


		ArrayList<Employee> list = new ArrayList<>();
		list.add(jack);
		list.add(tom);
		list.add(mary);
		list.add(mary2);

		list.sort(new Comparator<Employee>(){
			@Override
			public int compare(Employee e1, Employee e2){
				if(e1.getName().equals(e2.getName())){
					return e1.getBirthday().compareTo(e2.getBirthday());
				}else{
					return e1.getName().compareTo(e2.getName());
				}
			}
		});

		System.out.println(list);

	}//end main
}

class Employee{
	private String name;
	private int salary;
	private MyDate birthday;

	@Override
	public String toString(){
		return "\nEmployee{" +
				"name='" + name + '\'' +
				", salary=" + salary +
				", birthday=" + birthday +
				'}';
	}

	public Employee(String name, int salary, MyDate birthday){
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public MyDate getBirthday(){
		return birthday;
	}

}

class MyDate implements Comparable<MyDate>{
	private int year;
	private int month;
	private int day;

	@Override
	public String toString(){
		return year + "-" + month + "-" + day;
	}

	public MyDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}


	@Override
	public int compareTo(MyDate date){
		int y = year - date.year;
		int m = month - date.month;
		int d = day - date.day;
		return (y == 0) ? ((m == 0) ? d : m) : y;//这个比较非常妙！！！！！我想的！
	}
}
