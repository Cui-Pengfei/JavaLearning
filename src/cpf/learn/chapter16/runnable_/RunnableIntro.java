package cpf.learn.chapter16.runnable_;

/**
 * @author CPF 创建于： 2021/7/3 6:37
 * @version 1.0
 * 通过实现接口Runnable来实现线程：
 * 重写run()方法以及start()方法.
 *
 */
public class RunnableIntro{
	public static void main(String[] args){
		Son son = new Son();
		son.start();
	}//end main
}

class Father{

}

class Son extends Father implements Runnable{
	private int count = 0;
	@Override
	public void run(){
		while(true){
			System.out.println("儿子运行" + (++count) + "线程名 = " + Thread.currentThread().getName());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(count == 10) break;
		}
	}//end run

	public void start(){//自己想出来的，我真是个天才
		Thread thread = new Thread(this);
		thread.start();
	}
}