package cpf.learn.chapter13.arrays;

import cpf.learn.myTool.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author CPF 创建于： 2021/6/19 4:35
 * 看看Arrays的其他方法：
 */
public class OtherMethods{
	public static void main(String[] args){
		Integer nums[] = Array.randomArray(10, 10, true);
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums, new Comparator<Integer>(){
			@Override
			public int compare(Integer i1, Integer i2){
				return i2 - i1;//也不知道是个什么序列
			}
		});
		System.out.println(Arrays.toString(nums));

/*1. 二分查找 Arrays.binarySearch():
		如果数组中不存在该元素，那么会返回此元素在该数组中应该所处的位置的相反数，
		返回负数是为了表示没找到，返回位置，是为了告诉我，应该在那个位置！(但是这个位置是从1开始数的)
		*/
		System.out.println("================ 1.二分查找 ================");
		int target = 3;
		//int targetIndex = Arrays.binarySearch(nums, target);//默认的二分查找只能查找升序的有序数组
		int targetIndex = Arrays.binarySearch(nums, target, new Comparator<Integer>(){
			@Override
			public int compare(Integer i1, Integer i2){
				return i2 - i1;//查找与排序的比较器保持一致才能实现正确查找（此处都是降序）
			}
		});
		if(targetIndex < 0){//小于0说明数组中没有目标值，就把目标值插入数组
			int insertIndex = (-targetIndex) - 1;
			System.out.println("原数组中没有" + target + "，现在在适当位置：" + insertIndex + " 插入它！");
			Integer newNums[] = new Integer[nums.length + 1];
			for(int oldIndex = 0, newIndex = 0; oldIndex < nums.length; oldIndex++, newIndex++){
				if(oldIndex == insertIndex){
					newNums[newIndex] = target;
					newIndex++;
				}
				newNums[newIndex] = nums[oldIndex];
			}
			nums = newNums;
			System.out.println("插入后的有序数组如下：");
			System.out.println(Arrays.toString(nums));
		}else{//插入完毕
			System.out.println(target + "的位置是：" + targetIndex);

		}

/*2. 复制数组 ： 返回的是一个新的数组
		copyOf(T[], i)重载了10个函数，就是把 T[] 中前i个元素提取出来，放入新数组，返回
		copyOfRange()也重载了10个函数，与copyOf()是一一对应的。
		boolean byte short int long float double char这就8个，加上两个泛型的；
		此处只讨论普通的，泛型的另开一个 CopyOfDetail.java
		 */
		System.out.println("================ 2.copyOf() ================");
		int arrays[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int copyArr[] = Arrays.copyOf(arrays, 4);
		System.out.println(Arrays.toString(copyArr));

/*3. 数组填充 ：fill([],key) : 把key填充进数组中，并返回该数组，数组并没有改变地址*/
		System.out.println("================ 3.fill() ================");
		Arrays.fill(arrays, 99);
		System.out.println(Arrays.toString(arrays));

/*4. 把数组转成集合类型 Arrays.asList()*/
		System.out.println("================ 4.asList() ================");
		List asList = Arrays.asList(arrays);
		System.out.println(asList.size());
		System.out.println(asList.getClass().getSimpleName());


	}//end main
}
