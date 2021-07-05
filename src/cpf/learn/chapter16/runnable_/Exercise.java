package cpf.learn.chapter16.runnable_;

/**
 * @author CPF 创建于： 2021/7/3 9:52
 * @version 1.0
 */
public class Exercise{
	public static void main(String[] args){
		Thread01 thread01 = new Thread01();
		Thread02 thread02 = new Thread02();
		thread01.start();
		thread02.start();

	}//end main
}//end class

class Thread01 implements Runnable{
	private int count = 0;
	@Override
	public void run(){
		while(true){
			System.out.println("hello,world次数" + (++count));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(count == 10) break;
		}
	}

	public synchronized void start(){
		Thread thread = new Thread(this);
		thread.start();
	}
}//end class

class Thread02 implements Runnable{
	private int count = 0;
	@Override
	public void run(){
		while(true){
			System.out.println("hi次数" + (++count));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(count == 5) break;
		}
	}

	public synchronized void start(){
		Thread thread = new Thread(this);
		thread.start();
	}
}//end class
