package cpf.learn.oop.encapsulation;

public class AccountTest{
	public static void main(String[] args){
		Account a1 = new Account("jack", 2300, "199608");
		a1.info();

		Account someone = new Account();
		someone.info();
		someone.setName("mary");
		someone.setBalance(1234);
		someone.setPwd("666666");
		System.out.println("\n修改后信息如下：");
		someone.info();
	}//end main
}//end class
