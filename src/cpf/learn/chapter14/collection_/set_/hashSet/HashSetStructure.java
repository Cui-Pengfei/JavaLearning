package cpf.learn.chapter14.collection_.set_.hashSet;

import java.util.Arrays;

/**
 * @author CPF 创建于： 2021/6/23 16:41
 */
public class HashSetStructure{
	public static void main(String[] args){
		//模拟一个Hashset的底层结构（也就是HashMap的底层结构）
		Node[] table = new Node[3];
		table[0] = new Node("动物", null);
		table[1] = new Node("植物", null);
		table[2] = new Node("怪物", null);
		System.out.println(Arrays.toString(table));

		table[0].setNext(new Node("老虎", new Node("狮子", null)));
		table[1].setNext(new Node("玫瑰", new Node("杨树", null)));
		table[2].setNext(new Node("哥斯拉", new Node("金古桥", null)));
		System.out.println(Arrays.toString(table));

	}//end main
}

class Node{
	private Object value;
	private Node next;

	public Node(Object value, Node next){
		this.next = next;
		this.value = value;
	}

	public Node next(){
		return next;
	}

	public boolean hasNext(){
		if(next != null)
			return true;
		else
			return false;
	}

	private Object value(){
		return value;
	}

	public void setNext(Node next){
		this.next = next;
	}

	public void setValue(Object value){
		this.value = value;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node point = this;
		while(point != null){
			sb.append(point.value);
			if(point.hasNext())
				sb.append("->");
			point = point.next;
		}
		sb.append("}");

		return sb.toString();
	}
}
