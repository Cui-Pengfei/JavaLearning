package cpf.learn.chapter13.wrapper.number;

/**
 * @author CPF 创建于： 2021/6/14 18:44
 * 1. Integer核心是 private final int value;这是存放整数值的属性，但是却是final的，这意味着一个Integer对象的值是不会改变的
 * 2. 这让我想起了String存放数据的char[]也是final的，String可以由引号包起的字面量来赋值，为了节省空间，引入常量池；
 *    相比之下，Integer可以由int值自动装箱成Integer对象,如果每个int值都对应一个独立的对象，未免太奢侈了，于是Integer也用起了常量池；
 *    Integer的常量池是IntegerCache类，这是Integer的静态成员类，IntegerCache有一个cache[]数组存放了[-128,127]共256个Integer对象；
 *    一旦由int装箱成Integer,确切地说，是调用Integer.valueOf(int i)方法，检测值是否在[-128,127]之内，若在，就返回相同的对象；
 *    注意：用关键字 new 得到的Integer对象，都是相互独立的对象
 * 3.
 */
@SuppressWarnings({"all"})
public class IntegerLearn{
	public static void main(String[] args){
		//Field
		System.out.println(Integer.MAX_VALUE);//2^31 - 1
		System.out.println(Integer.MIN_VALUE);//- 2^31
		System.out.println(Integer.SIZE);//32个比特位
		System.out.println(Integer.BYTES);//通过 SIZE / Byte.SIZE 得到存储空间上有几个Byte
		System.out.println(int.class == Integer.TYPE);//两种方式获得基本类型的Class对象

		//当Integer + int时，是怎么进行的
		int i = 3;
		Integer integer = new Integer(3);
		System.out.println(integer);
		integer = integer + i;//此处integer的地址会发生改变，也就是说，之前的3和之后的6是两个不同的Integer
		System.out.println(integer);

	}
}
