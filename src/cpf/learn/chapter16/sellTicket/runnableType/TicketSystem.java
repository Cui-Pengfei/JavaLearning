package cpf.learn.chapter16.sellTicket.runnableType;

/**
 * @author CPF 创建于： 2021/7/3 12:01
 * @version 1.0
 */
public class TicketSystem{
	public static void main(String[] args){
		SellTickets sellTickets = new SellTickets();

		Thread thread1 = new Thread(sellTickets);
		thread1.start();

		SellTickets sellTickets1 = new SellTickets();
		Thread thread2 = new Thread(sellTickets1);
		thread2.start();
	}
}
