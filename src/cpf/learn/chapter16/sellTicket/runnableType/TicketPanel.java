package cpf.learn.chapter16.sellTicket.runnableType;

import cpf.learn.oop.poly.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author CPF 创建于： 2021/7/3 11:49
 * @version 1.0
 */
public class TicketPanel extends JPanel implements KeyListener{
	private static int tickets;

	public TicketPanel(){}

	public TicketPanel(int tickets){
		TicketPanel.tickets = tickets;
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		if(tickets > 0){
			g.setColor(Color.green);
		}else{
			g.setColor(Color.RED);
		}
		g.setFont(new Font("宋体", Font.BOLD, 50));
		g.drawString("票数量 = " + tickets, 150,300);

	}

	@Override
	public void keyTyped(KeyEvent e){

	}

	@Override
	public void keyPressed(KeyEvent e){
		int receive = e.getKeyCode();
		switch(receive){
			case KeyEvent.VK_DOWN:
				if(tickets > 0)
				tickets--;
				break;
			case KeyEvent.VK_UP:
				tickets++;
				break;
			default:
				break;
		}
		repaint();//重绘
	}

	@Override
	public void keyReleased(KeyEvent e){

	}

	public int getTickets(){
		return tickets;
	}

	public void setTickets(int tickets){
		this.tickets = tickets;
	}
}
