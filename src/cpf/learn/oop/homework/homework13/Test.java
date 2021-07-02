package cpf.learn.oop.homework.homework13;

import java.util.Scanner;

public class Test{
	public static void main(String[] args){
		Person[] p = {
				new Student("张三", '男', 22, "12341"),
				new Student("王红", '女', 20, "12342"),
				new Teacher("李胜", '男', 35, 10),
				new Teacher("邓亚双", '女', 27, 3)
		};

		Person temp;
		boolean isOrdered = true;
		for(int i = 0; i < p.length - 1; i++){
			for(int j = 0; j < p.length - 1 - i; j++){
				if(p[j].getAge() < p[j + 1].getAge()){
					temp = p[j];
					p[j] = p[j + 1];
					p[j + 1] = temp;
					isOrdered = false;
				}
			}
			if(isOrdered){
				break;
			}
		}

		//输出有序数组
		for(Person person : p){
			System.out.println(person.toString());
		}

		Student student = new Student("张三", '男', 22, "12341");
		Teacher teacher = new Teacher("李胜", '男', 35, 10);

		say(student);
		say(teacher);


	}//end main

	static public void say(Person p){
		System.out.println(p.getName() + "说：“我喜欢" + p.getHobby() + "”");
	}

}//end class
