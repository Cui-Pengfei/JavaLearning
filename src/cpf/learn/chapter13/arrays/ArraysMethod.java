package cpf.learn.chapter13.arrays;

import cpf.learn.myTool.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CPF 创建于： 2021/6/18 2:09
 * 类Arrays为我们准备了很多关于数组的可用的方法：
 * 1.一个私有的空构造器，意味着不可以实例化
 * 2.全部方法都是静态的
 */
public class ArraysMethod{
	public static void main(String[] args){
/*1. toString() 重载了9个方法：
		byte[] short[] char[] int[] long[] float[] double[] boolean[] Object[]
		数组是null，就返回字符串"null"
		数组不是null，但是内容为空，返回"[]"
		有内容返回[1, 2, 3]注意有空格
		*/
		System.out.println("========== 1. toString() ===========");
		byte bytes[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		String byteToString = Arrays.toString(bytes);
		System.out.println(byteToString);
		//注意区分
		System.out.println(bytes.toString());
		System.out.println(new String[]{}.toString());
		/*
		若数组直接toString(),由于数组没有重写toString方法，而数组又是Object,
		因此，我们匹配到的其实是object.toString()
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
		 */

		/*2. sort() 数组排序 ：2.1自然排序      2.2定制排序*/
		//2.1 自然排序：就是Arrays内已经写好的，不需要我们改变的,都是升序
		System.out.println("========== 2. sort() 自然排序 ===========");
		int nums[] = Array.randomArray(10, 100);//[1,100]范围的10个整数数组
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums, 3, 6);//先部分排序
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));


		/*
		2.2 定制排序：可以自己规定升序还是降序：通过匿名内部类重写接口参数来实现
			public static <T> void sort(T[] a, Comparator<? super T> c)
			public static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
		 */
		System.out.println("========== 2. sort() 定制排序 ===========");
		Integer arrayInteger[] = Array.randomArray(10,100, true);
		System.out.println(Arrays.toString(arrayInteger));//输出随机数组，看看什么情况
		Arrays.sort(arrayInteger, new Comparator<Integer>(){
			@Override
			public int compare(Integer i1, Integer i2){
				return i2 - i1;//通过改变返回值的这两个值作差的顺序，可以直接影响到是升序还是降序
			}
		});
		System.out.println(Arrays.toString(arrayInteger));


	}//en =d main
}
