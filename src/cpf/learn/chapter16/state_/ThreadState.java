package cpf.learn.chapter16.state_;

/**
 * @author CPF 创建于： 2021/7/4 6:57
 * @version 1.0
 * 学习线程的生命周期：
 */
public class ThreadState{
	public static void main(String[] args) throws InterruptedException{
		Low low = new Low();
		System.out.println(low.getName() + "的状态是：" + low.getState());//NEW

		low.start();
		Thread.sleep(7 * 1000);//为了体现low休眠时的状态，此处必须延缓high的步伐
		System.out.println(low.getName() + "的状态是：" + low.getState());//TIMED_WAITING 此时离唤醒还有1秒


		High high = new High();
		high.start();//更高优先级的线程启动，会执行10秒，霸占10秒时间

		if(!high.isAlive())
		System.out.println(low.getName() + "的状态是：" + low.getState());//WAITING


	}//end main
}

class Low extends Thread{
	{
		setName("Low");
		setPriority(Thread.MIN_PRIORITY);

	}

	@Override
	public void run(){
		while(true){
			System.out.println("Low执行中，通常执行5秒...");
			System.out.println(getName() + "的状态是：" + getState());//RUNNABLE

			long startTime = System.currentTimeMillis();
			long endTime;
			for(; ; ){
				endTime = System.currentTimeMillis();
				if((endTime - startTime) > 5 * 1000)
					break;//循环5秒，然后休眠5秒
			}
			System.out.println("Low一段任务完成，休眠5秒...");
			try{
				Thread.sleep(5 * 1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}


class High extends Thread{
	{
		setPriority(Thread.MAX_PRIORITY);
		setName("High");
	}

	@Override
	public void run(){
		while(true){
			System.out.println("High优先级更高先执行...");

			//给一个任务，拖延点时间,毕竟一sleep就会执行别的线程

			long startTime = System.currentTimeMillis();
			long endTime;
			for(; ; ){
				endTime = System.currentTimeMillis();
				if((endTime - startTime) == 5000)
					System.out.println("时间过半");

				if((endTime - startTime) > 10 * 1000)
					break;//循环10秒，然后休眠5秒
			}
			System.out.println("High暂时执行完了,休眠5秒...");
			try{
				Thread.sleep(5 * 1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("High休眠结束，结束进程...");
			break;//消亡High
		}
	}
}
