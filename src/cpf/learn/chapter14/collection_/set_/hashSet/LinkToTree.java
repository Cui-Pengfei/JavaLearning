package cpf.learn.chapter14.collection_.set_.hashSet;

import java.util.HashSet;

/**
 * @author CPF 创建于： 2021/6/23 21:26
 * 当 HashSet 某个链表上元素超过8时，table又没有64会怎么样？
 * 1. 到达8个时候，仍然不会有什么异常，仍然是添加到链条后端，此时链条长度最大是8
 * 2. 在一次添加的时候，由于超过了8，就去检查table是否是64，不是的话，就扩容一倍变32，此时链条长度9
 * 3. 再添加时，还是查看是否是64，不是，扩容一倍变64，此时链条长度变10
 * 4. 再添加时，查看发现已经是最大64了，就把链条转红黑树，因此链条最长是10个元素
 * 5. 扩容机制一直考量的就是size,他不管table表头上是不是被占满，他只考虑两种情况：
 * 5.1 if (++size > threshold) 加入超过边界值的元素，就要扩容
 *             resize();
 * 5.2 if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
 *             resize(); 当一个链条超过8个元素时，却发现table的长度小于64，则先扩容，暂时不红黑树化
 */
public class LinkToTree{
	public static void main(String[] args){
		HashSet hashSet = new HashSet();
		for(int i = 0; i < 100; i++){
			hashSet.add(new Num(i));
		}
		System.out.println(hashSet.size());
		System.out.println(hashSet);
	}
}

class Num{
	private int i;

	public Num(int i){
		this.i = i;
	}

	@Override
	public int hashCode(){
		return 100;
	}

	@Override
	public String toString(){
		return i + "";
	}
}
