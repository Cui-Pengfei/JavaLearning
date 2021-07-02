package cpf.learn.chapter10.innerClass;
  /**
 * 匿名内部类的学习：
 * 1.本质还是一个类
 * 2.是一个内部类
 * 3.该类表面上没有名字，实际上JDK会分配1名字
 * 4.它同时还是一个对象
 * 【基本语法】
 * new 类、接口(参数列表){//是已经存在的类和接口
 *     类体;
 * }
 */
public class AnonymousInnerClass{
	public static void main(String[] args){
		Outer02 outer02 = new Outer02();
		outer02.getVisit();
	}//end main
}

class Outer02{
	private String name = "Outer02";

	public void getVisit(){

		//基于接口：匿名内部类
		/*
		1.接口不会有构造器，因此new的时候，参数列表为空
		2.新建的匿名内部类，是对接口的一种新的实现，
		  这种实现可能只用一次，因此没必要新建一个类
		3.匿名内部类底层是有名字的，只是程序员无法看到、无法使用该名字
		4.匿名内部类的访问权限，以及与外部类的交互，与局部内部类相似
			> 地位都是局部变量
			> 作用域都是方法体内、代码块中
			> 局部内部类由于在局部还有是否继承的选择，因此可以选择是否用final
			  匿名内部类，只用一次，类就销毁了，不能加任何访问修饰符
	     5.匿名内部类与外部类有同名属性时，遵循就近原则，要访问外部类的同名属性，
	        使用【外部类.this.属性名】
		 */
		Catable monkey = new Catable(){//其实是一个向上转型
			@Override
			public void climb(){
				System.out.println("猴子会爬树");
			}
		};
		monkey.climb();
		System.out.println(monkey.getClass().getName().substring(31));

		//基于类的匿名内部类
		/*
		1.实际上，新建了一个子类，我们知道，子类都必须有构造器，且必须调用父类的某个构造器，
		   由于匿名，无法建立构造器，因此直接在new的时候，填入相应的参数列表来调用父类构造器
		   自己不创建构造器，直接复用父类的构造器
		2.若父类为抽象类，则新建的匿名内部类必须实现父类的所有抽象方法
		3.由于有new关键字来创建实例，因此匿名内部类不可能是抽象类，也不可能是接口
		4.
		 */
		Dog dog = new Dog("旺财"){
			@Override
			public String getName(){
				return name;
			}
		};
		System.out.println(dog.getClass().getName().substring(31));
		System.out.println(dog.getName());

		//使用匿名内部类的另一种方式
		System.out.println(
			new Dog("旺财"){
				@Override
				public String getName(){
					return name;
				}
			}.getName()
		);
	}
}

class Dog{
	public String name;

	public Dog(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}

interface Catable{
	void climb();
}
