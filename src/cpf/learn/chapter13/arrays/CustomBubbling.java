package cpf.learn.chapter13.arrays;

import cpf.learn.myTool.Array;

import java.util.Arrays;
/**
 * @author CPF 创建于： 2021/6/18 17:00
 * 我们使用接口编程，来定制一个冒泡排序：
 */
public class CustomBubbling{
	public static void main(String[] args){
		int arrays[] = Array.randomArray(10,100);
		System.out.println(Arrays.toString(arrays));
		ThisArrays.bubbling(arrays, new Sequence(){
			@Override
			public int compare(int i, int j){
				return j - i;//通过接口编程，实现定制排序
			}
		});
		System.out.println(Arrays.toString(arrays));
	}//main
}

interface Sequence{
	int compare(int i, int j);
}

class ThisArrays{
	public static void bubbling(int[] arrays, Sequence s){
		int temp = 0;
		boolean isOrdered = true;//冒泡排序的优化
		for(int i = 0; i < arrays.length - 1; i++){
			for(int j = 0; j < arrays.length - i - 1; j++){
				if(s.compare(arrays[j], arrays[j + 1]) > 0){//就交换
					isOrdered = false;
					temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
				}
			}
			if(isOrdered) break;
		}
	}
}
