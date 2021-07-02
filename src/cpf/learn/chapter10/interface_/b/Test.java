package cpf.learn.chapter10.interface_.b;

import cpf.learn.chapter10.interface_.a.TestDefault;

/**
 * @author CPF 创建于： 2021/6/12 11:06
 */
public class Test implements TestDefault{
	public static void main(String[] args){
		//Test.hi();不允许这样，也就是接口的静态方法没有被继承

		Test test = new Test();
		test.say();
		//test.hi();也不允许这样看来是没有被继承
	}
}
