package cpf.learn.chapter16.syncronized_;

/**
 * @author CPF 创建于： 2021/7/4 14:04
 * @version 1.0
 * 当一个类的静态方法是synchronized的时候，表明此时把此类的类对象当做了对象锁！
 */
public class StaticSynchronized{
	public static void main(String[] args){
		//此时就算是不同的线程操作不同的T对象，在一个时刻也只有一个线程在操作，这就保证了不超卖 类变量
		T t1 = new T("t1");

		T t2 = new T("t2");

		T t3 = new T("t3");//三个不同的线程

		t1.start();
		t2.start();
		t3.start();//仍然不会超卖，而且尽然有序
	}
}

class T extends Thread{
	private static int count = 100;
	private static int num = 100;

	public T(String name){
		this.setName(name);
	}

	public synchronized static void cut(){
		if(count == 0){
			System.out.println(Thread.currentThread().getName() + "操作count失败！已经归零！");
			return;
		}
		count--;
		System.out.println(Thread.currentThread().getName() + "操作后count = " + count);
	}

	public static void reduce(){
		synchronized(T.class){//这与上面是等价的,还是对象锁，不过换成了类对象，一个类只有一个类对象，就形成了一一对应
			if(num == 0){
				System.out.println(Thread.currentThread().getName() + "操作num失败！已经归零！");
				return;
			}
			num--;
			System.out.println(Thread.currentThread().getName() + "操作后num = " + num);
		}
	}

	@Override
	public void run(){
		while(count != 0 || num != 0){
			cut();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			reduce();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
