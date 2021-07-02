package cpf.learn.chapter14.collection_.set_.hashSet;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author CPF 创建于： 2021/6/24 21:40
 */
public class Exercise02{
	public static void main(String[] args){
		Employee_ jack = new Employee_("jack", 10000, new MyDate(2018, 3, 25));
		Employee_ mary = new Employee_("mary", 11000, new MyDate(2019, 3, 22));
		Employee_ jackCopy = new Employee_("jack", 20000, new MyDate(2018, 3, 25));
		Employee_ maryCopy = new Employee_("mary", 10000, new MyDate(2019, 3, 22));
		Employee_ maryAs = new Employee_("maryAs", 10000, new MyDate(2019, 1, 1));


		HashSet<Employee_> employee_s = new HashSet<Employee_>();
		System.out.println(employee_s.add(jack));//T
		System.out.println(employee_s.add(jackCopy));//F
		System.out.println(employee_s.add(mary));//T
		System.out.println(employee_s.add(maryCopy));//F
		System.out.println(employee_s.add(maryAs));//T

		System.out.println(employee_s);
	}
}

class Employee_{
	private String name;
	private double sal;
	private MyDate birthday;

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Employee_ employee_ = (Employee_) o;
		return Objects.equals(name, employee_.name) &&
				Objects.equals(birthday, employee_.birthday);
	}

	@Override
	public int hashCode(){
		return Objects.hash(name, birthday);
	}

	@Override
	public String toString(){
		return "{" +
				"name='" + name + '\'' +
				", sal=" + sal +
				", birthday=" + birthday +
				"}\n";
	}

	//belows is constructors and getters or setters
	public Employee_(){
	}
	public Employee_(String name, double sal, MyDate birthday){
		this.name = name;
		this.sal = sal;
		this.birthday = birthday;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getSal(){
		return sal;
	}

	public void setSal(double sal){
		this.sal = sal;
	}

	public MyDate getBirthday(){
		return birthday;
	}

	public void setBirthday(MyDate birthday){
		this.birthday = birthday;
	}
}

class MyDate{
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		MyDate myDate = (MyDate) o;
		return year == myDate.year &&
				month == myDate.month &&
				day == myDate.day;
	}

	@Override
	public int hashCode(){
		return Objects.hash(year, month, day);
	}

	@Override
	public String toString(){
		return year + "-" +
				month + "-" +
				day
				;
	}
}
