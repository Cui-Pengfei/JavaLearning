package cpf.learn.chapter14.collection_.list_.linkedlist_;

/**
 * @author CPF 创建于： 2021/6/23 1:29
 */
public class TestDoubleLinked{
	public static void main(String[] args){
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add("cpf");
		doubleLinkedList.add('男');
		doubleLinkedList.add(25);
		System.out.println(doubleLinkedList.size());
		System.out.println(doubleLinkedList);
	}
}
