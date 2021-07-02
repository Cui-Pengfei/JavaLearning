package tankGame.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author CPF 创建于： 2021/7/1 2:49
 * 如何在面板上画出一个圆：
 * 1. 先定一个面板 Panel 继承JPanel类
 * 2.
 */
public class DrawCircle extends JFrame{//JFrame是一个框架，可容下画板JPanel

	public static void main(String[] args){
		DrawCircle drawCircle = new DrawCircle();
	}

	private MyPanel mp = null;

	public DrawCircle(){
		//初始化面板
		mp = new MyPanel();
		//把面板放入框架中
		this.add(mp);//经过几个继承链条，发现是JFrame继承的父类Container的add方法
		//设置框架大小
		this.setSize(400, 300);//调用的是父类window的方法
		//设置可视化
		this.setVisible(true);
		//当点击框架的关闭按钮时，程序并不会结束，没有释放这个JFrame，如何点击关闭就释放JFrame呢？
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//其实这个整数值=3

	}
}

class MyPanel extends JPanel{//这是我的画板
	private static int paintNum = 0;

	/**
	 * 这个paint()方法非常奇怪，看上去没有调用，但实际上是调用了，这涉及到绘图原理，有监听机制.
	 * 1.当组件第一次在屏幕显示的时候，程序会自动调用paint()方法来绘制组件
	 * 2.窗口最小化再最大化时，也会自动调用paint()方法
	 * 注意：若窗口最大化，有两个动作：最大化、改变窗口原始大小；会调用两次paint()方法
	 * 3.窗口大小发生变化时，会调用paint()方法
	 * 4.repaint函数被调用时，会自动调用paint()方法
	 * 【我自己在单击面板的时候，也会重新调用paint方法】
	 * @param g
	 */
	@Override
	public void paint(Graphics g){//绘图方法
		paintNum++;
		System.out.println("paint()方法调用第" + paintNum + "次...");

		//Graphic是我的一支画笔，提供了很多绘图方法
		super.paint(g);//此处必须调用父类的有参方法
		g.drawOval(0, 0, 100, 100);
	}
}
