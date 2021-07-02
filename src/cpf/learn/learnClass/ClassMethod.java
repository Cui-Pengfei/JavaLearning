package cpf.learn.learnClass;

import java.lang.reflect.Field;

/**
 * Class对象有很多强大的API，也就是实现的一些方法：
 * 1.
 */
public class ClassMethod{
	public static void main(String[] args) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException, NoSuchFieldException{
		String classAllPath = "cpf.learn.learnClass.Car";
		Class<?> aClass = Class.forName(classAllPath);//1.这是一个Class对象 ，对应是Car类

		System.out.println("2. " + aClass);//2.输出全类名，到底是哪一个类的类对象
		System.out.println("2. " + aClass.getName());//其他都重写了getName()方法，获得裸名

		System.out.println("3. " + aClass.getClass());//3.输出运行类型，现在在运行的是什么类？是Class类

		System.out.println("4. " + aClass.getPackage());//4.查看这个类对象对应的类所在的包

		//5.从Class对象创建相应的对象实力 newInstance()返回的是Object的一个直接派生类 T
		Object o = aClass.newInstance();//获得Car对象并向上转型
		Car car = (Car)o;
		car.setName("宝马");car.setColor("红色");car.setPrice(1000000);
		System.out.println(car);

		//6.通过反射获得属性
		Field name = aClass.getField("name");//此方法只有公有属性才能获取到，私有属性会报错
		System.out.println(name.get(car));
		//7.通过反射给属性赋值
		name.set(car, "奔驰");
		System.out.println(car.name);
		//8.反射得到所有的字段属性
		Field[] fields = aClass.getFields();
		System.out.println("8.反射得到所有的字段属性：");
		for(Field field : fields){
			System.out.println(field.get(car));
		}


	}//end main
}//end class