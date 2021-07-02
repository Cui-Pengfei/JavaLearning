package cpf.learn.chapter10.interface_;

/**
 * 继续接口的细节说明：
 *      1. 一个类可以实现多个接口，接口名之间用逗号隔开（多重继承）
 *      2. 接口的属性默认都是public static final修饰的，并且一定要在定义时就初始化
 *          （这一点很好理解，因为接口中没有别的地方可以初始化这种类型的属性了）
 *      3. 接口不能继承其他类，但是可以继承多个接口，接口之间使用关键字extends来继承
 *      4. 接口的修饰符只能是public和default(省略不写)，这与类一样
 *      5. 实现接口，很大程度上是对java单继承机制的一种补充。
 *          可以这么理解：继承的是天赋，实现的接口是学习。
 *          小石头天生至尊，这是继承，在先天生灵身上学习宝术，这是实现。
 *          只能有一个爸爸，但是可以有很多老师。
 *      6. 继承和接口解决的问题不同
 *          继承：解决代码的复用性、可维护性
 *          接口：设计，设计好各种规范，让其他类去实现这些方法
 *      7. 接口比继承更加灵活
 *          继承，要满足 is -a 的关系        cat is a animal
 *          接口，满足 like -a 的关系即可     monkey like a man to walk
 *      8. 接口在一定程度上，实现代码的解耦【接口规范性+动态绑定机制】
 *
 */
public class InterfaceDetail02{
	public static void main(String[] args){

	}//end main
}//end class

interface IA{
	public static final int a = 10;//可以看到三个关键字都是灰色，表明都可以省略

}
interface IB{}

interface IC extends IA, IB{

}

//1. 同时实现多个接口
class Pig implements IA, IB{

}
