package cpf.learn.chapter16.threadMethod;

/**
 * @author CPF 创建于： 2021/7/3 17:26
 * @version 1.0
 * 看一下不同的优先级，线程的先后顺序：
 * 在优先级高的线程没有因休眠、阻塞等释放资源时，两个竞争同一个资源的线程，优先级高的先执行
 */
public class Priority_{
	public static void main(String[] args){

		NewThread newThread = new
				NewThread();

		AnotherThread anThread = new AnotherThread();

		Thread thread1 = new Thread(newThread);
		thread1.setName("军官");
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread1.start();

		Thread thread2 = new Thread(newThread);
		thread2.setName("士兵");
		thread2.setPriority(Thread.MIN_PRIORITY);
		thread2.start();

		Thread thread = new Thread(anThread);//此处不相干进程仍然遵循优先级，是因为都会占用输出通道这个资源
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.start();

	}//end main
}

class NewThread implements Runnable{
	private int common = 0;

	//getter\setter
	public int getCommon(){
		return common;
	}
	public void setCommon(int common){
		this.common = common;
	}

	@Override
	public void run(){
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		while(true){
			System.out.println("线程：" + name + "，优先级：" + priority + "操作后common = " + (++common));
			try{
				if(common % 3 == 0){//会连续输出3个军官，三个士兵，在没有休眠的时候，军官总是先执行
					System.out.println(name + "休眠...");
					System.out.println("----------------------------");
					Thread.sleep(3000);
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class AnotherThread implements Runnable{
	@Override
	public void run(){
		while(true){
			System.out.println("不相干进程执行中...");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
