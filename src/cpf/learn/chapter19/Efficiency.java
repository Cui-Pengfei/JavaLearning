package cpf.learn.chapter19;

import java.lang.reflect.Method;

/**
 * @author CPF 创建于： 2021/7/24 12:00
 * @version 1.0
 * 反射比直接调用实例化对象效率低很多；
 */
public class Efficiency{
	public static void main(String[] args) throws Exception{
		System.out.println("正常创建实例调用方法耗时：" +
				spendTime(new SimpleJob()));
		System.out.println("反射获得实例对象调用方法耗时：" +
				spendTime(new CheckJob()));
		System.out.println("反射方法设置为易接近属性后耗时：" +
				spendTime(new AccessibleJob()));


	}

	public static long spendTime(Job job) throws Exception{
		long start = System.currentTimeMillis();
		for(int i = 0; i < job.loop; i++){
			job.work();
		}
		long end  = System.currentTimeMillis();
		return end - start;
	}
}

interface Job{
	long loop = 1000000;
	void work() throws Exception;
}

class SimpleJob implements Job{
	@Override
	public void work() throws Exception{
		Dog dog = new Dog();
		dog.cry();
	}
}

class CheckJob implements Job{

	@Override
	public void work() throws Exception{
		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");
		Object dog = aClass.newInstance();
		Method cry = aClass.getMethod("cry");
		cry.invoke(dog);
	}
}

class AccessibleJob implements Job{
	@Override
	public void work() throws Exception{
		Class<?> aClass = Class.forName("cpf.learn.chapter19.Dog");
		Object dog = aClass.newInstance();
		Method cry = aClass.getMethod("cry");
		cry.setAccessible(true);
		cry.invoke(dog);
	}
}
