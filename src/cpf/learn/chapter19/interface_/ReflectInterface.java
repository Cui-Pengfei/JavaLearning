package cpf.learn.chapter19.interface_;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author CPF 创建于： 2021/7/29 16:49
 * @version 1.0
 * 反射接口也是可以的：
 * 1.接口的static方法是可以反射到的
 * 2.接口的属性可以反射到
 * 3.接口的抽象方法、默认方法不可以反射到
 *
 */
public class ReflectInterface{
	public static void main(String[] args) throws Exception{
		//System.out.println(Usb.class);//cpf.learn.chapter19.interface_.Usb
		Class<?> aClass = Class.forName("cpf.learn.chapter19.interface_.Usb");

		//可以反射到静态方法
		Method sayHello = aClass.getMethod("hi");
		sayHello.invoke(null);

		//通过发射获得了接口的属性，因为接口都默认是public static final的，不用构建实例
		Field[] declaredFields = aClass.getDeclaredFields();
		for(Field declaredField : declaredFields){
			System.out.println(declaredField);
			System.out.println(declaredField.getName() + " = " + declaredField.get(null));
		}
	}
}
