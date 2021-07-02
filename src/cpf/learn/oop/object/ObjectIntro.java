package cpf.learn.oop.object;

import org.omg.CORBA.INTERNAL;

import java.io.PrintStream;

/**
 * Object类初步学习:
 * 1. equals()
 * 2. toString()
 * 3. finalize() 见FinalizeIntro
 * 4. getClass()
 * 5. hashCode()
 */
public class ObjectIntro{
	public static void main(String[] args){
		Object o = new Object();
		o.equals(o);
		/*
		1.==对于基本类型而言，是判断值是否相同
		    对于引用类型而言，是判断地址是否相同，也就是判断是否是指向同一对象。
		boolean equals(Object object);默认只能判断引用类型
			是基类Object中有的方法，在Object中就是用==来比较的，此事与==等价
			但是子类(Integer,String等)往往会重写此方法，用于判断内容是否相同，到时候用的时候看下源码就好了
		*/

		int i = 10;
		double d = 10.0;
		System.out.println(i == d);//true

		Object o1 = new Object();
		System.out.println(o == o1);//false 两个不同的对象
		System.out.println("abc" == "abc");//true 在字符串常量池中，相同的字符串只保留一个对象
		o1 = "我是谁";
		System.out.println(o1 == "我是谁");//true
		System.out.println(o1 == new String("我是谁"));//false 因为new关键字显示地表明新建一个对象

		System.out.println();

		System.out.println(o1.equals("我是谁"));//true
		Integer integer = new Integer(5);
		Integer integer1 = new Integer(5);
		System.out.println(integer.equals(integer1));//true
		System.out.println(integer == integer1);//false

		/*
			2.int hashCode(Object)
			确实会针对不同的对象返回不同的整数值。
		*/
		System.out.println();
		System.out.println(o.hashCode());
		System.out.println(o1.hashCode());

		System.out.println();
		System.out.println("我是谁".hashCode());
		System.out.println(o1.hashCode());//一样


		/*
		3.public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
          }
		*/
		System.out.println();
		System.out.println(o.getClass());
		System.out.println(o.getClass().getName());
		int n = 16;
		System.out.println(Integer.toHexString(n));
		System.out.println(o.hashCode());
		System.out.println(Integer.toHexString(o.hashCode()));

		System.out.println();
		System.out.println(o.getClass().getName() + "@" + Integer.toHexString(o.hashCode()));
		System.out.println(o.toString());





	}//end main
}
