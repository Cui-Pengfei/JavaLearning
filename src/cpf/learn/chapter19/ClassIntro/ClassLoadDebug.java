package cpf.learn.chapter19.ClassIntro;

import cpf.learn.chapter19.Dog;

/**
 * @author CPF 创建于： 2021/7/24 13:17
 * @version 1.0
 *
 */
public class ClassLoadDebug{
	public static void main(String[] args) throws Exception{
		/*

		Dog dog = new Dog();
		System.out.println(dog.getClass());
		System.out.println(dog.color);
		*/

		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");
		Object obj = aClass.newInstance();
		System.out.println(obj);

	}
}
