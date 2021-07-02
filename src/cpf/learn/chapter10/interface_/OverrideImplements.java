package cpf.learn.chapter10.interface_;

import com.sun.org.apache.bcel.internal.generic.FADD;

/**
 * @author CPF 创建于： 2021/6/16 0:24
 * 比较一下继承的重写、接口实现的异同点：
 * 1. 继承的重写，和接口的实现，都是相同的注解 @Override,因此规则必定相同
	 * 1.1 访问权限可扩大，不可缩小
	 * 1.2 返回类型可相同、可以是子类
	 * 1.3 参数列表必须相同（注意区分：类多态的那种动态绑定机制的参数列表）
 * 2. 之所以表现出不同，是因为接口本身是一个特殊的类，有诸多特点：
	 * 2.1 接口的方法都是默认public的，因此实现接口的方法也必定都是public
 *
 */
public class OverrideImplements{
	public static void main(String[] args){

	}//end main
}

class Father{
	protected Father call(Father father){
		return father;
	}
}

class Son extends Father{
	/*
	继承的方法重写有两处可变动：
	1.访问权限可不变、可扩大
	2.返回类型可以相同、可以是子类
	 */
	@Override
	public Son call(Father father){
		return new Son();
	}
}

interface Warmable{//可取暖的
	Father fire(Father father);
}

class fireplace implements Warmable{

	@Override
	public Son fire(Father father){
		return null;
	}
}
