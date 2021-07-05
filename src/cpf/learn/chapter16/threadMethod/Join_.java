package cpf.learn.chapter16.threadMethod;

/**
 * @author CPF 创建于： 2021/7/3 18:46
 * @version 1.0
 * 此方法是涉及cpu调动的，更底层的方法；(就是一插队的！)
 * 在一个线程里面调用另一个线程的join方法，从调用的位置起，开始执行第二个线程；
 * 这里搞一个互相谦让的例子吧！
 *
 * 注意：如果线程1还没启动，那么在线程2中符合某个条件后，线程1.start(); 线程1.join()
 *      两个方法的含义是不同的：
 *          1.如果只是start,那么两个线程还是会各跑各的；
 *          2.如果还没start，是不能join的,join()方法并没有启动的含义在内
 */
public class Join_{
	public static void main(String[] args){
		Man man = new Man();
		Woman woman = new Woman();
		man.setAnother(woman);
		woman.setAnother(man);

		man.start();
		woman.start();
		/*
		此例中，男女并不会交替吃下去，只会各吃5个包子，就都在等待了：
		男人吃得快，吃完五个等待女人吃；此时状态为【等待女人进程结束】
		女人吃完5个包子，等男人去吃包子；此时状态为【等待男人进程结束】
		但是男人是永远结束不了的，因为女人没结束；
		女人也永远结束不了，因为男人没结束，
		于是就都卡在这里了，这就是死锁！
		 */

	}
}

class Man extends Thread{
	private int count = 0;
	private Thread another;

	public Thread getAnother(){
		return another;
	}

	public void setAnother(Thread another){
		this.another = another;
	}

	@Override
	public void run(){
		while(true){
			System.out.println("男人在吃包子" + (++count));
			try{
				Thread.sleep(300);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(count % 5 == 0){
				System.out.println("Man已经吃了" + count + "个包子了，让给Woman吃");
				try{
					another.join();//另一个线程加入
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}//end while
	}
}//end class

class Woman extends Thread{
	private int count = 0;
	private Thread another;

	public Thread getAnother(){
		return another;
	}

	public void setAnother(Thread another){
		this.another = another;
	}

	@Override
	public void run(){
		while(true){
			System.out.println("女人在吃包子" + (++count));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(count % 5 == 0){
				System.out.println("Woman已经吃了" + count + "个包子了，让给Man吃");
				try{
					another.join();//另一个线程加入
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}//end while
	}
}
