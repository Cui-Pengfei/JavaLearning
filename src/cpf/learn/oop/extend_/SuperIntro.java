package cpf.learn.oop.extend_;

/**
 * 关键字 super 的使用 :
 *      【我的理解】super只能出现在构造器中，表示子类调用父类的相关构造器
 *      【实际上】
 *              super也可以出现在子类的普通方法中，可以与this同步理解，
 *              super也可以理解为类的隐藏属性，非静态，私有，因此静态方法无法访问到
 *
 * 1.基本介绍
 *      super代表父类的引用，用于访问父类的【属性】【方法】【构造器】
 *      但是父类的属性、方法都已经继承过来了呀，还用得着super吗？
 *      >>>在子类父类有同名属性、方法时，super可直接访问父类的同名方法，击穿了就近原则，贯穿了上下。
 *
 * 2.细节介绍
 *      1.super调用父类构造器是有明确意义的
 *        分工明确：父类属性由父类初始化，子类属性由子类初始化
 *        代码简洁：复用父类的构造器，提高代码复用率，简洁，可读性强
 *      2.子类与父类成员(属性、方法)重名时，为了访问父类的属性，必须使用super，
 *         并且一层层super本身就具有继承关系，非常符合现实生活...
 *         若没有重名情况，super与this的作用无异，毕竟属性、方法都继承过来了
 *      3.super关键字不限于查找直接父类，使用super会向上一路查找，找到了就不再继续向上，遵循就近原则
 *        找到了但不能访问，就报权限错误，
 *        找不到，就报缺失错误...
 *      4.super不会检查本类的成员，而是直接往上检查父类的成员
 *        this从本类开始检查成员，，没有就依次往上检查...
 *        >>>这里说的成员指的是属性、方法，不包括构造器，
 *           this只能访问本类的构造器，因为子类、父类构造器的名字是不同的...
 */
public class SuperIntro{
	public static void main(String[] args){

		Dog dog = new Dog();


	}//end main

}//end public class

class Animal{

	public String nature = "move";//移动
	protected String pass = "inherit";//传承
	String aim = "breed";//繁殖
	private String ahead = "evolution";//进化

	//构造器
	public Animal(){
		System.out.println("Animal无参构造器...");
	}

	public Animal(String nature){
		System.out.println("Animal 参数nature构造器");
		this.nature = nature;
	}

	//公共方法
	public void eat(){
		System.out.println("I am animal, i want to eat...");
	}

	//受保护方法
	protected void skill(){
		System.out.println("Animal protected skill...");
	}

	//默认方法
	void grow(){
		System.out.println("Animal can grow...");
	}

	private void hobby(){
		System.out.println("Animal private hobby...");
	}
}//end Animal class

class Dog extends Animal{
	public String bark = "汪汪汪...";

	//无参构造器
	public Dog(){
		//默认调用super();无参构造器
		System.out.println(nature + " " + pass + " " + aim);
		System.out.println(super.nature +" " + super.pass + " " + super.aim);
		eat();//继承自父类，因此可直接使用
		skill();//继承自父类，因此可直接使用
		grow();//继承自父类，因此可直接使用
		//super.hobby(); 父类私有无法访问
	}

	//子类方法中也可以使用super？
	public void call(){
		super.eat();

	}
}
