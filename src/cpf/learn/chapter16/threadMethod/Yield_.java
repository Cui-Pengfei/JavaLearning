package cpf.learn.chapter16.threadMethod;

/**
 * @author CPF 创建于： 2021/7/3 19:13
 * @version 1.0
 * 这是线程礼让方法，也是涉及cpu的：
 * 语法：Thread.yield()表示本进程可以等待一会儿;
 * 但是不一定礼让成功，若资源不紧张，是不会出现礼让的；
 * 礼让的意思是【我需要这资源，但是我可以等等】；
 * cpu发现资源很充足，根本不需要礼让，此时还是会给礼让线程分配cpu，毕竟他也需要，只是想礼让
 */
public class Yield_{
	public static void main(String[] args){
		Man_ man = new Man_();
		Woman_ woman = new Woman_();

		man.start();
		woman.start();
	}
}
class Man_ extends Thread{
	private int count = 0;

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
				System.out.println("Man_已经吃了" + count + "个包子了，让给Woman_吃");
				Thread.yield();
			}
		}//end while
	}
}//end class

class Woman_ extends Thread{
	private int count = 0;

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
				System.out.println("Woman_已经吃了" + count + "个包子了，让给Man_吃");
				Thread.yield();
			}
		}//end while
	}
}
