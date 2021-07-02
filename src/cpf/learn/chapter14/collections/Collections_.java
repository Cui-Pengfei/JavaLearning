package cpf.learn.chapter14.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author CPF 创建于： 2021/6/29 3:42
 * 1. Collections是一个重量级工具类，不允许实例化，其工具方法都是静态的
 * 2. Collections是一个操作Set、List、Map等集合的工具类
 * 3. Collections提供了一系列静态方法，实现对集合元素的的排序、查找、修改
 */
@SuppressWarnings({"all"})
public class Collections_{
	public static void main(String[] args){

		/*第一组： 操作List的部分功能 */
		ArrayList arrayList = new ArrayList();
		arrayList.add("jack");
		arrayList.add("tom");
		arrayList.add("smith");
		arrayList.add("abama.black");

		//排序
		Collections.sort(arrayList);//默认排序自然是按String.compareTo方法来排序
		System.out.println(arrayList);

		Collections.sort(arrayList, new Comparator(){//按照字符串长度来排序
			@Override
			public int compare(Object o1, Object o2){
				return ((String) o1).length() - ((String) o2).length();//1 - 2就是比较值小的排在前面
			}
		});
		System.out.println(arrayList);

		//反转
		Collections.reverse(arrayList);
		System.out.println(arrayList);

		//随机排序
		Collections.shuffle(arrayList);
		System.out.println(arrayList);

		//交换
		Collections.swap(arrayList, 0, 3);
		System.out.println(arrayList);

		/*第二组： 操作Collection的常用方法 */
		System.out.println("=========== 2. 操作Collection的常用方法 ============");
		//最大值
		Object natureMax = Collections.max(arrayList);//自然排序的最大值
		System.out.println("自然排序最大的是：" + natureMax);

		Object lengthMax = Collections.max(arrayList, new Comparator(){//还是按照字符串长度排序来吧
			@Override
			public int compare(Object o1, Object o2){
				return ((String) o1).length() - ((String) o2).length();
			}
		});
		System.out.println("长度最长的是：" + lengthMax);

		//最小值 min 与max同理

		//统计集合中某元素出现的频率
		arrayList.add("jack");
		int frequency = Collections.frequency(arrayList, "jack");
		System.out.println("jack出现的次数：" + frequency);

		//集合元素拷贝
		ArrayList dest = new ArrayList();
		for(int i = 0; i < arrayList.size(); i++){
			dest.add(".");
		}
		Collections.copy(dest, arrayList);//必须要保证两者的size一样
		System.out.println(dest);

	}//end main
}
