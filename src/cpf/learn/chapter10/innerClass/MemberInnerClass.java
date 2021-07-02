package cpf.learn.chapter10.innerClass;

/**
 * 成员内部类：
 * 1.成员内部类在外部类的成员位置，可以使用修饰成员的四个访问修饰符，表示访问权限
 * 其他类是否能访问到该成员类，与这个修饰符有关，与访问成员的规则一样
 * 2.作用域：与外部类的其他成员一样，作用域为整个类体，在外部类的成员方法中创建成员内部类对象
 * 再调用方法，实现对成员内部类的使用
 * 3.成员内部类---访问--->外部类（属性、方法）：直接访问
 * 4.外部类--->访问--->成员内部类：在外部类体内，创建成员内部类的对象，然后调用对象的成员
 * 5.成员内部类的私有属性，可以被外部类的方法通过【成员内部类对象.属性名】直接访问到，
 *   这一点有点绕，通过反编译工具可以看到，jvm 帮你在内部类中为 private 属性生成了一个
 *   static 的 acess$000 的方法，外部类之所以可以调用内部类的 private，
 *   其实是因为隐式的调用了 access$000 方法。
 * 6.其他类---访问--->成员内部类：
 *      7.1 OuterClass.InnerClass inner = outerObject.new InnerClass();
 *      7.2 在外部类中编写一个方法，可以返回Inner类型的对象
 * 7.成员内部类与外部类有同名属性时，还是老一套，就近原则+外部类名.this.属性名
 * 8.成员内部类可以直接访问到外部类的静态属性，因为非静态可以访问非静态+静态
 *
 */
public class MemberInnerClass{
	public static void main(String[] args){
		Outer03 outer03 = new Outer03();
		outer03.visit();
		Outer03.Inner03 inner03 = outer03.new Inner03(3);
		System.out.println(inner03.available);//内部类的public属性在其他类中可见
	}//end main
}

class Outer03{
	private int x = 1;
	private static int a = 0;

	public class Inner03{
		//同名的私有属性
		private int x = 2;

		//共有属性可以被其他类通过内部类对象访问到
		public int available = 10;

		public void visit(){
			System.out.println(x);
			System.out.println(Outer03.this.x);
			System.out.println(a);
		}

		//构造器
		public Inner03(int x){
			this.x = x;
		}

		//get\set
		public int getX(){
			return x;
		}
		public void setX(int x){
			this.x = x;
		}
	}//end innerClass

	public void visit(){
		System.out.println(x);
		Inner03 inner03 = new Inner03(2);
		System.out.println(inner03.x);
		inner03.visit();

	}
}//end outerClass
