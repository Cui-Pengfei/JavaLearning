//package语句必须是第一条语句
package cpf.learn.oop.pkg;
//一个类中最多只能有一条package语句

//import指令放在package指令之下，在类定义之前，可以有多句，且没有顺序要求

import cpf.learn.myTool.Array;

import java.util.Arrays;

public class PkgDetail {
	public static void main(String[] args) {
		//数组排序并输出
		int[] array = new int[]{1, 5, 6, 9, 3, 5, 4};
		Arrays.sort(array);
		Array.printArray(array);

	}//end main
}//end class
