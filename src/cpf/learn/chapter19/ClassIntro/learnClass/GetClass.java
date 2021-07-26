package cpf.learn.chapter19.ClassIntro.learnClass;

/**
 * 获取 Class 对象的6种方式
 */
public class GetClass{
	public static void main(String[] args) throws ClassNotFoundException{
		// 1. Class.forName("类的全路径")
		String classAllPath = "cpf.learn.chapter19.ClassIntro.learnClass.Car";
		Class<?> cls1 = Class.forName(classAllPath);
		System.out.println(cls1);

		// 2. Class.class 主要是传参时比较方便
		Class<Car> cls2 = Car.class;
		System.out.println(cls2);

		// 3. object.getClass() 运行时，通过实例对象获得该类的类对象
		Car car = new Car();
		Class<?> cls3 = car.getClass();
		System.out.println(cls3);

		// 4. 通过类加载器（有四种类加载器）来获得类的Class对象
		ClassLoader classLoader = Car.class.getClassLoader();
		Class<?> cls4 = classLoader.loadClass(classAllPath);
		System.out.println(cls4);

		//输出它们的hashCode,看看是不是同一个类对象
		System.out.println(cls1.hashCode());
		System.out.println(cls2.hashCode());//四者相同
		System.out.println(cls3.hashCode());
		System.out.println(cls4.hashCode());

		// 5. 基本数据类型（9种，包含了void）可以通过类字面常量得到Class类对象
		Class<Integer> integerClass = int.class;
		Class<Character> characterClass = char.class;
		System.out.println(integerClass);

		// 6. 基本数据类型包装类含有一个标准字段TYPE，它是一个引用，指向对应的基本数据类型的Class对象
		Class<Integer> integerClass1 = Integer.TYPE;
		System.out.println(integerClass1);

		System.out.println(integerClass.hashCode());//两者相同
		System.out.println(integerClass1.hashCode());





	}
}
