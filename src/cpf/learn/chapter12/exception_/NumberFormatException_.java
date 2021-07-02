package cpf.learn.chapter12.exception_;

import java.util.Scanner;

/**
 * @author CPF 创建于： 2021/6/13 15:15
 * 利用数字格式转化错误，可以保证输入的是正确的数字
 */
public class NumberFormatException_{
	public static void main(String[] args){
		String n = "1234";
		int num = Integer.parseInt(n);
		System.out.println(num);

		String name = "cpf";
		int number = 0;
		try{
			number = Integer.parseInt(name);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		System.out.println(number);


	}//end main
}
