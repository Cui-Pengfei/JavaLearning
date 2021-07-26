package cpf.learn.chapter19.ClassIntro;

/**
 * @author CPF 创建于： 2021/7/24 18:06
 * @version 1.0
 *
 *   synchronized (getClassLoadingLock(name))
 *  类加载的初始化阶段，对静态属性的初始化具有同步性...
 *
 */
public class LoadSynchronized{
	public static void main(String[] args){
		T1 t1 = new T1();

		T2 t2 = new T2();

		t1.start();
		t2.start();
	}
}

class Model{
	public static int i = 10;

	static {
		System.out.println("初始化器执行...");
	}
}

class T1 extends Thread{
	@Override
	public void run(){
		while(true){
			System.out.println("T1获得i值 = " + Model.i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}

class T2 extends Thread{
	@Override
	public void run(){
		while(true){
			System.out.println("T2获得i值 = " + Model.i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
}
