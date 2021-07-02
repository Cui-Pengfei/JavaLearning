package cpf.learn.oop.poly;

/**
 * 4.多态注意事项
 *      4.1 属性的访问看编译类型，属性没有重写之说，编译类型是什么类，就访问什么类的属性
 *      4.2 instanceof 比较操作符，用于判断对象的类型是否为XXX类型或XXX类型的子类型...
 *          >语法：对象(引用指向的对象) instanceof 类
 *          >instanceof是关系运算符
 *          >关系表达式的结果只有true false
 *        >>>instanceof判断的是【对象】的类型，而不是【引用】的类型，
 *           因此要看运行类型，而不是编译类型...
 */
public class Notice{
	public static void main(String[] args){
	//4.1 ...
		//向上转型
		Base base = new Sub();
		System.out.println(base.num);//100
		System.out.println(base instanceof Sub);//true 表明判断的是base的运行类型

		//再向下转型
		Sub sub = (Sub)base;
		System.out.println(sub.num);//10

	//4.2 ...
		System.out.println("我是字符串" instanceof String);//true
		System.out.println(sub instanceof Base);//true

		System.out.println(new Sub() instanceof Base);//true
		//System.out.println(Sub instanceof Base);会报错，说面判断的是对象的类型...

		String s = "hello";
		//会报错，两个完全没关系类不能随便instanceof
		//System.out.println(s instanceof Sub);
		System.out.println(s instanceof Object);



	}//end main
}//end public class

class Base{//父类
	int num = 100;
}

class Sub extends Base{//子类
	int num = 10;
}


