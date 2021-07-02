package cpf.learn.oop.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 一个小项目：零钱通
 */
public class SmallChangeProcess{

	//1.明细用字符串来拼接
	static String detail = "零钱通明细：\n";

	//2.收益入账
	static double money;//每次入账
	static double balance;//余额
	static Date date = new Date();//日期
	//格式化日期
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	//消费明细
	//money复用上述变量，表示此次消费金额
	static String reason;//消费原因


	public static void main(String[] args){
		//SmallChangeProcess myWallet = new SmallChangeProcess();
		SmallChangeProcess.menu();

		System.out.println(SmallChangeProcess.detail);

	}//end main

	//菜单方法
	public static void menu(){

		boolean loop = true;
		String choose;
		Scanner scanner = new Scanner(System.in);

		do{
			System.out.println();
			System.out.println("==========零钱通菜单=========");
			System.out.println("\t\t\t1.零钱通明细");
			System.out.println("\t\t\t2.收益入账");
			System.out.println("\t\t\t3.消费");
			System.out.println("\t\t\t4.退出");

			System.out.print("请选择(1~4):");
			choose = scanner.next();

			switch(choose){
				case "1":
					System.out.println(detail);//直接打印出收益明细拼接字符串即可
					break;
				case "2":
					System.out.print("本次收益入账金额：");
					money = scanner.nextDouble();
					if(money < 0){
						System.out.println("收益金额有误，请重新选择...");
						break;
					}

					balance += money;
					//把此次行为记入收益明细
					detail += "\n收益\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
					break;
				case "3":
					System.out.print("消费原因:");
					reason = scanner.next();
					System.out.print("本次消费金额：");
					money = scanner.nextDouble();
					if(money > balance){
						System.out.println("余额不足，无法消费，请及时充值...");
						break;
					}
					if(money <= 0){
						System.out.println("消费金额必须大于0，返回菜单...");
						break;
					}

					balance -= money;

					//把消费信息记入明细
					detail += "\n" + reason + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
					break;
				case "4":
					System.out.println("\t\t\t4.退出");
					loop = false;
					break;
				default:
					System.out.println("菜单选择有误，请重新选择！");
					break;
			}
		}while(loop);

	}
}
