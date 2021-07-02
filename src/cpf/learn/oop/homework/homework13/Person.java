package cpf.learn.oop.homework.homework13;

public class Person{
	private String name;
	private int age;
	private char sex;
	private String hobby;

	//共有玩耍方法
	public String play(){
		return name + "爱玩" + hobby;
	}

	@Override
	public String toString(){
		return "name='" + name + '\'' +
				", age=" + age +
				", sex=" + sex +
				", hobby='" + hobby + '\'';
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public char getSex(){
		return sex;
	}

	public void setSex(char sex){
		this.sex = sex;
	}

	public String getHobby(){
		return hobby;
	}

	public void setHobby(String hobby){
		this.hobby = hobby;
	}
}
