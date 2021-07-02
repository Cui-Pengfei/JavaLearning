package cpf.learn.oop.extend_;

import java.util.Random;

//大学生，继承学生
public class Graduate extends Student{

	/**
	 * 子类无法继承父类的构造器，因为父类的构造器写着的是父类的名字，
	 * 但是从这段代码可以看出，子类无特殊属性时，是没有必要拥有自己的构造器的，
	 * 因为用父类的构造器实例化一个父类可以完全赋值给子类
	 */
	public Graduate(String name, char gender, int age, String idCard,
	                String school, String studentID, double score){
		//注意这个语法，super相当于父类的 this,这也是在构造器中调用构造器
		super(name, gender, age, idCard, school, studentID, score);
	}

	//空构造器
	public Graduate(){

	}

	//大学生考试方法
	public void exam(){
		System.out.println("大学生正在考试...");
		Random random = new Random();
		setScore(random.nextInt(150));
	}
}
