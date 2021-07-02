package cpf.learn.chapter14.collection_.list_.linkedlist_;

import java.util.Iterator;

/**
 * @author CPF 创建于： 2021/6/22 21:15
 * 来模拟一个双向链表:
 */
public class DoubleLinkedList<E> implements Iterable{
	Node<E> head;//头指针
	Node<E> tail;//尾指针
	int size;//链表元素个数

	@Override
	public Iterator iterator(){
		return null;
	}

	private class Itr implements Iterator<E>{
		Node<E> point = head;
		Node<E> lastPoint = tail;
		public Itr(){
		}
		@Override
		public boolean hasNext(){
			if(point.next == null)
				return false;
			else
				return true;
		}

		@Override
		public E next(){
			E e = point.item;
			point = point.next;
			return e;
		}
	}//end Itr

	@Override
	public String toString(){
		Itr itr = new Itr();
		if(!itr.hasNext()){
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(true){
			sb.append(itr.next());
			if(!itr.hasNext()){
				return sb.append(", " + itr.lastPoint.item).append("]").toString();
			}
			sb.append(",").append(" ");
		}
	}

	/**
	 * 内部节点类，双向链表专属
	 * @param <E> 由于链表可以装入任何数据，E代表那个元素的数据类型
	 */
	private class Node<E>{
		E item;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev, E item, Node<E> next){
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}//end Node

	public DoubleLinkedList(){
	}
	public boolean add(E e){
		linkLast(e);
		return true;
	}

	void linkLast(E e){
		final Node<E> l = tail;
		final Node<E> newNode = new Node<E>(l, e, null);
		tail = newNode;
		if(l == null){//说明是空表
			head = newNode;
		}else{
			l.next = newNode;
		}
		size++;
	}

	public int size(){
		return size;
	}
}
