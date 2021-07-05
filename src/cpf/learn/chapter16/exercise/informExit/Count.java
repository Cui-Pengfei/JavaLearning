package cpf.learn.chapter16.exercise.informExit;

/**
 * @author CPF 创建于： 2021/7/5 9:04
 * @version 1.0
 */
public class Count extends Thread{
	private int count;
	private boolean loop = true;

	@Override
	public void run(){
		while(loop){
			System.out.println("Count = " + (++count));//从0开始数数
			try{
				Thread.sleep(5000);//每数一个数，休眠半秒
			}catch(InterruptedException e){
				System.out.println("被终止了呢！那就不要数数了！");
			}
		}
	}//end run

	public void setLoop(boolean loop){
		this.loop = loop;
	}
}//end count
