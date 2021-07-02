package cpf.learn.chapter10.innerClass;

/**
 * 静态内部类：
 * 1.可以直接访问外部类的所有静态成员，但不可以直接访问非静态成员
 * 2.可以添加任意访问修饰符，地位如同成员变量
 * 3.作用域，整个外部类体
 * 4.其他类---访问--->静态内部类：
 **** 4.1 Outer04.Inner04 inner04 = new Outer04.Inner04();这个是特殊的
 **** 4.2 在外部类中创建static方法，返回内部类对象，很简便，这也很通用
 **** 4.3 不可以通过外部类对象来创建静态内部类对象，这个很特别，
 **** 我们都知道，静态属性虽然建议通过类名直接获得，但作为属性，也可以被对象访问到，
 **** 但是静态内部类，居然不可以通过外部类对象建立
 * 5.属性同名问题：
 * 若静态内部类的成员与外部类静态成员重名（静态内部类能直接访问到的只有外部类静态成员），
 * 仍然是【就近原则 + 外部类名.外部类静态属性名】来区别访问
 *
 *
 *
 *
 *
 */
public class StaticInnerClass{
	public static void main(String[] args){

		//1.通过类名直接访问
		Outer04.Inner04 inner04 = new Outer04.Inner04();
		inner04.visit();

		//2.通过外部类对象也应该能访问---->居然会报错，不可以
		/*Outer04 outer04 = new Outer04();
		Outer04.Inner04 inner041 = outer04.new Inner04();*/

		//3.通过在外部类中建立适当的方法(在该方法中，可以直接访问到内部类，很简便)
		Outer04.Inner04 inner041 = Outer04.getInstance();
		inner041.visit();



	}//end main
}//end class

class Outer04{
	private int n = 10;
	private static int x = 10;

	static class Inner04{

		public void visit(){
			System.out.println("x = " + x);
		}
	}

	public static Inner04 getInstance(){
		return new Inner04();
	}
}
