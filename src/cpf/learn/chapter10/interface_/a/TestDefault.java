package cpf.learn.chapter10.interface_.a;

/**
 * @author CPF 创建于： 2021/6/12 11:04
 * 1.看看接口中的default方法是否会被实现接口的类继承并访问到，答案是会继承并访问到，
 * 因为default表示的不是访问权限，而是一种标识符，表示这个接口方法已经实现了，不需要强制再被实现
 *
 * 2.接口中的static方法非常特殊，它的修饰是public static，但是实现此接口的类并不会继承静态方法，
 * 也是实现接口与继承类存在的根本区别之一，
 */
public interface TestDefault{

	default void say(){
		System.out.println("hello");
	}

	static void hi(){
		System.out.println("hi");
	}
}
