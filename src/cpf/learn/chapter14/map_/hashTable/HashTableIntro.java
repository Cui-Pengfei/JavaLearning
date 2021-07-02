package cpf.learn.chapter14.map_.hashTable;

import java.util.Hashtable;

/**
 * @author CPF 创建于： 2021/6/27 6:09
 * Hashtable的基本介绍：
 * 1. 存放的元素是键值对 Hashtable$Entry<?,?>[] table
 * 2. key-value均不允许为空，否则会抛出空指针异常
 * 3. Hashtable的使用基本与HashMap一致
 * 4. Hashtable是线程安全的，HashMap不是线程安全的
 * 5. 相同的key，不同的value也是会替换
 * 6. table[]默认初始大小是11,loadFactor=0.75
 * 6. 扩容机制是 (capacity << 1) + 1，也就是 2倍 + 1
 * 7. 从JDK1.0开始就有Hashtable了，HashMap是JDK1.2才有的，HashMap效率更高
 * 8.
 */
@SuppressWarnings({"all"})
public class HashTableIntro{
	public static void main(String[] args){
		Hashtable hashtable = new Hashtable();
		//hashtable.put(null, "hi");//由于会有 key.hashCode()操作，不用认为判断key是否为空，他为空时自然会抛出异常
		//hashtable.put(1, null);//都不允许为空

	}//end main
}
