package cpf.learn.chapter19.ClassIntro.learnClass;

/**
 * 学习 Class对象
 *      1.类的初始化：如果有父类，则对父类初始化，执行静态初始化器、静态初始化块；
 *          本类的初始化被延迟到了对静态方法（构造器隐式地为静态的）或者非常数静态域进行首次引用时才执行。
 *          因为常数静态域是编译器常量，这在编译器就能确定的数值的引用不会引起类的初始化，
 *          有此可见，.class实际上很像是引用了一个常数静态域，不会引起类的初始化
 */
public class ClassIntro{
	public static void main(String[] args){
		//Cat myCat = new Cat("小花喵");
		System.out.println(Cat.class);//用.class来获得类对象的引用时是不会引发类的初始化的
		System.out.println(Cat.talent);
		String eat = Cat.feed;
		System.out.println(eat);
		//Cat myCat = new Cat("小花喵");
		//System.out.println(myCat);

	}//end main
}//end class

class Cat extends Animal{
	private String name;
	public static final String talent = "爬树";//编译器常量，在编译器就把用到它的地方等价替换为常量值，有点像宏
	public static final String feed = new String("鱼");//运行期常量，因为对象只有在运行的时候才能创建

	static{
		System.out.println("加载Cat类...");
	}

	//constructor
	public Cat(){
		System.out.println("调用无参构造器...");
	}
	public Cat(String name){
		this.name = name;
		System.out.println("调用有参构造器...");
	}

	//get\set
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	static {
		System.out.println("我在末尾也会被初始化吗？ "  );
	}
}

class Animal{

	static {
		System.out.println("Animal static 代码块...");
	}

	public Animal(){
		System.out.println("Animal constructor...");
	}
}
