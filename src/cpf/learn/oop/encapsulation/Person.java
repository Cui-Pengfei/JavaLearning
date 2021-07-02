package cpf.learn.oop.encapsulation;

import java.util.Scanner;

/**
 * 要求：
 *      不能随便查看人的年龄,工资等隐私,并对设置的年龄进行合理的验证。
 *      年龄合理就设置,否则给默认年龄,必须在1-120,
 *      年龄，工资不能直接查看，
 *      name的长度在2-6之间
 */
public class Person {

	//四个私有属性：姓名、年龄、职位、工资
	private String name;
	private int age;
	private String position;
	private Double salary;

	public static void main(String[] args) {
		Person jack = new Person();
		jack.setName("jack");
		jack.setAge(30);
		jack.setPosition("主管");
		jack.setSalary(30000);
		jack.info();

		//注意此处必须写12000.0因为属性中是Double，不能把int给Double,因为封装类Double只实现了double到Double.
		Person mary = new Person("mary", 22, "实习生", 1200.0);
		mary.info();



	}//end main

	public Person() {
	}

	/**
	 * 构造器与set方法的结合.
	 *      构造器快捷键alt+insert,在选择constructor.
	 *
	 *  总之让设置属性的语句均用set\get方法来实现，就一定能实现封装.
	 */

	public Person(String name, int age, String position, Double salary) {
		setName(name);
		setAge(age);
		setPosition(position);
		setSalary(salary);
	}

	/**
	 * get\set方法快捷键.
	 *      1.alt+insert 选择要get\set的方法，一键完成.
	 *
	 *      2.也可以把光标放在属性上，alt+enter可以出提示，
	 *        选择"create getter and setter for field 'name'"，
	 *        完成某一属性的get\set
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() >= 2 && name.length() <= 6){
			this.name = name;
		}else{
			System.out.println("输入名字有误，名字必须是[2,6]个字，给默认值“无名氏”");
			this.name = "无名氏";
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 120 && age >=1){
			this.age = age;
		}else{
			System.out.println("您设置的年龄有误，年龄必须在[1,120]范围内，给默认值18岁");
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
		System.out.print("请输入查看薪水密码：");
		Scanner scanner = new Scanner(System.in);
		String pwd = scanner.next();
		if(pwd.equals("1996818110")){
			return salary;
		}else{
			System.out.println("您输入的密码有误...");
			return null;
		}

	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void info(){
		System.out.println("信息如下：");
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);
		System.out.println("职位：" + position);
		System.out.println("薪水：" + getSalary());
	}


}//end class
