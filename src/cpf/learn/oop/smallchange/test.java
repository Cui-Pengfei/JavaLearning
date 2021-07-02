package cpf.learn.oop.smallchange;

/**
 * 测试零钱通OOP
 */
public class test{
	public static void main(String[] args){
		SmallChangeOOP myWallet = new SmallChangeOOP("崔鹏飞");
		myWallet.menu();
		myWallet.showDetail();
		System.out.println("余额：" + myWallet.getBalance());
	}
}
