package cpf.learn.chapter10.codeBlock;

/**
 * 代码块细节说明：
 *      1.带static的代码块叫静态代码块，作用是对类进行初始化，它随着类的加载而执行，并且只会执行一次
 *        而普通的代码块，作用是对对象进行初始化，没创建一个对象，普通代码块都会执行一次。
 *        即使是普通代码块，其执行优先级仍然高于构造器内的语句
 *      2. 类什么时候会被加载？
 *          任何导致类或者对象初始化的动作，都会导致类的加载，反而是类不加载的情况比较少：
 *          > 当调用编译期常量的时候，类不会被加载.
 *          > 当使用类字面常量.class时，不会导致类的加载
 *      3. 只使用类的静态成员，不会导致普通代码块的调用，
 *          只有创建对象时，普通代码块才会被隐式地调用执行。
 */
public class CodeBlockDetail{
	public static void main(String[] args){
		System.out.println(Cat.talent);
		System.out.println(Cat.class);
		System.out.println(Cat.name);
		Cat cat = new Cat();//3. 直到创建对象，普通代码库才会被执行
		Cat cat1 = new Cat();//又一次调用普通代码块
	}//end main
}

class Cat{
	public static String name = "波斯猫";//调用非常数静态域，会导致类的初始化
	public static final String talent = "爬树";//编译器常量的调用，不会导致类的初始化

	static {
		System.out.println("我是静态代码块，说明Cat类被加载...");
	}

	{
		System.out.println("我是普通代码块");
	}
}
