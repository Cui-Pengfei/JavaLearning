package cpf.learn.oop.encapsulation;

import java.util.Scanner;

/**
 * 1.���ԣ�
 *      ������2��3��4λ
 *      ������ > 20
 *      ���룺������6λ
 *      ��������㣬�������ʾ��Ϣ������Ĭ��ֵ������Ա�Լ�����
 * 2.ͨ��set��Account�����Ը�ֵ
 * 3.��AccountTest�в���
 */
public class Account {

	//������������
	private String name;
	private double balance;
	private String pwd = "123456";//ԭʼ����

	//��Ϣչʾ����
	public void info(){
		System.out.print("չʾ��Ϣ��Ҫ�����������룺");
		Scanner scanner = new Scanner(System.in);
		String myPsw = scanner.next();
		if(myPsw.equals(pwd)){
			System.out.println(name + "����Ϣ���£�");
			System.out.println("������" + getName());
			System.out.println("��" + getBalance());
			System.out.println("���룺" + getPwd());
		}else{
			System.out.println("���������󣬾ܾ���Ϣչʾ...");
		}



	}

	//����������Ҫ��Ĭ��ֵ
	public Account(){//�½�ʱ��Ĭ��ֵ
		setName("������");
	}

	public Account(String name, double balance, String pwd){
		setName(name);
		setBalance(balance);
		setPwd(pwd);
	}

	//������get\set����
	public String getName(){

		return name;
	}

	public void setName(String name) {
		if(name.length() == 2 || name.length() == 3 || name.length() == 4){
			this.name = name;
		}else{
			System.out.println("��������������Ϸ������ֱ�����2��3��4���ַ�������Ĭ��ֵ�������ϡ�");
			this.name = "������";
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if(balance >= 20){
			this.balance = balance;
		}else{
			System.out.println("�����������������>=20...����Ĭ�����0.0");
			this.balance = 0;
		}
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		if(pwd.length() == 6){
			System.out.print("�����������(δ�޸Ĺ�������ԭʼ����)��");
			Scanner scanner = new Scanner(System.in);
			String myPwd = scanner.next();
			if(myPwd.equals(this.pwd)){//�����Ҫ��һ��Ĭ�ϵ�ԭʼ����
				this.pwd = pwd;
			}else{
				System.out.println("����������������޸�ʧ�ܣ�");
			}
		}else{
			System.out.println("��������ʧ�ܣ����볤�����󣬱�����6λ����...");
		}
	}
}//end class
