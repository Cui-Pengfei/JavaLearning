package cpf.learn.chapter14.collection_.set_.hashSet;

/**
 * @author CPF 创建于： 2021/6/23 17:55
 * 解析HashSet的源码：
 * 1. HashSet底层即使HashMap 表头数组 + 链表
 * 2. 添加一个元素时，先得到hash值，再转成索引值，具体依据什么转hash值，这要靠是否重写了hashCode()方法
 * 3. 找到数据表头table,查看索引值x位置是否有元素，如果没有，直接添加进去
 * 4. 如果有元素，就调用equals比较整条链表的元素，相同就放弃添加，返回false添加失败，不相同就顺着链表排到后面
 * 5. java8中，如果一条链表的元素个数到达TREEIFY_THRESHOLD = 8
 *      并且table的大小到达MIN_TREEIFY_CAPACITY = 64，这条链表就会红黑树化
 * 6. 要得到table的索引，第一得到元素的 hashCode()值；接着得到 hash = (h = key.hashCode()) ^ (h >>> 16)
 *      然后索引是 tab[i = (n - 1) & hash])
 */
public class HashSetSource{
	public static void main(String[] args){

	}//end main
}
