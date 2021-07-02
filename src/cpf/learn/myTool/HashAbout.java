package cpf.learn.myTool;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author CPF 创建于： 2021/6/23 18:54
 */
public class HashAbout{
	/**
	 * 可以得到某个元素即将插入hashSet中的下标.
	 * @param hashSet 本次的hashSet.
	 * @param obj 要插入的元素
	 * @return 返回元素要插入的下标.
	 * @throws NoSuchFieldException 因为要找到map, 还要找到table 属性
	 * @throws IllegalAccessException 因为要得到具体的table 变量
	 */
	public static int hashSetTableIndex(HashSet hashSet, Object obj)
			throws NoSuchFieldException, IllegalAccessException{

		//首先我要得到hashMap的table,但此时我这里只有一个hashSet对象
		//所以，我要先得到hashSet的map对象
		Field map = hashSet.getClass().getDeclaredField("map");
		map.setAccessible(true);
		HashMap thisMap = (HashMap) map.get(hashSet);
		//通过thisMap还要得到table
		Field table = thisMap.getClass().getDeclaredField("table");
		table.setAccessible(true);
		Object tab[] = (Object[]) table.get(thisMap);

		int hashCode = obj.hashCode();
		int h;
		int hash = (h = obj.hashCode()) ^ (h >>> 16);
		int n = (hashSet.size() == 0) ? 16 : tab.length;//如果是个空表，会先扩容为16
		int index = (n - 1) & hash;
		return index;
	}
}
