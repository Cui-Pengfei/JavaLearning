package cpf.learn.oop.extend_;

import java.util.Random;

/**
 * 学生类，继承人类
 */
public class Student extends Person{

	public String school;//所在学校
	protected String subject = "数学";
	String studentID = "i am studentID";//学号
	private double score;//分数

	@Override
	public void say(){
		System.out.println("Student override Person...");
	}

	//考试方法,获得一个[0,100]的随机整数
	public void exam(){
		System.out.println("学生正在考试...");
		Random random = new Random();
		score = random.nextInt(101);
	}

	//展示信息方法
	public void showInfo(){
		System.out.println("信息如下：");
		System.out.println("姓名：" + getName());
		System.out.println("性别：" + getGender());
		System.out.println("年龄：" + getAge());
		System.out.println("身份证：" + getIdCard());
		System.out.println("学校：" + getSchool());
		System.out.println("学号：" + getStudentID());
		System.out.println("分数：" + getScore());
	}

	//构造器 也要选择父类的构造器，本质上是一个组合的问题
	public Student(){
		System.out.println("Student无参构造器...");
	}

	public Student(String school, String studentID, double score){
		System.out.println("Student三个参数构造器....");
		this.school = school;
		this.studentID = studentID;
		this.score = score;
	}

	public Student(String name, char gender, int age, String idCard,
	               String school, String studentID, double score){
		super(name, gender, age, idCard);//必须是第一行代码
		System.out.println("Student七个参数构造器...");
		this.school = school;
		this.studentID = studentID;
		this.score = score;
	}

	//get\set方法
	public String getSchool(){
		return school;
	}

	public void setSchool(String school){
		this.school = school;
	}

	public String getStudentID(){
		return studentID;
	}

	public void setStudentID(String studentID){
		this.studentID = studentID;
	}

	public double getScore(){
		return score;
	}

	public void setScore(double score){
		this.score = score;
	}
}
