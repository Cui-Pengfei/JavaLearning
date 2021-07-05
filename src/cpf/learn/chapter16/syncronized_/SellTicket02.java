package cpf.learn.chapter16.syncronized_;

/**
 * @author CPF 创建于： 2021/7/4 13:23
 * @version 1.0
 */
public class SellTicket02{
	public static void main(String[] args){
		Ticket ticket = new Ticket(100);

		Thread thread1 = new Thread(ticket);
		thread1.start();

		Thread thread2 = new Thread(ticket);
		thread2.start();

		Thread thread3 = new Thread(ticket);
		thread3.start();

		Thread thread4 = new Thread(ticket);
		thread4.start();
	}//end main
}

class Ticket02 implements Runnable{
	private int ticketNum;
	private boolean loop = true;

	public Ticket02(int ticketNum){
		this.ticketNum = ticketNum;
	}

	private void sell(){
		synchronized(this){//这种方式也是可以的，表示本对象内某个方法内的一个代码块需要同步
			if(ticketNum == 0){
				loop = false;
				System.out.println(Thread.currentThread().getName() + "卖票失败！已无票！");
				return;
			}
			ticketNum--;//卖票在无票判断返回之后，有效避免了超卖
			System.out.println(Thread.currentThread().getName() + "卖票后剩余票数：" + ticketNum);
		}
	}

	@Override
	public void run(){
		while(loop){//此处没有阻止多个线程进入，因为卖票也要等时间，就当做大家都来提前准备
			try{
				Thread.sleep(300);//卖票所需时间 模拟
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			sell();//但是真正卖票时刻，只能有一个来卖...

		}
	}
}

