package cpf.learn.chapter14.map_;

/**
 * @author CPF 创建于： 2021/6/25 21:18
 * 解读Map接口的源码：
 * 1. 接口定义 public interface Map<K,V> 定下了键值对的基调，凡是继承自Map的类都是一一对应的双值
 * 2. Map接口内部有一个Entry接口，此处应该翻译为【条目】，其中定义了对地图中各个节点的基本操作，
 *    是对各实现类内部节点类的抽象，这是模板设计模式，对于代码复用、开闭原则都有很大的好处，可以面向接口编程
 * 提示：其中定义的各个基础方法，在MapNethod内讲解
 *
 */
public class MapSource{
	public static void main(String[] args){


	}//end main
}
