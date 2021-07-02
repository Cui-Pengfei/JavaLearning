package cpf.learn.oop.homework.homework13;

public class Student extends Person{
	private String id;

	//study方法
	public void study(){
		System.out.println("我承诺，我会好好学习。");
	}

	//重写玩耍方法
	@Override
	public String play(){
		setHobby("象棋");
		return super.play();
	}

	@Override
	public String toString(){
		return "Student{" +
				super.toString() +
				" id='" + id + '\'' +
				'}';
	}

	//constructor
	public Student(String name, char sex, int age, String id){
		setName(name);
		setSex(sex);
		setAge(age);
		this.id = id;
		setHobby("足球");
	}
	//get\set
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
}
