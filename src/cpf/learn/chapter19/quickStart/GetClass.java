package cpf.learn.chapter19.quickStart;

import cpf.learn.chapter19.Dog;

import java.io.IOException;

/**
 * @author CPF 创建于： 2021/7/23 14:14
 * @version 1.0
 */
public class GetClass{
	public static void main(String[] args) throws Exception{
		//cpf.learn.chapter19.quickStart.Dog
		Dog dog = new Dog();

		//分别通过类、对象、全类名获得对应的类对象，为进一步反射提供起点
		Class<Dog> dogClass = Dog.class;

		/*因为Dog类栈变量可能指向的是Dog的子类(向上转型)，所以这里是泛型的通配符形式*/
		Class<? extends Dog> dogClass1 = dog.getClass();

		/*因为此处根本不知道会加载什么类对象进来，因为通配符是?*/
		Class<?> aClass = Class.forName("cpf.learn.chapter19.quickStart.Dog");

		System.out.println(dogClass);
		System.out.println(dogClass1);
	}
}
