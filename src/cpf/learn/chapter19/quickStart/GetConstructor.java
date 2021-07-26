package cpf.learn.chapter19.quickStart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author CPF 创建于： 2021/7/23 15:05
 * @version 1.0
 */
public class GetConstructor{
	public static void main(String[] args) throws Exception{
		//获得类对象
		Class<?> aClass = Class.forName("cpf.learn.chapter19.quickStart.Dog");

		//通过类对象获得构造器对象
		Constructor<?> constructor = aClass.getConstructor(String.class);

		//通过构造器对象来实例化对象
		Object dog = constructor.newInstance("小黄");

		//通过类对象获得方法对象
		Method cry = aClass.getMethod("cry");

		//通过某个类的方法对象，连接到某个类的对象实例，调用该对象实例的该方法
		/*因为这个对象编译类型是Object,这样做可以保证一切都在运行期间完成，
		不必知道这类到底是从哪里来的，一般类的全类名、方法名都从文件中获得*/
		cry.invoke(dog);

	}
}
