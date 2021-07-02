package cpf.learn.oop.pkg;

//默认引入的包
//建议需要什么类就引入什么类，不建议用.*来引用
// import  java.lang.*;
// import java.lang.Math;//这个就不用导入就可以用，默认是导入的


import cpf.learn.myTool.Array;

import java.util.Arrays;

public class DefaultImport {
	public static void main(String[] args) {
		//默认的导入包使得这条程序合法
		double ran = Math.random();

		//	使用系统提供的 Arrays 完成数组排序
		int[] array = {1, 2, 7, 4, 5, 9, 12, 66, 31};
		System.out.print("排序前：");
		Array.printArray(array);
		Arrays.sort(array);//ctrl + t 可查看Arrays提供的多种排序方法
		System.out.print("排序后：");
		Array.printArray(array);




	}//end main

}//end class
