package cpf.learn.chapter16.threadMethod;

/**
 * @author CPF 创建于： 2021/7/3 16:53
 * @version 1.0
 * interrupt单词的意思是【打断、插嘴、打扰】，
 * 此处的含义是，让线程从休眠中被唤醒...
 */
public class Interrupt_{
	public static void main(String[] args) throws InterruptedException{

		Thread t = new Thread(){
			private int count = 0;

			@Override
			public void run(){
				String name = Thread.currentThread().getName();
				while(true){
					for(int i = 1; i <= 10; i++){
						try{
							Thread.sleep(500 * i);//吃包子时间越来越长
						}catch(InterruptedException e){
							System.out.println("怎么吃这么慢！搞快点！");
						}
						System.out.println(name + "吃包子" + (++count));
					}
					try{
						Thread.sleep(10 * 1000);//吃完10个包子要休息10秒钟
					}catch(InterruptedException e){
						System.out.println(e);
						System.out.println(name + "休息被interrupt打断,被迫继续吃包子...");
					}
				}
			}//end run
		};//匿名内部线程

		t.setName("崔鹏飞");
		t.start();

		while(true){
			Thread.sleep(3 * 1000);//只允许休眠面3秒
			t.interrupt();
		}



	}//end
}
