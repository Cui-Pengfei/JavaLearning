package cpf.learn.chapter19.quickStart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author CPF 创建于： 2021/7/23 15:15
 * @version 1.0
 */
public class GetFields{
	public static void main(String[] args) throws Exception{
		//从文件中加载信息
		String classAllName = "cpf.learn.chapter19.quickStart.Dog";
		String fieldName = "color";

		//根据全类名获得类对象
		Class<?> aClass = Class.forName(classAllName);

		//根据类对象获得域对象（注意这种形式只能获得public的属性）
		Field field = aClass.getField(fieldName);

		//根据类对象新建一个你想要的实例(若需要参数就要获得构造器)
		Constructor<?> constructor =
				aClass.getConstructor(String.class, String.class);

		Object dog = constructor.newInstance("小红", "红色");

		//根据域对象，链接指定的实例，得到该实例的对应属性，但该属性的编译类型是Object类型的
		System.out.println(field.get(dog));


	}
}
