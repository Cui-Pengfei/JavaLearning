package cpf.learn.chapter13.stringbuffer_;

/**
 * @author CPF 创建于： 2021/6/17 20:47
 */
@SuppressWarnings({"all"})
public class Exercise{
	public static void main(String[] args){
		String string = "null";
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(string);//会直接追加进去字符数组{'n','u','l','l'}
		System.out.println(stringBuffer);

		StringBuffer stringBuffer1 = new StringBuffer(string);
		/*
		由于StringBuffer(String string)这个构造器内，会有string.length()的操作，
		string为空的话，就会报错NullPointerException
		 */
		System.out.println(stringBuffer1);
		System.out.println((int)'0');
		System.out.println((int)'9');
		System.out.println((int)'.');

	}
}
