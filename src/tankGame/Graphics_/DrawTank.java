package tankGame.Graphics_;

import javax.swing.*;
import java.awt.*;

/**
 * @author CPF 创建于： 2021/7/1 7:36
 */
public class DrawTank extends JFrame{
	public static void main(String[] args){

		JPanel jPanel = new JPanel(){
			@Override
			public void paint(Graphics g){
				super.paint(g);
				//此颜色画车辙、主体轮廓
				g.setColor(Color.ORANGE);
				g.drawRect(220,220, 40, 60);//主体
				g.drawRect(200,200, 20, 100);//车辙
				g.drawRect(260,200, 20, 100);//车辙

				//此颜色填充两个车辙、坦克主体
				g.setColor(Color.CYAN);
				g.fillRect(220,220, 40, 60);//主体
				g.fillRect(200,200, 20, 100);//车辙
				g.fillRect(260,200, 20, 100);//车辙

				//此颜色绘制炮架、炮筒
				g.setColor(Color.pink);
				g.fillOval(220,230,40,40);
				g.fillRect(238, 190, 4,50);//炮筒



			}
		};//画板完成

		JFrame jFrame = new JFrame();
		jFrame.add(jPanel);
		jFrame.setSize(800,800);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
}
