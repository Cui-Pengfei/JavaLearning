package cpf.learn.chapter19.ClassIntro.learnClass;


import java.io.Serializable;

/**
 * 看看那些类型具有Class对象
 *      1. 外部类、成员内部类、静态内部类、局部内部类、匿名内部类
 */
public class AllTypeClass{
	public static void main(String[] args){
		//void 也有class对象
		System.out.println(void.class);//void

		System.out.println(int[].class);//数组

		System.out.println(int[][].class);//二维数组

		System.out.println(Serializable.class);//接口

		class Inner{}
		System.out.println(Inner.class);//成员内部类

		System.out.println(new Comparable(){//匿名内部类
			@Override
			public int compareTo(Object o){
				return 0;
			}
		}.getClass());

		System.out.println(Override.class);//注解

		System.out.println(Thread.State.class);//枚举类

		System.out.println(Class.class);//Class


	}//end main

}
