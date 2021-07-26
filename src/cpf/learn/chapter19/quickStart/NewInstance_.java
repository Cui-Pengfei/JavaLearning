package cpf.learn.chapter19.quickStart;

import cpf.learn.chapter19.Dog;

/**
 * @author CPF 创建于： 2021/7/23 15:04
 * @version 1.0
 */
public class NewInstance_{
	public static void main(String[] args) throws Exception{
		Class<Dog> dogClass = Dog.class;

		Dog dog = dogClass.newInstance();
		dog.cry();
		dog.purpose();
	}
}
