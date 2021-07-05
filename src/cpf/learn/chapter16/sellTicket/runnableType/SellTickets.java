package cpf.learn.chapter16.sellTicket.runnableType;

import javax.swing.*;
import java.awt.*;

/**
 * @author CPF 创建于： 2021/7/3 11:57
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SellTickets implements Runnable{
	private TicketPanel tp;

	public SellTickets(){
	}

	private void addFrame(){
		tp = new TicketPanel(100);
		Frame frame = new JFrame();
		frame.add(tp);
		frame.addKeyListener(tp);
		frame.setSize(600,600);
		frame.setVisible(true);
		((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run(){
		addFrame();
		while(true){
			try{
				Thread.sleep(300);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			tp.repaint();//刷新

		}
	}
}
