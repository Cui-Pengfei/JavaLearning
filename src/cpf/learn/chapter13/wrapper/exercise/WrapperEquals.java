package cpf.learn.chapter13.wrapper.exercise;

/**
 * @author CPF 创建于： 2021/6/15 0:15
 * 1.包装类 == 判断是否相等时，要注意的事项：
 *      1.1 并不会自动装箱、拆箱：对象比较就是看是否是同一个对象，基本类型比较就是值比较
 *      1.2 直接new包装类，自然是每new一个就是一个新的类，自然判断不相等
 *      1.3 自动装箱成包装类时，情况会有分别：
 *      值位于[-128,127]内的Integer对象，会直接返回缓存内的Integer对象
 *      值位于范围之外的Integer对象，会新建对象
 *      1.4 要是Integer对象与int值 == 比较呢？
 */
public class WrapperEquals{
	public static void main(String[] args){
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i == j);
		//结果是false，这表明包装类在使用==比较时，并不会自动拆箱
		//再试一个
		Double d1 = new Double(1.1);
		Double d2 = new Double(1.1);
		System.out.println(d1 == d2);//仍然是false，没悬念

		Integer m = 1;
		Integer n = 1;
		System.out.println(m == n);//按理说，应该与上述等价，false
		/*
		光速打脸，输出结果是true，
		1.我们知道自动装箱底层实际上还是调用的Integer.valueOf(int)函数，
		2.查看源码知道，这个函数实际上会判断一个int值是否在[-128,127]之内，
		3.如果在这个范围，就返回IntegerCache.cache[]数组内的对应的Integer对象，
		4.查看IntegerCache类，可以发现有一个静态代码块，
		把值位于[-128,127]的Integer对象都放入了缓存数组cache内，这个数组第一位存放-128的Integer对象，
		按序往后推到127，共计256个对象
		5.若不在[-128,127]这个范围，就直接new Integer(i)，因此范围很重要
		 */

		Integer x = 128;
		Integer y = 128;
		System.out.println(x == y);

		//1.4 要是Integer对象与int值 == 比较呢？
		//通过debug发现Integer对象与int通过==比较时，Integer会调用intValue()方法，
		//也就是说，Integer对象会自动拆箱，这与范围无关
		//口诀：只要有基本数据类型，判断的就是值相等
		Integer integer = new Integer(128);
		Integer integer1 = 128;
		int i3 = 128;
		System.out.println(integer == i3);
		System.out.println(integer1 == i3);


	}//end main
}
