package cpf.learn.chapter13.wrapper;

/**
 * @author CPF 创建于： 2021/6/14 18:58
 * 包装类与基本数据类型的转化：此处只演示一个Integer
 */
public class Turn_IntegerInt{
	public static void main(String[] args){
		//演示Integer <---> int 的装箱、拆箱
		//jdk5以前是手动装箱、拆箱
		int z1 = 10;
		Integer integer = new Integer(z1);//手动装箱
		Integer integer1 = Integer.valueOf(z1);//手动装箱
		int c1 = integer.intValue();//手动拆箱

		//jdk5.0（包含）之后，就实现了自动装箱、拆箱
		int z2 = 20;
		Integer integer2 = z2;//这里在底层还是调用了valueOf(z2)，通过debug一目了然
		System.out.println(integer2.intValue());
		int c2 = integer2;//这里底层还是调用了integer2.inValue()方法
		System.out.println(c2);
		//其他包装类的用法类似，不一一举例了！
		//关键是，这个识别技术，是怎么工作的，一无所知

	}
}
