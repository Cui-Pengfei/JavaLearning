package cpf.learn.chapter13.arrays;

import cpf.learn.myTool.Array;

import java.util.Arrays;

/**
 * @author CPF 创建于： 2021/6/19 17:57
 * 试用一下，Arrays.copyOf(T[] original, int newLength)泛型复制:
 * 也就是把所有的引用类型数组都囊括进去了，只是我还没学过泛型，觉得高大上而已；
 */
public class CopyOfDetail{
	public static void main(String[] args){
		Integer integers[] = new Integer[10];
		for(int i = 0; i < 10; i++){
			integers[i] = i;
		}
		Integer i[] = Arrays.copyOf(integers, integers.length);
		System.out.println(Arrays.toString(i));
	}//end main
}
