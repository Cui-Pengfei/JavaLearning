package cpf.learn.chapter10.abstract_;

/**
 * 抽象类、抽象方法的学习
 * 1.抽象方法、抽象类
		 * 1.1 父类方法不确定性（父类只是想提供一个定义而已）
		 * 1.2 所谓抽象方法就是没有实现的方法，没有实现的意思就是没有方法体
		 * 1.3 当一个方法是抽象方法时，包含此方法的类必须是抽象类
		 * 1.4 抽象类会被继承，由其子类来实现抽象方法，抽象类只是提供统一的方法接口
 * 2.细节说明
		* 2.1 抽象类是不可以被实例化的
		* 2.2 抽象类可以不包含抽象方法，可以包含一般实现的方法，包含抽象方法的一定是抽象类
		* 2.3 抽象类除了不能实例化外，其他与正常类无异，她还是类，可以有任意成员。
		* 2.4 abstract只能修饰类和方法(不能修饰构造器)，不能修饰属性和其他的
		* 2.5 抽象方法不能有方法体
		* 2.6 如果一个类继承了抽象类，那么他必须实现抽象类的所有抽象方法，除非他自己也想做一个抽象类
		* 2.7 所谓的实现了父类的抽象方法就是有了方法体
        * 2.8 抽象方法不能被final、static、private修饰，因为这些都是与重写违背的关键字，
        *      只能使用public、protected来修饰
 * 3.应用场景
		* 3.1 抽象类多用于模板模式的开发
		* 3.2 当多个类有共同的代码、不同的个性的的时候，可以使用抽象类，
			* 提取出相同的元素放入抽象类，个性元素仍放在多个类中，
			* 通过动态绑定机制在运行时定位到各个不同的地方，实现代码的复用与简洁
 */
public class AbstractIntro{
	public static void main(String[] args){
		//Animal animal = new Animal();//抽象类不可以被实例化
	}//end main
}//end class
@SuppressWarnings({"unused"})
abstract class Animal{
	public String name;

	public static int count = 9;//抽象类除了不能实例化，与其他类无异

	public void say(){//可以有自己的一般方法
		System.out.println("hello");
	}

	public Animal(String name){
		this.name = name;
	}

	public abstract void eat();//抽象方法eat

	public abstract void move();//抽象方法move

	public abstract void inherit();//抽象方法inherit

}
@SuppressWarnings({"unused"})
class Fish extends Animal{

	public Fish(String name){
		super(name);
	}

	@Override
	public void eat(){

	}

	@Override
	public void move(){

	}

	@Override
	public void inherit(){

	}
}
@SuppressWarnings({"unused"})
abstract class Cat extends Animal{

	public Cat(String name){
		super(name);
	}
}