package cpf.learn.oop.extend_;

/**
 * 方法重写（方法覆盖）override
 *【学前理解】
 *       > 访问类的成员时，采用的是就近原则，若子类具有与父类一样的方法，在子类对象使用该方法名时，
 *          就只能访问到子类的方法，无法访问到父类的方法，于是说父类该方法被覆盖了...
 *       > 应该明确，【覆盖】的意思是隐藏起来，并不代表父类的该方法不存在了，而是无妨通过方法名直接
 *          访问到了，但是通过super.method();仍然是可访问的...
 *       > 利用【方法覆盖】和【super击穿】，我们可以使一些具有继承关系的类，在各自实例化对象访问
 *          同名方法时，具有基于本类的、该方法名描述的、一致化的意义。
 *
 *    1.基本介绍
 *       子类具有与父类同样的一个方法(返回类型、方法名、参数列表均一致)，
 *       那么我们就说子类的这个方法重写（覆盖）了父类的方法
 *
 *    2.细节介绍
 *       2.1 子类方法的名字、参数列表必须与父类完全一致
 *       2.2 子类方法的返回类型必须与父类一致，或者是父类对应方法返回类型的子类,
 *              不然就会报错...
 *       2.3 子类方法不能缩小父类方法的访问权限
 *           理解：java执行开闭原则：对扩展开发，对修改关闭（抽象构建框架，实现扩展细节）
 *                而里氏代换原则是实现开闭原则重要的方式之一，
 *                >里氏代换原则(LSP)：所有引用基类（父类）的地方必须能透明地使用其子类的对象，
 *                >如果子类缩小了方法的访问范围，那父类出现的地方，子类不一定能出现了...
 *       2.4 子类是否继承了父类private的属性和方法？
 *            >>属性继承，由于private属于final大类，final的方法是不会被继承的
 *       2.5 父类私有方法是否会被重写？
 *            >>不会被重写，重写的前提是可见，既然都不可见了，还重写个毛线...
 *              private也属于final型，是前绑定的，私有方法不会被重写，也不会表现出动态绑定的特性
 *              只会表现出前绑定的特点：编译类型是什么，就调用什么类的私有方法...
 *
 *       2.6 父类静态方法是否能被重写
 *           >>静态方法不能被重写，但是子类在定义同名的静态方法时必须是静态的，
 *            因为子类会继承父类的静态方法，如果子类再拥有一个同名的普通方法，就会编译出错，
 *            报错说"普通方法无法重写静态方法"，但是如果该方法是静态的，则可以“重写”成功。
 *            但是这种重写是一种前绑定的重写，与编译类型挂钩，因此没有动态绑定效果，也不会实现转型的效果，
 *            所以说不是真正意义的重写。
 *
 *       2.7 被重写的父类方法是否还存在？
 *          > 父类被重写的方法还存在于方法区中
 *          > 【重写】只是外在表现形式的形象说法，实际上，父类的方法仍然存在于方法区中，
 * 		    > 只是，对象引用(父类或子类编译类型)在调用方法时，看的是运行类型，
 * 		           父类的同名方法被阻断掩盖了而已...
 *
 *
 *     3.重写易混淆 详情见OverrideConfuse.java（学完转型后来补充的...）
 *
 *
 *
 */
public class OverrideIntro{
	public static void main(String[] args){
		/*
		Shark shark = new Shark();
		System.out.println(shark.breed());
		System.out.println(shark.child());
		System.out.println();

		System.out.println(shark.live);
		System.out.println(shark.skill);
		System.out.println();

		shark.call();
		*/

		//2.4 向上转型，看看私有方法是否被重写？
		Fish sharkUpFish = new Shark();
		sharkUpFish.callStatement();//非静态方法与运行类型保持一致

		//2.7 此例说明父类被重写的方法还存在于方法区中，
		//【重写】只是外在表现形式的形象说法，实际上，父类的方法仍然存在于方法区中，
		//只是，对象引用在调用方法时，看的是运行类型，父类的方法阻断掩盖了而已...
		sharkUpFish.fatherStatement();//输出 Fish private statement方法...

		sharkUpFish.grow();//静态方法与编译类型保持一致

		//2.6 ...
		System.out.println("======2.6=======");
		Fish.grow();
		Shark.grow();
		sharkUpFish.grow();//这个向上转型的对象也可以使用静态方法，肯定输出编译类型的Fish
		Fish.own();
		Shark.own();

		//再向下转型
		Shark downBackShark = (Shark) sharkUpFish;
		downBackShark.grow();


		//2.7 ...



	}//end main
}//end class

//鱼类
class Fish{
	public Object live = "water";
	protected String skill = "swim";

	public Object breed(){
		return "eggs";
	}

	protected int child(){
		return 10;
	}

	private void statement(){
		System.out.println("Fish private statement方法...");
	}

	public void callStatement(){
		statement();
	}

	static public void grow(){
		System.out.println("Fish static grow方法...");
	}

	public static void own(){
		System.out.println("我是Fish独特的静态方法...");
	}

	public void fatherStatement(){

	}

}//end class
////////////////////////////////////////////////////////////////////////////////
//鲨鱼
class Shark extends Fish{

	public String  live = "blood";
	protected int skill = 1;

	//String extends Object
	public String breed(){
		return "shark";
	}

	protected int child(){//2.3原则，此处可写public 但绝对不允许private
		return 1;
	}

	public void call(){
		System.out.println(super.live);
		System.out.println(super.skill);

	}

	//2.4 私有的方法会被重写吗？
	private void statement(){
		System.out.println("Shark private statement方法...");
	}

	public void callStatement(){
		statement();
	}

	static public void grow(){
		System.out.println("Shark static grow方法...");
	}


	//2.7 看看被重写的父类方法是否还在
	public void fatherStatement(){
		super.callStatement();
	}

}


















