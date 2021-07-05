package cpf.learn.chapter16.exercise;

/**
 * @author CPF 创建于： 2021/7/5 11:04
 * @version 1.0
 * 多线程取钱：
 * 一个卡上有10000元；
 * 两个用户都能来取钱，
 * 余额不足时，取钱失败，提示余额
 */
public class DrawMoney{
	public static void main(String[] args){
		Card card = new Card();

		Thread jack = new Thread(card);
		jack.setName("jack");
		Thread mary = new Thread(card);
		mary.setName("mary");

		jack.start();
		mary.start();
	}//end main
}

class Card implements Runnable{
	private int balance = 10000;//初试余额 1万元
	private boolean loop = true;

	@Override
	public void run(){
		while(loop){
			String user = Thread.currentThread().getName();
			draw(user,1000);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}//end run

	private synchronized boolean draw(String user, int num){
		if(num > balance){
			loop = false;
			System.out.println(user + "取钱失败！余额为：" + balance);
			return false;//余额不足
		}
		balance -= num;
		System.out.println(user + "取钱成功！余额为：" + balance);
		return true;
	}
}
