package cpf.learn.chapter13.bignum;

import java.math.BigInteger;

/**
 * @author CPF 创建于： 2021/6/19 20:38
 * 1. BigInteger是在long都不够用的情况下，被开发出来，用于大整数的处理；
 * 2. BigInteger的加减乘除必须调用相应的方法，不能使用运算符号
 */
public class BigInteger_{
	public static void main(String[] args){
		long l = Long.MAX_VALUE;//9223372036854775807L(19位)

/*1. BigInteger实例化，重载了6中构造器
		BigInteger(byte[] val)
		BigInteger(int signum, byte[] magnitude)  signum = -1表示是负数 1表示正数 0表示0
		BigInteger(String val)
		BigInteger(String val, int radix)
		BigInteger(int numBits, Random rnd)
		BigInteger(int bitLength, int certainty, Random rnd)
		*/
		BigInteger bigInteger1 = new BigInteger(new byte[]{1, 1});

		BigInteger bigInteger2 = new BigInteger(-1, new byte[]{1, 1});
		//BigInteger bigInteger3 = new BigInteger(0, new byte[]{1, 1});
		BigInteger bigInteger4 = new BigInteger(1, new byte[]{1, 1});

		BigInteger bigInteger5 = new BigInteger("11");
		BigInteger bigInteger6 = new BigInteger("11", 7);
		//System.out.println(bigInteger6);

		//2.加 add(BigInteger)对外只提供了这一种加的方法，包私有的方法有多个
		BigInteger bigInteger = new BigInteger("9999999999999999999999999");//25位
		bigInteger = bigInteger.add(new BigInteger("1"));
		System.out.println("加1后：" + bigInteger);

		//3.减 subtract(BigInteger)
		bigInteger = bigInteger.subtract(new BigInteger("1"));
		System.out.println("减1后：" + bigInteger);

		//4.乘法 multiply()
		bigInteger = bigInteger.multiply(new BigInteger("10"));
		System.out.println("乘以10之后：" + bigInteger);

		//5.除法 divide()
		bigInteger = bigInteger.divide(new BigInteger("10"));
		System.out.println("除以10之后：" + bigInteger);

		//6.more...

	}//end main
}


