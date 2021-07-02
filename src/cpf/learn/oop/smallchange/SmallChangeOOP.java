package cpf.learn.oop.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 用面向对象的思想来编写零钱通：
 * 1.思路分析
 * 面向过程：行动要怎么一步步来进行？
 * OOP：谁要做什么？
 * 2.零钱通有哪些可以抽象出来的对象呢？
 * 零钱通对象   一个对象足够了
 * 收益、消费、菜单、退出 都设计为方法
 */
public class SmallChangeOOP{
	private String name;//谁的零钱通
	private String detail;//明细，这是必不可少的属性
	private double balance;//余额，不论是收益还是消费都会变动余额
	/*
	这样做的话，对象创建的那一刻，这些时间就都确定了，无论什么时候消费，都是一个时间，是不对的。
	应该把这两个语句放在每次收益和消费的地方生成，这样时间就不同了。
	private Date date = new Date();//明细中需要有时间
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//格式化时间
	*/
	//每次收益的money、消费的money更像是一个过度量，就不设计为属性

	//0.菜单
	public void menu(){
		boolean loop = true;
		String choose;
		double money;
		Scanner scanner = new Scanner(System.in);

		do{
			System.out.println("==========零钱通菜单=========");
			System.out.println("\t\t\t1.零钱通明细");
			System.out.println("\t\t\t2.收益入账");
			System.out.println("\t\t\t3.消费");
			System.out.println("\t\t\t4.退出");

			System.out.print("请选择(1~4):");
			choose = scanner.next();

			switch(choose){
				case "1":
					showDetail();
					break;
				case "2":
					System.out.print("本次收益入账金额：");
					money = scanner.nextDouble();
					income(money);//收益方法
					break;
				case "3":
					System.out.print("消费原因:");
					String reason = scanner.next();
					System.out.print("本次消费金额：");
					money = scanner.nextDouble();
					consume(reason, money);//消费方法
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

	//1.明细
	public void showDetail(){
		System.out.println(detail);
	}

	//2.收益
	public void income(double inMoney){
		if(inMoney <= 0){
			System.out.println("收入金额有误");
			return;
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		balance += inMoney;
		detail += "\n收益\t+" + inMoney + "\t" + sdf.format(date) + "\t" + balance;
	}

	//3.消费
	public void consume(String reason, double outMoney){
		if(outMoney <= 0){
			System.out.println("消费金额不能小于0");
			return;
		}
		if(outMoney > balance){
			System.out.println("余额不足，请及时充值");
			return;
		}
		//闯过金额检查，就开始拼接
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		balance -= outMoney;
		detail += "\n" + reason + "\t-" + outMoney + "\t" + sdf.format(date) + "\t" + balance;
	}


	//构造器
	public SmallChangeOOP(){
		name = "无名氏";//就算是没取名字，也要给一个初始化值好一些
		detail = name + "的零钱通明细:\n";
	}

	public SmallChangeOOP(String name){//构造的时候唯一有必要提前知道的，只有该属性
		this.name = name;
		detail = name + "的零钱通明细:\n";//构造的时候给detail加一些表头提示
	}

	//get\set
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDetail(){
		return detail;
	}

	public void setDetail(String detail){
		this.detail = detail;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}


}


























