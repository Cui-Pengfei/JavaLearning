package cpf.learn.chapter14.map_.hashMap;

import java.util.HashMap;

/**
 * @author CPF 创建于： 2021/6/26 7:35
 * 1. HashMap有哪些域？
 * 1.1 table:Node[]存储节点数据
 * 1.2 size:int 键值对数据的数量
 * 1.3 loadFactor负载因子，默认值是0.75f，当table表达到负载临界点就会扩容，而不是等到全部用完再扩容
 * 1.4 threshoid临界值 = capacity * loadFactor
 * 1.5 每次扩容就是增加现容量的一倍，直到数组大小到64，链表上元素数量达到8个的都要红黑树化，
 *      table表最大容量是 int MAXIMUM_CAPACITY = 1 << 30
 * 1.6 modCount指hashMap被修改的次数，修改包括（增、删、rehash），修改节点、put一个相同key值的键值对都不改变modCount
 *     此值可用于限制不希望修改的地方实现快速抛出异常，主要是forEach() 和 iterator()位置的查询
 * 1.7
 */
@SuppressWarnings({"all"})
public class HashMapIntro{
	public static void main(String[] args){
		HashMap hashMap = new HashMap();
		hashMap.put(1, "北京");
		hashMap.put(2, "上海");
		hashMap.put(3, "广州");
		hashMap.put(4, "深圳");
		System.out.println("hashMap = " +hashMap);

		hashMap.put(1, "北京北京");
		System.out.println(hashMap);//对于相同的key，实行value的替换
	}//end main
}
