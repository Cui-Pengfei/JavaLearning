package cpf.learn.chapter16.state_;

/**
 * @author CPF 创建于： 2021/7/4 8:45
 * @version 1.0
 */
public class StateSimple{
	public static void main(String[] args) throws InterruptedException{
		T t = new T();
		System.out.println(t.getName() + "的状态是：" + t.getState());//NEW

		t.start();
		System.out.println(t.getName() + "的状态是：" + t.getState());//RUNNABLE

		while(true){
			if(t.getState() == Thread.State.TIMED_WAITING){
				System.out.println(t.getName() + "的状态是：" + t.getState());//TIMED_WAITING
				break;
			}
		}

		Thread.sleep(5*1000);//主线程睡眠5秒让子线程工作
		t.wait(3000);//子线程等3秒
		System.out.println(t.getName() + "的状态是：" + t.getState());//WAITING
	}//
}

class T extends Thread{
	{
		setName("T");
	}
	@Override
	public void run(){
		while(true){
			//工作3秒
			System.out.println("工作中...");
			long start = System.currentTimeMillis();
			long end;
			for(;;){
				end = System.currentTimeMillis();
				if(end - start > 3000)
					break;
			}
			//休眠3秒
			System.out.println("休眠中...");
			try{
				Thread.sleep(3000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}

		}
	}
}
