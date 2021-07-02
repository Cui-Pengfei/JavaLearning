package cpf.learn.oop.homework.homework13;

public class Teacher extends Person{
	private int workAge;

	//teach方法
	public void teach(){
		System.out.println("我承诺，我会认真教学。");
	}

	@Override
	public String play(){
		setHobby("足球");
		return super.play();
	}

	@Override
	public String toString(){
		return "Teacher{" +
				super.toString() +
				" workAge=" + workAge +
				'}';
	}

	//constructor
	public Teacher(String name, char sex, int age, int workAge){
		setName(name);
		setSex(sex);
		setAge(age);
		this.workAge = workAge;
		setHobby("象棋");
	}
	//get\set
	public int getWorkAge(){
		return workAge;
	}
	public void setWorkAge(int workAge){
		this.workAge = workAge;
	}
}