package cpf.learn.myTool;

import java.util.Arrays;

/**
 * @author CPF 创建于： 2021/6/20 11:15
 * 自己写的关于字符串的方法
 */
public class MyString{
	public static void main(String[] args){
		String str = "我不知道你是谁";
		String newStr = reverse(str, 2, 5);
		System.out.println(newStr);
	}

	/**
	 * 翻转字符串中指定下标之间的字符.
	 * 重要的思想在于循环中的offset偏移量，我没有使用在start和end各安置一个下标指针，
	 * 而是使用了首尾交换后都要移动的偏移量，这个偏移量是相同的.
	 * @param str 要翻转的字符串
	 * @param start 要翻转区域前端
	 * @param end 要翻转区域的后端
	 * @return 返回翻转后的字符串
	 * @throws NullPointerException 如果要翻转的字符串本身为空，就会出现空指针异常.
	 * @throws IndexOutOfBoundsException 如果参数列表的下标越界，会报越界异常.
	 */
	public static String reverse(String str, int start, int end){
		if(str == null){
			throw new NullPointerException();
		}
		int len = str.length();
		if(start < 0 || end > len || start > end){
			throw new IndexOutOfBoundsException();
		}
		char temp;
		char dst[] = str.toCharArray();//转化为字符数组
		for(int offset = 0; offset <= (end - start) / 2; offset++){//要反转的部分前后交换，只用交换一半即可
			temp = dst[start + offset];
			dst[start + offset] = dst[end - offset];
			dst[end - offset] = temp;
		}
		return Arrays.toString(dst);
	}//end method
}
