package cpf.singleModel;

/**
 * 设计模式一：单例模式
 * 1.定义
 * 单例模式，就是采取一定的措施保证在整个软件系统中，对某个类只存在一个对象实例，
 * 并且该类只提供一个取得其对象实例的方法。
 * 2.我的分析
 * > 保证外部不可以直接new对象，------构造器设置为私有的
 * > 不通过对象就可以调用的方法，-----获取对象实例的方法必须是static的且返回类型为本类
 * > 在类内部的什么位置new对象是有区别的：
 * 2.1 可以定义一个本类的属性，在属性定义时就new一个对象，当然必须是static的
 * 2.2 属性定义一个静态的本类变量，但定义时不初始化。在方法中用if判断来new对象
 * 区别：前者有一个坏处，不管我要不要实例化一个对象，只要该类初始化，就会创建一个对象.
 * 3.外界取名字：
 * 直接在属性定义时就初始化的叫饿汉式-----饿汉式是线程安全的
 * 在调用时才创建的叫懒汉式--------------懒汉式不是线程安全的，但可以解决
 */
public class SingleHungry{
	public static void main(String[] args){
		Dog myDog = Dog.getInstance("旺财");
		Dog another = Dog.getInstance("小黑");
		another.setName("小黑");
		System.out.println(another.getName());
		//Runtime类是一个经典的饿汉式单例模式


	}//end main
}//end class

class Dog{
	//2.2 使用在方法中new对象的方式-----懒汉式
	private String name;

	//在属性中只定义，不初始化
	private static Dog dog;//利用默认值null在方法中进行判断

	//私有构造器
	private Dog(String name){
		this.name = name;
	}

	//获得对象的方法
	public static Dog getInstance(String name){
		if(dog == null){
			dog = new Dog(name);
		}else{//不是的话，也就是名字要换了
			System.out.println("事先已经存在一个对象了，请使用get/set修改属性“" + name + "”");
		}
		return dog;
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
}
