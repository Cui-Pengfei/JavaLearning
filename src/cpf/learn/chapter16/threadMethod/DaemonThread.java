package cpf.learn.chapter16.threadMethod;

/**
 * @author CPF 创建于： 2021/7/4 5:17
 * @version 1.0
 * 守护线程：Daemon Thread 为用户线程服务的线程；
 * 用户线程：User Thread 一般工作的线程
 * 规则：当且仅当没有与任何一个 User Thread的时候，Daemon Thread才会全部结束；
 * 案例：GC时最典型的守护进程
 * 例子：把子线程设置为守护线程--->
 */
public class DaemonThread{
	public static void main(String[] args) throws InterruptedException{

		MyDaemonThread daemon = new MyDaemonThread();
		daemon.setDaemon(true);
		daemon.start();

		int count = 0;
		while(true){
			System.out.println("吃包子" + (++count));
			if(count == 10){
				System.out.println("我吃饱了，别喂我了！");
				break;
			}
			Thread.sleep(1000);

		}

	}//end main
}

class MyDaemonThread extends Thread{
	@Override
	public void run(){
		while(true){
			System.out.println("我喂你吃饭...");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
