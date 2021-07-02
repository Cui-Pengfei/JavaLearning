package cpf.learn.oop.modifier.content;

/**
 * 访问修饰符总结：
 *   一、对于类的修饰
 *      >> 只能是public default
 *      1.public修饰的类，在项目的任何地方都可以访问到，
 *        default修饰的类，只有在同一个包下可访问到
 *      2.理解：public类要肩负起沟通外界的任务
 *             default类只是为了完成本包任务才被构建出来的，仅内部可见
 *
 *    二、对于属性(方法)的修饰【跨类，类内部均可访问，无需讨论】
 *      >> public protected default private均可
 *      1.public修饰的属性，在任何地方都可访问
 *      2.private是最严格的限制，仅限于类内部可直接访问，对外部一律禁止直接访问
 *      3.同包，是仅次于public的访问权限，除private外，均可访问
 *      4.子类，继承了父类的所有属性方法，但是并不意味着可以直接访问，
 *         子类的访问权限还次于同包，若同包子类，则按同包的访问权限来办
 *         子类不同包，则可直接访问public protected
 *      5.private 修饰的属性，是最隐私的，虽然会被子类所继承，但是只允许类内直接访问，
 *        对外只能提供公共的方法来间接访问
 *
 */
public class Test {
	// 同一个包下的类
	// 注意：只有【public】和【default】可以修饰类，protected private不可以修饰类！
	// 调用 1.public  2.default 类的展示
	public static void main(String[] args) {
		//1.public
		Public p1 = new Public();

		//属性
		System.out.println(p1.s1);
		System.out.println(p1.s2);
		System.out.println(p1.s3);
		//System.out.println(p1.s4);//private属性无法访问

		//方法
		p1.m1();
		p1.m2();
		p1.m3();
		//p1.m4();//private方法无法访问


		//2.default
		Default p2 = new Default();
		System.out.println(p2.s1);
		System.out.println(p2.s2);
		System.out.println(p2.s3);
		//System.out.println(p2.s4);//private属性无法访问

		Default p3 = new Default();


		//同理 private方法也无法访问

		/**
		 * 以下不再继续展示显而易见的规律：
		 *      1.private属性、方法 只在类内可以访问到
		 *      2.同一个包下，可以访问到public protected default属性和方法
		 *      3.修饰类的只有public和default
		 */
	}

}
