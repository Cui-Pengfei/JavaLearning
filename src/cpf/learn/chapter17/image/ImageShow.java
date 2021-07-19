package cpf.learn.chapter17.image;

import javax.swing.*;
import java.awt.*;

/**
 * @author CPF 创建于： 2021/7/18 23:11
 * @version 1.0
 * 展示图片到JPanel
 */
public class ImageShow extends JFrame{

	public static void main(String[] args){
		ImageShow imageShow = new ImageShow();
	}

	public ImageShow(){
		thisPanel panel = new thisPanel();
		this.add(panel);
		this.setSize(500, 500);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);//一开始就设置最大化
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//将关闭按钮与关闭视图结合
	}
}

class thisPanel extends JPanel{

	Image image = Toolkit.getDefaultToolkit().
			getImage("src/cpf/learn/chapter17/image/bomb_1.gif");

	@Override
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(image, 50, 50, 60, 60, this);
	}
}
