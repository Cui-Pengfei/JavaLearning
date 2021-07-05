package cpf.learn.chapter16.exit_;

/**
 * @author CPF 创建于： 2021/7/3 15:15
 * @version 1.0
 */
public class ThreadExit{
	public static void main(String[] args) throws InterruptedException{
		T t = new T();
		t.start();

		while(true){//控制子线程休眠的条件
			if(t.getCount() >= 30)
				break;
			Thread.sleep(1000);//延迟装置
		}

		t.setLoop(false);
	}//end main
}

class T extends Thread{
	private int count = 0;
	private boolean loop = true;


	public void setLoop(boolean loop){
		this.loop = loop;
	}

	public int getCount(){
		return count;
	}

	@Override
	public void run(){
		while(loop){
			System.out.println("线程T在运行..." + (++count));
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}
}