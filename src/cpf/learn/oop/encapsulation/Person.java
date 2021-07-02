package cpf.learn.oop.encapsulation;

import java.util.Scanner;

/**
 * Ҫ��
 *      �������鿴�˵�����,���ʵ���˽,�������õ�������к������֤��
 *      ������������,�����Ĭ������,������1-120,
 *      ���䣬���ʲ���ֱ�Ӳ鿴��
 *      name�ĳ�����2-6֮��
 */
public class Person {

	//�ĸ�˽�����ԣ����������䡢ְλ������
	private String name;
	private int age;
	private String position;
	private Double salary;

	public static void main(String[] args) {
		Person jack = new Person();
		jack.setName("jack");
		jack.setAge(30);
		jack.setPosition("����");
		jack.setSalary(30000);
		jack.info();

		//ע��˴�����д12000.0��Ϊ��������Double�����ܰ�int��Double,��Ϊ��װ��Doubleֻʵ����double��Double.
		Person mary = new Person("mary", 22, "ʵϰ��", 1200.0);
		mary.info();



	}//end main

	public Person() {
	}

	/**
	 * ��������set�����Ľ��.
	 *      ��������ݼ�alt+insert,��ѡ��constructor.
	 *
	 *  ��֮���������Ե�������set\get������ʵ�֣���һ����ʵ�ַ�װ.
	 */

	public Person(String name, int age, String position, Double salary) {
		setName(name);
		setAge(age);
		setPosition(position);
		setSalary(salary);
	}

	/**
	 * get\set������ݼ�.
	 *      1.alt+insert ѡ��Ҫget\set�ķ�����һ�����.
	 *
	 *      2.Ҳ���԰ѹ����������ϣ�alt+enter���Գ���ʾ��
	 *        ѡ��"create getter and setter for field 'name'"��
	 *        ���ĳһ���Ե�get\set
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() >= 2 && name.length() <= 6){
			this.name = name;
		}else{
			System.out.println("���������������ֱ�����[2,6]���֣���Ĭ��ֵ�������ϡ�");
			this.name = "������";
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 120 && age >=1){
			this.age = age;
		}else{
			System.out.println("�����õ������������������[1,120]��Χ�ڣ���Ĭ��ֵ18��");
			this.age = 18;
		}

	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getSalary() {
		System.out.print("������鿴нˮ���룺");
		Scanner scanner = new Scanner(System.in);
		String pwd = scanner.next();
		if(pwd.equals("1996818110")){
			return salary;
		}else{
			System.out.println("���������������...");
			return null;
		}

	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void info(){
		System.out.println("��Ϣ���£�");
		System.out.println("������" + name);
		System.out.println("���䣺" + age);
		System.out.println("ְλ��" + position);
		System.out.println("нˮ��" + getSalary());
	}


}//end class
