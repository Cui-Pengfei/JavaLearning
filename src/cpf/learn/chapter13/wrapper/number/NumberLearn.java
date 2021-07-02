package cpf.learn.chapter13.wrapper.number;

import java.math.BigDecimal;

/**
 * @author CPF 创建于： 2021/6/14 18:31
 * 1.Number类是基本数据类型
 *   Byte、Short、Integer、Long、Float、Double、BigDecimal、BigInteger
 *   的共同父类
 * 2.只有Character、Boolean的直接父类是Object
 * 3.Number是一个抽象类，实现了Serializable接口
 * 4.Number有四个抽象方法：intValue() longValue() floatValue() doubleVValue()
 *   两个非抽象方法：byteValue() shortValue()
 *   其实Byte、Short、Integer、Long、Float、Double都重写了这两个非抽象方法，
 *   主要是BigDecimal、BigInteger没有实现这两个非抽象方法，因此设计者将它们设计为非抽象。
 * 5.未完待续...
 */
public class NumberLearn{
	public static void main(String[] args){
		Integer integer = new Integer(32767 + 1);
		showMethod(integer);
		showTurn(integer);

	}

	public static void showMethod(Number number){
		System.out.println(number.floatValue());
	}

	public static void showTurn(Number number){
		System.out.println(number.shortValue());
	}
}
