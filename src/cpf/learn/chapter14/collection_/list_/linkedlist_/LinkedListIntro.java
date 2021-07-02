package cpf.learn.chapter14.collection_.list_.linkedlist_;
/**
 * @author CPF 创建于： 2021/6/22 16:33
 * 双向链表集合LinedList:
 * 1.它是双向链表（非循环）
 * 1.0 它是由头尾指针的双向链表，但是没有头尾节点
 * 1.1 它是链表的数据结构，没有数组来存储数据，依靠节点的前后链接来维持彼此之间的联系
 * 1.2 它有双向链表明显特征：拥有一个节点内部类Node,节点有三个字段：E item;     Node<E> next;   Node<E> prev;
 * 1.3 链表不能直接取出位于index的节点，但是LinkedList又实现了List接口，必须实现get(index)方法；
 *     在底层都是通过循环顺着链表遍历来达到序列化的效果，起始序号是0
 * 1.4
 */
public class LinkedListIntro{
	public static void main(String[] args){



	}
}
