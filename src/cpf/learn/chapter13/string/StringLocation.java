package cpf.learn.chapter13.string;

import java.lang.reflect.Field;

/**
 * @author CPF 创建于： 2021/6/16 2:48
 * 不同方式创建的String对象到底位于哪里呢？
 *
 */
public class StringLocation{
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{
/*1. 把new出来的String对象intern()入常量池，常量池的这个String对象是新的吗？*/
		String string = new String("傻子");
		String string2 = string;
		//【判断方式一】
		System.out.println(string == string.intern());//false
		System.out.println(string.hashCode());//664053
		System.out.println(string.intern().hashCode());//664053
		/*
		为何不是一个对象，hashCode却一样？？？？？？
		hashCode的总合同是：
		1.同一个对象多次调用hashCode，必须保证值一致，但不必从一次执行到另一次执行保持一致
		2.两个对象equals为真 <=> 两个对象的hashCode值相等，该规则表明，当重写hashCode和equals方法时，
		  必须使此规则得到贯彻
		3.显然，String重写了hashCode()、equals()方法，但贯彻了2.中的规则
		 */

		//【判断方式二】
		System.out.println(string == string.intern());//false
		System.out.println(System.identityHashCode(string));//21685669
		System.out.println(System.identityHashCode(string.intern()));//2133927002
		/*
		System.identityHashCode(obj)能够唯一标识对象，不管该对象是否重写了hashCode()方法
		 */
/*1. 综上所述：原本不再常量池内的String对象，通过intern()后会在常量池中新建一个String对象，
	 而不是在池中保留一份对象引用*/

/*2. 证明这两个不同对象仍然共用一个value[]*/
		Field valueStringField = String.class.getDeclaredField("value");
		valueStringField.setAccessible(true);//打卡通道
		char[] value1 = (char[]) valueStringField.get(string);
		char[] value2 = (char[]) valueStringField.get(string.intern());
		System.out.println(System.identityHashCode(value1));//325040804
		System.out.println(System.identityHashCode(value2));//325040804

/*3. new String("hello");后，虽然字面量"hello"无人引用，但仍然会在池中维持一个字面量为"hello"的对象，
	 这是因为，字符串常量池中有一个表，总是为池中每个唯一字面量维护一个引用，因此不会被垃圾回收器回收
 */


	}
}
