package cpf.learn.chapter19;

import java.lang.reflect.Constructor;

/**
 * @author CPF 创建于： 2021/7/24 18:16
 * @version 1.0
 * 演示通过反射获得类的结构信息：
 *
 */
public class ReflectionUtils{
	public static void main(String[] args) throws Exception{
		//直接获得类名居然有API，小丑竟是我自己
		System.out.println(Dog.class.getSimpleName());

		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");

		Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
		for(Constructor<?> declaredConstructor : declaredConstructors){
			System.out.println(declaredConstructor);
		}

		System.out.println("=================================");
		Constructor<?>[] littleDogCons = LittleDog.class.getDeclaredConstructors();
		for(Constructor<?> littleDogCon : littleDogCons){
			System.out.println(littleDogCon);
		}

	}
}
