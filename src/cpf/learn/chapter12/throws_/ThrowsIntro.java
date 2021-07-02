package cpf.learn.chapter12.throws_;

/**
 * @author CPF 创建于： 2021/6/14 3:44
 * 1.如果一个方法中可能存在异常，但是【并不确定】如何处理这些异常，
 * （不确定可能由于调用者的某些输入导致的异常）
 * 则该方法应该throws显式地声明抛出异常,表明该方法不对这些异常进行处理，
 * 由该方法调用者负责处理(其实默认的是throws Exception，因此不必显示地写出也一样)
 * 2.在方法声明中，用关键字throws可以声明抛出异常列表，用逗号隔开，
 * throws后面的异常类型可以是方法中可能产生的异常类型，或者这类型的父类
 */
public class ThrowsIntro{
	public static void main(String[] args){
		caller();
	}//end main

	public static void caller(){
		try{
			exceptionList();
		}catch(NullPointerException e){
			System.out.println(e);
		}catch(ArithmeticException e){
			System.out.println(e);
		}
	}

	public static void exceptionList(){
		String name = null;
		System.out.println(name.length());

		int i = 1 / 0;
	}
}//end class
