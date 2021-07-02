package cpf.learn.chapter13;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author CPF 创建于： 2021/6/18 0:39
 * 数学类 Math 的相关方法：（几乎都是静态的）
 */
public class MathMethods{
	public static void main(String[] args){
		//想一些数学相关的数值，来通过Math类获得
		//1.圆周率
		System.out.println(Math.PI);
		//2.对数值 e
		System.out.println(Math.E);
		//3.绝对值 : absolute value
		System.out.println(Math.abs(-13));//13
		//4.求平方根
		System.out.println(Math.sqrt(9));//3.0
		//5.求幂（求次方）次方：power
		System.out.println(Math.pow(2, 4));//16.0
		//6.四舍五入 long
		System.out.println(Math.round(Math.PI));//3
		System.out.println(Math.round(Math.E));//3
		//7.向上取整 天花板 : ceiling : 上限
		System.out.println(Math.ceil(Math.PI));//4.0
		System.out.println(Math.ceil(-0.5));//-0.0  x
		//8.向下取整 地板 ： floor
		System.out.println(Math.floor(Math.PI));//3.0
		//9.random() 值位于[0,1)之间
		for(int i = 0; i < 10; i++){
			System.out.print(String.format("%.3f\t", Math.random()));
			if(i == 9) System.out.println();
		}
		int a = 2;
		int b = 9;
		//得到一个[a,b)内的随机数
		double ran = 0;
		for(int i = 1; i <= 10; i++){
			ran = a + (Math.random() * (b - a));
			System.out.print(String.format("%.3f\t", ran));
			if(i == 10) System.out.println();
		}
		//10.最大最小值
		System.out.println(Math.max(1, 1.2));
		System.out.println(Math.min(1, 1.2));
		//
		//
		//
	}
}
