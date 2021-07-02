package cpf.learn.chapter14.collection_.list_.vector_;

import java.util.Vector;
/**
 * @author CPF 创建于： 2021/6/22 9:40
 * List接口的实现类之一 : Vector
 * 0. Vector自从JDK1.0就存在，ArrayList是JDK1.2才引入，因此设计者肯定是认为ArrayList的一些设计更棒（无关线程的一些设计）
 * 1. Vector与ArrayList大同小异，最大的区别就是Vector是线程安全的，大量方法都有synchronized关键字修饰
 * 2. Vector的构造函数比ArrayList多一个，Vector(int initCapacity, int capacityIncrement),即可以设置capacity的扩容增量
 * 3. Vector的扩容与ArrayList在流程上基本一致，但是Vector扩容时会考虑是否有自定义的扩容增量capacityIncrement,如果有，就按照增量来，
 *    如果没有，就扩容一倍，而不是ArrayList的扩容0.5倍
 * 4. Vector的构造器在设计理念上与ArrayList有些不同：
	 * 4.1 Vector的三个主要的构造器按复杂程度低中高三级，低级调用中级、中级调用高级，它将代码的复用性当做核心理念，
	 *     构造器相互调用，代码是整洁了，但是相互调用无异降低了效率；而且在集合构建时，就分配了空间；
	 * 4.2 ArrayList的构造器各个独立，由于程序员在调用不同构造器时会体现出不同的调用意图，为了体现出这种意图，
	 *     ArrayList利用两个类常量空数组，虽然都是空数组，但是名称不同代表意图不同，扩容机制也跟着不同；
	 *     这种机制使得不同的扩容策略得以延迟到add元素阶段再实行，这样集合在构造时，仅仅具有特性，而不分配空间，非常节省，
	 *     是更高级的编程技巧：该做的事在该做的阶段完成，不多不少
 *
 *
 */
@SuppressWarnings({"all"})
public class VectorIntro{
	public static void main(String[] args){
		Vector vector = new Vector();
		Vector vectorZ = new Vector(0);
		vector.add("abc");

		//独特的是，vector可以查询数据存储数组的当前容量
		System.out.println(vector.capacity());


	}
}
