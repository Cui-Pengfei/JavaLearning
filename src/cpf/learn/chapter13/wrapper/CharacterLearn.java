package cpf.learn.chapter13.wrapper;

/**
 * @author CPF 创建于： 2021/6/14 18:24
 * char的包装类Character学习：
 * 1.直接继承自Object
 * 2.实现了Comparable、Serializable接口
 */
public class CharacterLearn{
	public static void main(String[] args){
		//Character的field很多，举几个常用的
		System.out.println(Character.MAX_RADIX);
		System.out.println(Character.MIN_RADIX);
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);

		//举例几个可能用到的
		System.out.println(Character.isDigit('1'));//字符是否是数字
		System.out.println(Character.isDigit(57));//unicode码是否是数字
		System.out.println(Character.isLetter('a'));
	}//end main
}
