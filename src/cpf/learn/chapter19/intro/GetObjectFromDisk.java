package cpf.learn.chapter19.intro;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author CPF 创建于： 2021/7/22 15:07
 * @version 1.0
 */
public class GetObjectFromDisk{
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InstantiationException, InvocationTargetException{
		/*1.使用对象从磁盘文件读取对象
			>获取的是已经存在的特定的对象
			>通过转型才能调用对应的方法
			>仅用于数据存储、对象远程传递，有一些作用
		*/
		File file = new File("src/cpf/learn/chapter19/intro/Cat");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Cat cat = (Cat)ois.readObject();
		cat.cry(5);
		cat.hi();

		System.out.println("=======================================================");
		/*
		2.用反射从配置文件中读取对应对象的对应方法：
			>获得的是创建对象的权利，可以根据文件提示创建任意多对象
			>可以通过方法对象、配置文件的方法名，获得指定方法的调用
			>好处一大堆
		 */
		String path = "src/cpf/learn/chapter19/intro/Cat.properties";
		Properties properties = new Properties();
		properties.load(new FileInputStream(path));
		String classAllName = (String)properties.get("class");
		String methodName = (String)properties.get("method");

		System.out.println(methodName);

		//核心就是根据全类名来获得该类的类对象
		Class<?> cls = Class.forName(classAllName);
		System.out.println(cls.getClass());
		//根据类对象可以结合方法名，获得类的方法对象
		Method method = cls.getMethod(methodName);
		///////////////////////////////////////////////////为什么47行会报错呢？
		//根据类对象可以创建实例
		Object obj = cls.newInstance();
		//方法对象可以结合实例，获得该实例的方法
		method.invoke(obj, 5);


	}



	@Test
	public void writeCat() throws IOException{
		File file = new File("src/cpf/learn/chapter19/intro/Cat");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(new Cat("波斯猫"));
		oos.close();
	}
}
