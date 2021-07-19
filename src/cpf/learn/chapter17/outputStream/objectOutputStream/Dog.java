package cpf.learn.chapter17.outputStream.objectOutputStream;

import java.io.Serializable;

/**
 * @author CPF 创建于： 2021/7/13 10:26
 * @version 1.0
 */
public class Dog implements Serializable{
	private String name;
	private int age;

	private static String color;
	private transient double height = 1.2;

	private final long serialVersionUID = 1L;

	public Dog(String name, int age){
		this.name = name;
		this.age = age;
	}

	public Dog(String name, int age, double height, String color){
		this.name = name;
		this.age = age;
		this.height = height;
		this.color = color;
	}

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


	@Override
	public String toString(){
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				", color=" + color +
				'}';
	}
}
