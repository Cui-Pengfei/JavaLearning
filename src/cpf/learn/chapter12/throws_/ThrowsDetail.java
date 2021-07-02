package cpf.learn.chapter12.throws_;

import java.io.FileNotFoundException;

/**
 * @author CPF 创建于： 2021/6/14 13:33
 * 细节说明：
 * 1.对于编译异常，程序必须处理，try catch 或者 throws
 * 2.对于运行异常，程序如果没有处理，默认的是throws处理，
 *   直到抛给顶级的jvm,然后输出异常、中断程序
 * 3.子类重写父类方法时，对抛出异常有规定：
 *   子类可以不显示地抛出异常，靠默认的抛出异常机制蒙混过关，
 *   子类显式地抛出异常要么与父类一致、要么是父类抛出异常的子类
 *   若父类没有显式地抛出异常，则隐含着throws Exception，子类便可随心所欲
 * 4.对于编译时异常，只要抛出就必须得到解决，不然无法编译通过
 *   对于运行时异常，在编译时不会有任何编译错误提示，直到运行时，才会发现有运行时异常，
 *   这时候默认的throws就发挥了作用，这也是为什么要默认的throws
 */
public class ThrowsDetail{
	public static void main(String[] args){//默认抛出程序，处理了f1中存在的运行时异常
		f1();
	}//end main

	public static void f1(){//默认抛出异常，处理了f3()的运行时异常
		try{
			f2();//f2中的编译时异常被在此处捕获
		}catch(FileNotFoundException e){
			System.out.println(e);
		}

		f3();

	}

	public static void f2() throws FileNotFoundException{
		throw new FileNotFoundException();
	}

	public static void f3(){//默认抛出异常，处理了RuntimeException运行时异常
		throw new RuntimeException();
	}
}

class Father{
	protected void method() throws NoSuchFieldException{
		throw new NoSuchFieldException();

	}
}

class Son extends Father{
	@Override
	protected void method(){
		throw new NullPointerException();
	}
}