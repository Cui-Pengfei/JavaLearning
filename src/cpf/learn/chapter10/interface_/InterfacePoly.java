package cpf.learn.chapter10.interface_;

/**
 * 接口的多态：（很多与类的多态相似，毕竟接口也算是特殊的类）
 * 多态参数：
 *      >把接口当做方法形参，那么任何实现此接口的对象实例都可以传入该方法的参数列表
 *      >接口类型的变量，可以指向实现了该接口的类的对象（比较类的向上转型）
 * 多态数组：
 *      >与类的多态数组一样
 * 接口存在多态传递现象
 *      interfaceA extends interfaceB
 *      ClassC implements interfaceA
 *      则 interfaceB ib = new ClassC();是允许的
 */
public class InterfacePoly{
	public static void main(String[] args){
		//接口多态的传递性：本质上是extends于implements的混合
		IE ie = new C();
		ID id = new C();
	}//end main
}

interface ID{}
interface IE extends ID{}
class C implements IE{}
