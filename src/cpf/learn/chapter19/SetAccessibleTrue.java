package cpf.learn.chapter19;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author CPF 创建于： 2021/7/25 17:31
 * @version 1.0
 * Dog类中
 * 私有成员的爆破：
 * 注意：得到的多个成员组成的数组时，每次成员在数组中的顺序是不确定的，
 * 因此要单独访问还是依照name来比较好
 *
 */
public class SetAccessibleTrue{

	@Test
	public void burstConstructor() throws Exception{
		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");
		//只能得到public修饰的构造器
		Constructor<?>[] constructors = aClass.getConstructors();
		for(Constructor<?> constructor : constructors){
			System.out.println(constructor);
		}

		//能得到所有的构造器
		System.out.println("====================================");
		Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
		for(Constructor<?> declaredConstructor : declaredConstructors){
			System.out.println(declaredConstructor);
		}

		//得到的私有构造器必须爆破后才能用于创建实例
		Constructor<?> privateCon =
				aClass.getDeclaredConstructor(String.class, boolean.class);
		privateCon.setAccessible(true);
		Object aDog = privateCon.newInstance("哈士奇", true);
		System.out.println(aDog);

	}

	@Test
	public void burstField() throws Exception{
		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");
		Object dog = aClass.newInstance();

		//这种方式只能得到public的属性
		Field[] fields = aClass.getFields();
		for(Field field : fields){
			System.out.println(field);
		}

		//何种方式可以得到所有的属性
		System.out.println("========================");
		Field[] declaredFields = aClass.getDeclaredFields();
		for(Field declaredField : declaredFields){
			System.out.println(declaredField);
		}

		System.out.println("=====私有属性的获得也必须要爆破=========");
		Field nameField = aClass.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(dog, "泰迪");//可以通过set方法来改变某个对象的属性值
		Object name = nameField.get(dog);
		System.out.println(name);
		//如果是静态属性，那么第一个对象参数可以写为null
		Field typeFiled = aClass.getDeclaredField("type");
		typeFiled.set(null, "狗狗科");
		Object type = typeFiled.get(null);
		System.out.println(type);

	}

	@Test
	public void burstMethod() throws Exception{
		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");
		Object dog = aClass.newInstance();

		System.out.println("========只能得到public的方法=======");
		//但会得到很多编译器自己创建的方法
		Method[] methods = aClass.getMethods();
		for(Method method : methods){
			System.out.println(method);
		}


		System.out.println("+++++++++++想要得到所有的方法++++++++++++");
		Method[] declaredMethods = aClass.getDeclaredMethods();
		for(Method declaredMethod : declaredMethods){
			System.out.println(declaredMethod);
		}

		//私有方法也必须要爆破才可以访问
		Method hobby = aClass.getDeclaredMethod("hobby");
		hobby.setAccessible(true);
		hobby.invoke(dog);

		//静态方法
		Method staticMethod = aClass.getMethod("staticMethod");
		staticMethod.invoke(null);//因为类成员不需要关联任何实例
	}

}


