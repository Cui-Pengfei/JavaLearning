package cpf.learn.chapter17.exercise.homework03;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/7/14 18:20
 * @version 1.0
 */
public class LoadAndCreate{
	public static void main(String[] args) throws IOException{
		Properties properties = new Properties();
		properties.load(new FileReader("src/cpf/learn/chapter17/exercise/" +
				"homework03/dog.properties"));
		String name = properties.getProperty("name");
		int age = Integer.parseInt(properties.getProperty("age"));
		String color = properties.getProperty("color");

		Dog dog = new Dog(name, age, color);

		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/cpf/learn/chapter17/exercise/" +
						"homework03/dog.bat"));
		oos.writeObject(dog);
		oos.close();

	}

	@Test
	public void showDogBat() throws IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/cpf/learn/chapter17/exercise/" +
				"homework03/dog.bat"));
		Object dog = ois.readObject();
		System.out.println(dog);

	}
}

class Dog implements Serializable{
	private String name;
	private int age;
	private String color;

	private long serialVersionUID = ('D' + 'o' + 'G');

	public Dog(String name, int age, String color){
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public String toString(){
		return "Dog{" +
				"name='" + name + '\'' +
				", age=" + age +
				", color='" + color + '\'' +
				", serialVersionUID=" + serialVersionUID +
				'}';
	}
}
