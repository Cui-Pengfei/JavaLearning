package cpf.learn.chapter10.static_;

/**
 * 静态变量(类变量)的学习.
 *      1.某一个类的静态变量(此处指的是属性)，被所有对象共享.
 *      2.类变量在类加载的时候就生成了.
 *      3.在JDK7以前，我们认为静态变量位于方法区的静态域
 *        > 在JDK7及以后版本，静态变量在堆中的类对象里，且位于类对象尾部，
 *          通过类对象可以访问到很多类信息。
 *        > 类对象是一个模板，所有此类实例化的对象都要照此模板来创造.
 */
public class StaticIntro{
	public static void main(String[] args){
// 4.类变量的访问仍然遵循访问控制符的规则
		System.out.println(Person.name);
		//System.out.println(Person.height);
		System.out.println(Person.getHeight());
	}
}

class Person{
	public static String name = "崔鹏飞";
	private static double height = 175;

	static {
		System.out.println("Person类初始化...");
	}

	//get\set

	public static double getHeight(){
		return height;
	}
	public static void setHeight(double height){
		Person.height = height;
	}
}
