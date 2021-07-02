package cpf.learn.chapter15.exercise;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author CPF 创建于： 2021/6/29 16:11
 */
public class Exercise01{
	public static void main(String[] args){

		Student jack = new Student("jack");
		Student tom = new Student("tom");
		Student mary = new Student("mary");

		HashSet<Student> students = new HashSet<>();
		students.add(jack);
		students.add(tom);
		students.add(mary);


		HashMap<String, Student> hashMap = new HashMap<>();
		hashMap.put(jack.getName(), jack);
		hashMap.put(tom.getName(), tom);
		hashMap.put(mary.getName(), mary);


	}//end main
}

class Student{
	private String name;

	public Student(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
