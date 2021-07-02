package cpf.learn.chapter10.codeBlock;


/**
 * 探究一个类创建时，发生事情的顺序：
 * 包含元素：子类父类、构造器、普通代码块、静态代码块、普通属性、类变量
 */
public class InitSequence{
	public static void main(String[] args){
		//Son son = new Son(1, 6, 77);
		int a = Son.j;
		int b = Son.i;
		/*
		0. 有一个早在编译阶段就会发生的事情，那就是编译器常量的等价替换，就像C语言的宏
		1. new关键字表明要实例化一个Son对象，调用构造器，构造器隐式地是静态的，
			本类的初始化被延迟到对静态方法(当然包括调用构造器)、非常数静态域的首次引用时才执行。
			调用编译期常量、Class.class是不会触发类的初始化的。
		2. Son类要初始化，首先要初始化其父类Parent，由于Object无初始化语句，因此没有向上追溯。
		3. 初始化Parent类，会调用其静态初始化器和静态初始化块（被static修饰的部分）
			----静态初始化块是被static修饰的一条初始化语句，往往是定义时就初始化
			----静态初始化器是被static修饰的一块初始化语句，也是用于类的初始化
			>>>>初始化块、初始化器 拥有同等的优先级，其调用顺序按定义他们的代码顺序来进行
		4. 类初始化完成后，由于new关键字要新建一个对象，调用构造器时会触发对象的初始化，
		5. 初始化对象，会调用初始化语句块、初始化器(这与类初始化一致，只是这个是非静态的)
			>>>>初始化块、初始化器拥有同等的优先级，其调用顺序与代码的定义顺序一致。
		6. 【类的初始化】总是在【对象的初始化】之前
		7. 最后执行构造器中显示的代码，是因为，构造器身体的最前面隐藏了super()和调用普通代码块，
			因此，看起来顺序颠来倒去的。

		 */
	}//end main
}

class Parent{
	public int a;
	public int b = 2;
	public static int c;
	public static int d = 4;
	public static final int e = 5;//编译期常量

	static{//静态代码块
		System.out.println("Parent静态代码块...");
		c = 3;
	}

	{//普通代码块
		System.out.println("Parent普通代码块...");
		a = 1;
	}

	//两个构造器
	public Parent(){
		System.out.println("Parent无参构造器");
	}

	public Parent(int a, int b){//一般不会构造类变量
		System.out.println("Parent构造器调用...");
		this.a = a;
		this.b = b;
	}
}

class Son extends Parent{
	public int f;
	public int g = 7;
	public static int h;
	public static int i = 9;
	public static final int j = 10;//编译期常量

	static{//静态代码块
		System.out.println("Son静态代码块...");
		h = 8;
	}

	{//普通代码块
		System.out.println("Son普通代码块...");
		f = 6;
	}

	//4个构造器
	public Son(){
		System.out.println("Son无参构造器...");
	}

	public Son(int f, int g){
		System.out.println("Son全部特殊属性构造器...");
		this.f = f;
		this.g = g;
	}

	public Son(int a, int b, int f, int g){
		super(a, b);
		System.out.println("Son包含父类两个属性的构造器...");
		this.f = f;
		this.g = g;
	}

	public Son(int a, int f, int g){
		System.out.println("Son混杂属性的构造器...");
		this.a = a;//super.a = a;是一样的
		this.f = f;
		this.g = g;
	}
}
