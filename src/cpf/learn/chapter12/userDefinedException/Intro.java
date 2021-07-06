package cpf.learn.chapter12.userDefinedException;

/**
 * @author CPF 创建于： 2021/6/14 14:07
 * 用户自定义异常的入门：
 * 1.当程序中出现了某些“错误”，但是该错误信息并没有在Throwable子类中描述处理，
 *   这个时候可以自己设计异常类，用于描述该错误信息
 * 2.自定义异常类步骤
 * 2.1 理论上，我们可以继承Throwable类，Error类，但是这要求我们对java的理解非常深厚，
 * 因为这意味着，我们抛弃了现成的Error和Exception，另起炉灶，重新开始，难度很大
 * 2.2 继承Exception类，意味着是编译时异常，因为所有的编译时异常都继承自此，
 * 2.3 继承RuntimeException类，意味着是运行时异常，因为所有运行时异常的特征都是在此类中
 * 得到完善的，我们通常自定义的异常类都是继承自RuntimeException，因为这样可以利用默认的
 * 抛出异常机制，无须人为throws
 *
 *
 */
public class Intro{
	public static void main(String[] args){
		int HEAD = 80;
		int TAIL = 120;
		int age = 10;
		if(age < HEAD || age > TAIL){
			//这里可以通过构造器设置异常信息输出...
			throw new AgeException("您输入的数超出了范围[" + HEAD + "," + TAIL + "]");
		}else{
			System.out.println("您输入的数在范围内");
		}
	}//end main

}

class AgeException extends RuntimeException{

	public AgeException(String message){
		super(message);
	}
}


