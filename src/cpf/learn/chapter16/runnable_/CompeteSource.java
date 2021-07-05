package cpf.learn.chapter16.runnable_;

/**
 * @author CPF 创建于： 2021/7/3 10:06
 * @version 1.0
 * 继承Runnable接口意思是此类可以被当作线程，但是目前还不是线程，
 * 这使得此类放入多个县城中成为可能：
 */
public class CompeteSource{
	public static void main(String[] args){
		NewThread newThread = new NewThread();

		Thread thread0 = new Thread(newThread);
		thread0.start();
		Thread thread1 = new Thread(newThread);
		thread1.start();
		Thread thread2 = new Thread(newThread);
		thread2.start();
		Thread thread3 = new Thread(newThread);
		thread3.start();
		Thread thread4 = new Thread(newThread);
		thread4.start();//多个线程竞争一个资源的时候，

	}
}

class NewThread implements Runnable{
	private boolean lock = false;
	private int common = 0;

	@Override
	public void run(){

		while(lock){//只要锁还在就休眠1秒
			int sleepTime = (int)((Math.random()) * 2 + 1) * 100;//[100,600]
			try{
				Thread.sleep(sleepTime);//改变不同线程的休眠时间间隔，有效防止了某一时刻的竞争
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		//轮到自己了，赶快锁上
		lock = true;

		while(true){
			common = common + 2;
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " common = " + common);
			if(common % 10 == 0) break;//每个线程输出5个
		}

		lock = false;//完成任务，解锁
	}//end run
}
