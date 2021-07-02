package cpf.learn.oop.poly.polyArray;

import cpf.learn.oop.extend_.Person;
import cpf.learn.oop.extend_.Student;
import cpf.learn.oop.extend_.Teacher;

public class PolyArray{
	public static void main(String[] args){

		Person[] p = {new Person(), new Student(), new Teacher()};

		for(Person person : p){//遍历数组的语法...
			if(person instanceof Student){
				((Student) person).exam();
			}else if(person instanceof Teacher){
				((Teacher) person).teach();
			}else{
				person.say();
			}
		}

		//要想用学生和老师特有的方法，只有再向下转型了
		/*
		Student student = (Student)p[1];
		Teacher teacher = (Teacher)p[2];
		student.exam();
		teacher.teach();
		*/

	}//end main
}//end class
