package cpf.learn.chapter10.abstract_.exercise;
/**
 * 体会抽象类的作用：模板设计模式
 */
public class Exercise02{
	public static void main(String[] args){
		A a = new A();
		a.calculateTime();

	}//end main
}

abstract class Common{
	//抽象出工作相关类都必须有的，但各不相同的方法
 	public abstract void job();

	//复用所有工作相关类的共同代码
	public void calculateTime(){
		long start = System.currentTimeMillis();
		job();
		long end = System.currentTimeMillis();
		System.out.println("共耗时：" + (end - start));
	}
}

class A extends Common{
	public void job(){
		int num = 0;
		for(int i = 1; i <= 800000; i++){
			num += i;
		}
	}
}

class B extends Common{
	public void job(){
		long num = 1;
		for(long i = 1; i <= 800000; i++){
			num *= i;
		}
	}
}

class C extends Common{
	public void job(){
		long num = 1;
		for(long i = 1; i <= 800000; i++){
			num -= i;
		}
	}
}
