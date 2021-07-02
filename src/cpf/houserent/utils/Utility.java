package cpf.houserent.utils;

import cpf.houserent.domain.House;

import java.util.Scanner;

/**
 * 工具类，提供便利方法
 */
public class Utility{
	static private Scanner scanner = new Scanner(System.in);
	static boolean lope;

	/**
	 * 获得一个范围内的整数.
	 *
	 * @param head 范围起始 [
	 * @param tail 范围结束 ]
	 * @return 返回类型设置为Integer 可以控制输入范围不正确的情况，此时返回null，由于接收变量肯定是int,
	 * 因此，返回null就会匹配错误，从而找到发现该错误.
	 */
	static public Integer getBoundInt(int head, int tail){
		if(head > tail){
			System.out.println("范围有误，第一个参数是范围头部，第二个参数是范围尾部，头部<=尾部");
			return null;
		}
		lope = true;
		int choice;
		do{
			choice = scanner.nextInt();
			if(choice >= head && choice <= tail){
				lope = false;
			}else{
				System.out.print("输入有误，请重新输入：");
			}
		}while(lope);
		return choice;
	}

	/**
	 * @param length 要获得的字符串的最大长度.
	 * @return 若这个长度限制不对，则提示信息，并返回null
	 * 若输入长度不对，则会提示一直输入直到正确为止.
	 */
	static public String getBoundStr(int length){
		if(length <= 0){
			System.out.println("长度有误！字符串长度必须是大于0的整数...");
			return null;
		}

		lope = true;
		String choice;
		do{
			choice = scanner.next();
			if(choice != null && choice.length() <= length){
				lope = false;
			}else{
				System.out.print("字符串输入长度(<=" + length + ")有误，请重新输入：");
			}
		}while(lope);

		return choice;
	}

	//我想要写成一个泛型的Object扩容，但是获得参数的运行类型成问题，不知道怎么解决
	static public House[] extendArray(House[] oldArray, House newObject){
		House[] newArray;
		if(oldArray == null){//原始数组为空
			newArray = new House[1];
			newArray[0] = newObject;
		}else{
			int oldLength = oldArray.length;//老数组的长度，单独拎出来是因为后面多次用到，代码简洁
			newArray = new House[oldLength + 1];//数组长度加一
			newArray[oldLength] = newObject;
			for(int index = 0; index < oldLength; index++){
				newArray[index] = oldArray[index];
			}
		}
		return newArray;
	}
	/*

	static public Object[] objArrayPlusOne(Object[] oldArray, Object element)
			throws IllegalAccessException, InstantiationException{

		Object[] newArray = oldArray.getClass().newInstance();//得到旧数组的运行类型
		if(oldArray == null){//原数组为空
			newArray = oldArray.getClass().到这一步走不下去了，不知道怎么创建一个具体大小的数组
		}
	}
	*/

	static public char confirm(){
		lope = true;
		char choice;
		do{
			choice = scanner.next().charAt(0);
			if(choice == 'y' || choice == 'n' || choice == 'Y' || choice == 'N'){
				lope = false;
			}else{
				System.out.print("确认错误！您只能输入y/n，请重新输入：");
			}
		}while(lope);
		return choice;
	}
}
