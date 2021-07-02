package cpf.learn.oop.encapsulation;

import java.util.Scanner;

/**
 * 1.属性：
 *      姓名：2、3、4位
 *      余额：必须 > 20
 *      密码：必须是6位
 *      如果不满足，则给出提示信息，并给默认值（程序员自己定）
 * 2.通过set给Account的属性赋值
 * 3.在AccountTest中测试
 */
public class Account {

	//姓名、余额、密码
	private String name;
	private double balance;
	private String pwd = "123456";//原始密码

	//信息展示函数
	public void info(){
		System.out.print("展示信息需要输入您的密码：");
		Scanner scanner = new Scanner(System.in);
		String myPsw = scanner.next();
		if(myPsw.equals(pwd)){
			System.out.println(name + "的信息如下：");
			System.out.println("姓名：" + getName());
			System.out.println("余额：" + getBalance());
			System.out.println("密码：" + getPwd());
		}else{
			System.out.println("输入面有误，拒绝信息展示...");
		}



	}

	//构造器，需要有默认值
	public Account(){//新建时赋默认值
		setName("无名氏");
	}

	public Account(String name, double balance, String pwd){
		setName(name);
		setBalance(balance);
		setPwd(pwd);
	}

	//以下是get\set方法
	public String getName(){

		return name;
	}

	public void setName(String name) {
		if(name.length() == 2 || name.length() == 3 || name.length() == 4){
			this.name = name;
		}else{
			System.out.println("您输入的姓名不合法，名字必须是2、3、4个字符，给定默认值“无名氏”");
			this.name = "无名氏";
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if(balance >= 20){
			this.balance = balance;
		}else{
			System.out.println("余额输入有误，余额必须>=20...给定默认余额0.0");
			this.balance = 0;
		}
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		if(pwd.length() == 6){
			System.out.print("请输入旧密码(未修改过就输入原始密码)：");
			Scanner scanner = new Scanner(System.in);
			String myPwd = scanner.next();
			if(myPwd.equals(this.pwd)){//这就需要有一个默认的原始密码
				this.pwd = pwd;
			}else{
				System.out.println("您输入的密码有误，修改失败！");
			}
		}else{
			System.out.println("密码设置失败，密码长度有误，必须是6位密码...");
		}
	}
}//end class
