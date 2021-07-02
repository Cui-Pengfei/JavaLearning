package cpf.learn.chapter10.interface_;

/**
 * 接口*****
 *      【定义】 接口就是给出一些没有实现的方法，封装到一起，到某个类要用的时候，根据实际情况，
 *              把这些方法实现。
 *      【理解】 就像接口是某种协议，一个类要做特定事情的时候，遵循某些协议，可以事半功倍，
 *              此时就让该类实现相应的接口，我们可以面向接口编程，实现“开闭原则”
 *      【语法】 interface 接口名{
 *                  属性;
 *                  方法;
 *              }
 *              class implements 接口{
 *                  自己属性;
 *                  自己方法;
 *                  必须实现接口的抽象方法;
 *              }
 *       【变迁】在JDK7.0及以前，接口内的所有方法都不能有方法体，即都是抽象方法
 *              在JDK8.0及以后，接口可以有静态方法、默认方法；也就是接口允许有一部分自己方法
 *
 *【接口的一些特性】
 *      1.接口中允许存在的成员：属性、抽象方法、静态方法、默认方法(不允许有构造器)
 *      2.接口中存在的属性都是默认static & final & public的
 *      3.接口中的所有方法都自动是public的，其他的修饰限制会报编译错误
 *      4.接口中的抽象方法省略abstract关键字,与上述public一样，可以加上但没必要
 *      5.接口中的默认方法必须显示地使用关键字default
 *      6.实现接口的抽象方法时，参数列表必须完全一致，返回类型可以相同，可以是抽象方法
 *        返回类型的子类
 *
 */
public class InterfaceIntro{//这里包含一个快速入门案例
	public static void main(String[] args){
		Phone phone = new Phone();
		Camera camera = new Camera();

		Computer computer = new Computer();
		computer.work(phone);
		computer.work(camera);
	}//end main
}//end class

interface Usb{//usb接口
	double length = 10;
	double width = 5;

	void start();
	void stop();
	Number test(Number number);
}

class Phone implements Usb{
	@Override
	public void start(){
		System.out.println("手机开始工作...");
	}
	@Override
	public void stop(){
		System.out.println("手机停止工作...");
	}

	@Override
	public Integer test(Number number){//实现抽象方法，参数列表必须一模一样
		return new Integer(0);
	}
}

class Camera implements Usb{
	@Override
	public void start(){
		System.out.println("相机开始工作...");
	}
	@Override
	public void stop(){
		System.out.println("相机停止工作...");
	}

	@Override
	public Integer test(Number number){
		return 0;
	}
}

class Computer{
	public void work(Usb usb){
		usb.start();
		usb.stop();
	}
}















