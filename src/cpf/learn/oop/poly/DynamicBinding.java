package cpf.learn.oop.poly;

/**
 * 动态绑定机制学习：重要程度 *****
 *      1.当调用对象方法时，对象引用的编译类型约束可使用的方法种类，运行类型约束方法查询起点，
 *        方法调用的查询起点会和该对象的内存地址(运行类型)绑定，这就是后绑定(运行时多态)的核心
 *      2.当调用属性时，哪里声明，就调用那里的属性，不存在动态绑定机制...
 * 思考：设计者为什么要这么设计？？
 *      >>>某一个类这种的方法在调用属性时，目的肯定是调用本类的属性，
 *      因此属性调用的的本地化保证了这一点，
 *         而方法重写的目的是为了表现出子类特有的行为，因此调用方法的查询入口从子类开始...
 *
 *
 *      3.方法重写的缺陷
 *        当父类的private方法，在子类中也存在同名同参的方法时，是不会发生方法重写的，
 *           因为private类是属于final的，final的方法是不会被重写的，且final方法是前绑定的，
 *           子类中的同名同参方法是一个全新的方法。
 *        当父类中有方法调用此private方法时，只会调用父类的该方法，而不会动态绑定去访问子类的该方法
 *            该特性是符合逻辑的，因为父类中方法既然是private的，还有别的方法调用它，
 *            自然是想调用父类本身的这个方法，机制保证了这一点。
 *        为了避免误解，通常情况下，需要我们取名时，避免子类中有父类private的同名方法，以免误解，
 *             当然有时候也可以利用这特性来做一些事情，不过尽量避免为好...
 *
 *
 *
 *
 *
 */
public class DynamicBinding{
	public static void main(String[] args){
		A a = new B();
		System.out.println(a.sum());
		System.out.println(a.sum1());

		//3.方法重写缺陷一
		System.out.println();
		a.privateOverride();


	}//end main
}//end class

//非常经典的动态绑定例子...
class A{//父类
	public int i = 10;

	public int sum(){ return getI() + 10; }

	public int sum1(){ return i + 10; }

	public int getI(){ return i; }

	//3.方法重写缺陷一
	public void privateOverride(){
		f();
	}
	private void f(){
		System.out.println("private f()...");
	}
}

class B extends A{//子类
	public int i = 20;

	//public int sum(){ return i + 20; }

	//public int sum1(){ return i + 20; }

	//@Override
	//public int getI(){ return i; }

	//3.方法重写缺陷一
	public void f(){
		System.out.println("public f()...");
	}
}


