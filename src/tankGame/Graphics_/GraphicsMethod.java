package tankGame.Graphics_;


import javax.swing.*;
import java.awt.*;

/**
 * @author CPF 创建于： 2021/7/1 3:41
 * 1. paint(Graphics g)会传入一个画笔Graphics，它提供了很多方法来绘制各种图形
 * 2. 由于Graphics是一个抽象类，构建一个特殊的Graphics实现的对象并不容易，因此还是借用JPanel的paint方法
 */
public class GraphicsMethod{
	public static void main(String[] args){

		//1. 自定义画板
		JPanel jPanel = new JPanel(){//画板，初始化画板会调用其中的paint方法，使用匿名内部类来重写paint方法
			@Override
			public void paint(Graphics g){
				super.paint(g);
				//画圆圈
				g.drawOval(10,10,50,50);
				//画矩形：此处画一个圆的外切正方形
				g.drawRect(10,60,50,50);
				//填充矩形
				g.setColor(Color.MAGENTA);//先设置画笔颜色
				g.fillRect(10,60,50,50);
				//填充圆形
				g.setColor(Color.BLUE);
				g.fillOval(10,10,50,50);//但是由于后定义的矩形会覆盖圆形，导致圆形不可见

				//画图片：
				// 1.获取图片资源
				Image image = Toolkit.getDefaultToolkit().getImage
						(Class.class.getResource("/tankGame/Graphics_/女孩子1.jpg"));
				//2.图片画入画板
				g.drawImage(image,60,10,500,280,this);

				//画字符串，也就是写字
				//1. 画笔设置颜色
				g.setColor(Color.RED);
				//2. 设置字体
				g.setFont(new Font("宋体", Font.BOLD, 50));
				g.drawString("热烈祝贺共产党成立100周年！", 10, 340);//坐标对应文字的左下角



			}
		};

		//2. 把画板放入框架中
		JFrame frame = new JFrame();//建一个框架
		frame.add(jPanel);
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

