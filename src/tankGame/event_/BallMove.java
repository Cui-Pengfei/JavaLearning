package tankGame.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author CPF 创建于： 2021/7/1 11:41
 * @version 1.0
 * 通过控制小球上下左右移动，了解java的事件处理机制
 */
public class BallMove extends JFrame{

	public static void main(String[] args){
		BallMove ballMove = new BallMove();
	}//end main

	private ThisPanel panel = new ThisPanel();

	public BallMove(){
		this.addKeyListener(panel);//框架也要监听才行
		this.add(panel);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}

class ThisPanel extends JPanel implements KeyListener{
	private int ballX = 500;
	private int ballY = 500;

	//想要小球移动，画板要监听键盘输入
	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.fillOval(ballX, ballY, 30, 30);
	}

	/**
	 * 有字符输入时，该方法会被触发
	 * @param e 通过该事件可以得到触发的字符
	 */
	@Override
	public void keyTyped(KeyEvent e){

	}

	/**
	 * 当某个键按下时，该方法会触发
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e){
		int receive = e.getKeyCode();
		switch(receive){
			case KeyEvent.VK_DOWN:
				ballY += 1;
				if(ballY >= 600)
					ballY = 0;
				break;
			case KeyEvent.VK_UP:
				ballY -= 1;
				if(ballY <= -30)
					ballY = 600;
				break;
			case KeyEvent.VK_RIGHT:
				ballX += 1;
				if(ballX >= 600)
					ballX = 0;
				break;
			case KeyEvent.VK_LEFT:
				ballX -= 1;
				if(ballX <= -30)
					ballX = 600;
				break;
		}
		this.repaint();
	}

	/**
	 * 当某个键松开时，该方法会触发
	 *
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e){

	}
}
