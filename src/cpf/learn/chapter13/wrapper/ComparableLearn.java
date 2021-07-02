package cpf.learn.chapter13.wrapper;

/**
 * @author CPF 创建于： 2021/6/14 18:29
 * 1. Comparable是一个接口，用来标识一种类型的对象是否有比较的规则，
 *    这是因为，此接口有一个comparaTo()方法必须被实现，
 * 2. 此方法的参数必须是实现该接口的类型，换句话说，只能是与本类型的对象比较，
 *    compareTo()是自己跟自己比
 * 3. 要实现的抽象方法compareTo(T)，返回类型一定是int，一般是具有int域的类会实现此接口，
 *    实现的此方法多返回【本对象.value - 参数传过来要比较对象.value】，有正有负有0
 *
 */
public class ComparableLearn{
	public static void main(String[] args){
	}
}

class  Money implements Comparable<Money>{
	public final int VALUE;

	Money(int value){
		VALUE = value;
	}

	@Override
	public int compareTo(Money money){
		return this.VALUE - money.VALUE;
	}
}
