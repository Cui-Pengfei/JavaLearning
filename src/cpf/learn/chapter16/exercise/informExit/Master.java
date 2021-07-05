package cpf.learn.chapter16.exercise.informExit;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * @author CPF 创建于： 2021/7/5 9:05
 * @version 1.0
 */
public class Master extends Thread{
	private final JFrame frame = new JFrame();//画板的载体
	private final MyPanel panel = new MyPanel();//画板，承接键盘命令的容器
	private final Count thread;//要控制的线程，从外界传进来

	{//把画板放入框架中
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Master(Count thread){
		this.thread = thread;
	}

	@Override
	public void run(){
		while(true){
			int key = panel.getKeyCode();
			try{
				Thread.sleep(1);//为什么这里必须休眠一下才可以实现呢？连一毫秒也可以
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(key == KeyEvent.VK_S){
				thread.setLoop(false);
				if(thread.getState() == State.TIMED_WAITING){
					thread.interrupt();//由于count进程会休眠，有可能按下键的时候它在休眠，无法快速反应
				}
				break;//退出本线程
				
			}
		}
	}
}
