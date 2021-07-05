package cpf.learn.chapter16.syncronized_;

/**
 * @author CPF 创建于： 2021/7/4 13:59
 * @version 1.0
 */
public class SellTicket03{
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

class Ticket03 implements Runnable{
	private int ticketNum;
	private boolean loop = true;
	private Object object = new Object();//这里用一个对象充当一个锁，其实只用了它的一个位

	public Ticket03(int ticketNum){
		this.ticketNum = ticketNum;
	}

	private void sell(){//synchronized很耗时，原则上应该使尽可能少的代码进入
		synchronized(object){//这里就是利用对象来当做一个锁，也就是操作系统中学的pv操作里的【不可分割原语操作】
			//我们自己定的变量锁肯定要判断，但是我们写的java代码的判断语句并不是原语，同一时刻还是可以有多个线程来判断！！！！！
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

