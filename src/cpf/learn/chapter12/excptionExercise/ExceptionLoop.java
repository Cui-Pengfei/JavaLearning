package cpf.learn.chapter12.excptionExercise;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author CPF 创建于： 2021/6/13 20:41
 * 要求：
        * 输入一个整数，不是就继续提醒输入
 */
@SuppressWarnings({"all"})
public class ExceptionLoop{
	public static void main(String[] args) throws IOException{
		currentBestSolution();
	}///end main

	public static void currentBestSolution(){
		Scanner scanner = new Scanner(System.in);//整个InputStream流一直没关闭
		int receive = 0;
		while(true){
			System.out.print("请输入一个整数：");
			try{
				receive = Integer.parseInt(scanner.next());
				//借助回车，输入一个String,就接受一个String，保证不会有剩余的next
				//由于scanner的定义在while外部，效率更高，但是害怕输入空格，会与目标效果不符合
				break;//若能执行到此句，说明每异常，就跳出循环
			}catch(NumberFormatException e){
				System.out.println("输入有误！" + e.toString());
			}
		}
		scanner.close();//最后关闭扫描流
		System.out.println("receive = " + receive);
	}

	public static void Solution(){
		int receive = 0;
		while(true){
			Scanner scanner = new Scanner(System.in);//整个InputStream流一直没关闭
			System.out.print("请输入一个整数：");
			try{
				receive = Integer.parseInt(scanner.next());
				//借助回车，输入一个String,就接受一个String，保证不会有剩余的next
				//由于scanner的调用在while循环内，不会害怕输入空格
				scanner.close();//若能行至此处，说明有成功的接收值，故关闭扫描流
				break;//若能执行到此句，说明每异常，就跳出循环
			}catch(NumberFormatException e){
				System.out.println("输入有误！" + e.toString());
			}
		}
		System.out.println("receive = " + receive);
	}

	public static void unsolved() throws IOException{
		int receive = 0;
		InputStream systemIn = null;
		Scanner scanner = null;

		do{
			System.out.print("请输入整数：");
			try{
				systemIn = System.in;//先打开一个系统输入流
				scanner = new Scanner(systemIn);//把这个输入流交给Scanner
				receive = scanner.nextInt();//在这个输入流中来找next
				break;
			}catch(Exception e){
				System.out.println("输入有误：" + e.toString());
			}finally{
				systemIn.close();//不管怎么样，一轮结束都会把输入流关闭，避免接着next
				scanner.close();
			}
		}while(true);

		System.out.println(receive);
	}
}
