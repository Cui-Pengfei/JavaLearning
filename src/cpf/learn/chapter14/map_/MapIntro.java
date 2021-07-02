package cpf.learn.chapter14.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CPF 创建于： 2021/6/25 10:56
 * 1. Map与Collection并列，用于保存具有映射关系的数据： key - value
 * 2. Map中的 key - value 可以是任何数据类型，会被封装到HashMap$Node内部类中
 * 3，Map的key不允许重复，原因与HashSet一样，相同的key会放弃插入
 * 4. HashSet其实是HashMap中value置为常量的特例
 * 5. key - value是以一对应的关系，通过key总能找到唯一的value与之对应
 * 6. 常用String类作为Map的key
 * 7.
 *
 *
 */
public class MapIntro{
	public static void main(String[] args){
		Map map = new HashMap();
		map.put(null, "jack");
		map.put("null", "mary");//注意null也是一种数据类型，可以作为Object传入参数
		System.out.println("map = " + map);
	}
}
