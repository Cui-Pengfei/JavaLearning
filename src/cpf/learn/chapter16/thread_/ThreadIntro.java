package cpf.learn.chapter16.thread_;

/**
 * @author CPF 创建于： 2021/7/2 12:41
 * @version 1.0
 * 线程介绍：
 * 1. 在Terminal中使用命令"jconsole"可以进入【java监视管理控制台】，可以监视到进程的具体情况
 * 2.
 */
public class ThreadIntro{
	public static void main(String[] args) throws InterruptedException{

		Cat cat = new Cat();

		System.out.println("========== <直接调用 =============");
		cat.run();//如果此处直接调用，那就是在main线程内调用一个普通的方法，打印出的线程名称也是main,不是线程，会阻塞；
		System.out.println("========== 直接调用> =============");

		//这就是启动线程，此时会触发cat内的run方法，内有业务逻辑，此线程按照自己的逻辑独立运行，下面的代码还会继续执行
		cat.start();//开一个新的线程的时候，主线程并不会阻塞

		Dog dog = new Dog();
		dog.start();

		System.out.println("主线程继续执行：");
		for(int i = 0; i < 50; i++){
			System.out.println("主线程" + Thread.currentThread().getName() + "在执行模块" + i);
			Thread.sleep(1000);
		}

	}//end main
}

class Cat extends Thread{
	private int times = 0;

	@Override
	public void run(){
		while(true){
			System.out.println("喵内~" + (++times) + "线程名 = " + Thread.currentThread().getName());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(times == 80)
				break;
		}
	}//end run
}//end Cat

//当一个类继承了Thread类，那他就可以当做线程来使用
class Dog extends Thread{
	private int times = 0;

	//线程启动时，会调用run方法，run方法在执行时，其他线程也可以执行
	@Override
	public void run(){
		while(true){
			System.out.println("汪汪~" + (++times) + "线程名 = " + Thread.currentThread().getName());
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(times == 50)
				break;
		}

	}//end run
}
