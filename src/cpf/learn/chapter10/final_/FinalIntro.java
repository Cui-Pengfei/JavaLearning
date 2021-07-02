package cpf.learn.chapter10.final_;

/**
 * 对关键字final的学习：
 *      >>>final可以修饰类、属性、方法、局部变量
 *      1.final修饰类，表示不希望该类被继承(继承final类会在编译期报错)
 *      2.final修饰方法，表示不希望父类的该方法被子类重写覆盖(重写final方法会在编译期报错)
 *      3.final修饰属性，表示不希望该属性的值发生改变，且此属性只允许赋值一次，
 *          若final属性定义时就被初始化，那么一次赋值机会耗尽，在任何其他地方都不允许被改变值；
 *          若final属性定义时没有初始化，则一定要保证在以下位置赋值：
 *          3.1 构造器：每个构造器都必须给final属性初始化值，当然有多个构造器就用下面这种
 *          3.2 代码块：因为代码块又叫初始化器，跟初始化块是同等优先级的
 *      注意：static修饰的final属性很特殊，因为该属性在类初始化时就要完成初始化，
 *           因此在构造器中初始化是没有用的，只能在定义时初始化、或者静态初始化器中初始化
 *      4.final对象只是不能被继承，但是正常实例化是没有问题的
 *      5.final修饰的方法，虽然不能重写，但是仍然可以被继承
 *      （子类仍然有父类的final方法，只要该方法不是private类型的）
 *
 *  二、使用技巧:
 *      6.一般来说，只要一个类是final类型的，那么没有必要再将其中的方法设置为final的了
 *          （这很好理解，因为不被继承的类，它的方法其实就是final的，根本不会被重写）
 *      7.final不能修饰构造器
 *      (这毫无意义，因为构造器名与类名一致，类名是不允许重复的，根本不会出现使用final的场景)
 *      8.final与static往往搭配使用，效率更高，因为如果这两个修饰的变量若为常量，
 *        则该变量称为【编译期常量】，由于编译器有一个优化，使用编译期常量不会导致类的加载，效率很高
 *        这个常量包含数值、字面量，若该变量是一个new的对象，则引用该变量仍然会导致类的初始化。
 *      9.包装类、String都是final类型的
 *
 ****
 *
 *
 */
public class FinalIntro{
	public static void main(String[] args){
		System.out.println(A.talent);

	}//end main
}//end class

class A{
	public final int month;
	public String name;
	public static final int days;
	public static final String talent = new String("swim");

	public final void hi(){
		System.out.println("say hi~");
	}

	{
		month = 10;
	}

	static {
		System.out.println("类被初始化....");
		days = 365;
	}

	public A(String name){
		this.name = name;
	}


}