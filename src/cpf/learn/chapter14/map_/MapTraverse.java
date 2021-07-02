package cpf.learn.chapter14.map_;

import java.util.*;

/**
 * @author CPF 创建于： 2021/6/26 11:06
 * Map实现类的便利方式：以map为例
 */
@SuppressWarnings({"all"})
public class MapTraverse{
	public static void main(String[] args){
		Map map = new HashMap();
		
		map.put("大城市1", "北京");
		map.put("2号大城市", "上海");
		map.put("大城市第3", "广州");
		map.put("大城市4号", "深圳");

		System.out.println("map = " + map);

//HashMap提功了EntrySet、KeySet、values三个视图可供遍历
		/*
			KeySet视图：表面上就是把所有的key装入了一个Set，然后按照Set来遍历；
			实际上，这只是维持了一个key集合的视图，实际上还是在遍历table[]，底层写了自己的KeyIterator,
			迭代器实际上是HashIterator,却被封装进了EntryIterator,还实现了Iterator接口，为的就是实现这么一个视图，
			让Map可以有一个伪装成的key值集合，将来要通过Iterator来遍历某种不知道的类型时，Map也可以参与其中；
		核心：之所以能实现这样的伪装，关键就是这个next()方法，Iterator只是一个接口，它的next方法会动态绑定到实现它的类中；
			  keySet()方法实际上返回的运行类型是KeySet，因为这个KeySet实现了AbstractSet接口，也就是实现了Set接口，因此可以向上转型；
			  而KeySet类型内的iterator()方法会返回一个KeyIterator的对象，而这个KeyIyerator实现了Iterator类，也继承了HashIterator;
				HashIterator是伪装的核心，她用nextNode()方法模拟了Set的next()方法，然后再扩展三个特殊的Iteretor:
				> EntryIterator 继承了 HashIterator 直接调用HashIterator的nextNode()方法得到下一个节点
				> KeyIterator 继承了HashIterator 调用nextNode().key得到下一个节点的key值，宏观上，是把所有的key值放入一个集合中
				> ValueIterator 集成了HashIterator,调用nextNode().value得到下一个节点的value，这个集合是在遍历时才逐个组建的
			>然后由EntrySet、KeySet、Values这些类分别提供iterator()方法来创建自己的XXXIterator对象
		*/
		System.out.println("============ 1.keySet() ===========");
		Set keyset = map.keySet();
		Iterator keyiterator = keyset.iterator();
		while(keyiterator.hasNext()){
			Object next =  keyiterator.next();
			System.out.println(next);
		}

		System.out.println("========== 2.values() ==========");
		Collection values = map.values();
		for(Object value : values){
			System.out.println(value);
		}

		System.out.println("========== 3.entrySet() =========");
		Set entrySet = map.entrySet();
		for(Object node : entrySet){
			Map.Entry entry = (Map.Entry)node;
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

		Set entrySet1 = map.entrySet();
		Iterator iterator = entrySet1.iterator();
		while(iterator.hasNext()){
			Object node = iterator.next();
			Map.Entry entry = (Map.Entry)node;
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

		//若是用泛型了，或许不用转型 (或者说，泛型其实是类型转换的一种方式，一种静态的限定方式)
		Iterator<Map.Entry> iterator1 = map.entrySet().iterator();
		while(iterator1.hasNext()){
			Map.Entry entry = iterator1.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}


	}
}
