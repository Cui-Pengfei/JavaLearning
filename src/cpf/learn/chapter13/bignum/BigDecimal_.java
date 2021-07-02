package cpf.learn.chapter13.bignum;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author CPF 创建于： 2021/6/19 22:22
 */
public class BigDecimal_{
	public static void main(String[] args){
		BigDecimal bigDecimal = new BigDecimal("1.9999999999999999999999999");

		//1.加
		bigDecimal = bigDecimal.add(new BigDecimal("0.00000000000000000000000002"));
		System.out.println(bigDecimal);

		//2.减
		bigDecimal = bigDecimal.subtract(new BigDecimal("0.00000000000000000000000002"));
		System.out.println(bigDecimal);

		//3.乘法
		bigDecimal = bigDecimal.multiply(new BigDecimal("1.11111"));
		System.out.println(bigDecimal);

		//4.除法
		bigDecimal = bigDecimal.divide(new BigDecimal("1.11111"));//除不尽会报数学错误
		System.out.println(bigDecimal);

		//System.out.println(bigDecimal.divide(new BigDecimal("3")));//会报错
		//保留精度，就能解决
		bigDecimal = bigDecimal.divide(new BigDecimal("3"), BigDecimal.ROUND_CEILING);
		System.out.println(bigDecimal);
	}//end main
}
