package cpf.learn.oop.extend_;

import java.util.Random;

/**
 *小学生类，继承学生
 */
public class Pupil extends Student{

	public String nature = "爱玩...";

	//小学生没有什么特殊的属性
	//构造器和get\set方法都不用重新写了

	//1.子类无参构造器
	public Pupil(){
		//super();  //这句话是隐藏的 默认调用父类的无参构造器
		//此处虽然没有super关键字，但是仍然会默认调用父类的无参构造器
	}

	//2.假如没有特殊属性，只需要super关键字即可
	public Pupil(String school, String studentID, double score){
		super(school, studentID, score);
	}

	//3.假如有自己的特殊属性，就这样复用构造器，就和自己复用构造器是一样的，
	// 只是关键字由 this 变成了 super
	public Pupil(String school, String studentID, double score, String nature){
		super(school, studentID, score);
		this.nature = nature;
	}

	//4.如果一个构造器参数列表都是子类的属性，会发生什么？仍然会调用父类的无参构造器
	public Pupil(String nature){
		//super();  //这里实际隐藏了对父类无参构造器的调用
		this.nature = nature;
	}

	//5.假如是特殊属性与继承属性混合，并且继承属性没有可复用的父类构造器
	public Pupil(double score, String nature){
		this.nature = nature;
		setScore(score);//并且这个属性是子类无法直接访问到的
	}

	//看看子类可以访问父类哪些属性
	public void whatCanVisit(){
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(getIdCard());//父类的private idCard不可以直接访问到
	}

	//考试类需要重写
	public void exam(){
		System.out.println("小学生正在考试...");
		Random random = new Random();
		setScore(random.nextInt(100));
	}

	public void showInfo(){
		super.showInfo();//复用父类的显示函数，父类使用super关键字，本类使用this
		System.out.println("天性：" + getNature());
	}

	//get\set
	public String getNature(){
		return nature;
	}

	public void setNature(String nature){
		this.nature = nature;
	}
}
