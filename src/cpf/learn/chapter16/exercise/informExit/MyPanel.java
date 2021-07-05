package cpf.learn.chapter16.exercise.informExit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author CPF 创建于： 2021/7/5 9:07
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener{
	private int keyCode;

	public int getKeyCode(){
		return keyCode;
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.green);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawString("我是监控器，点击S结束count线程",20,110);
	}

	@Override
	public void keyTyped(KeyEvent e){

	}

	@Override
	public void keyPressed(KeyEvent e){
		keyCode = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e){

	}
}
